package com.ife_a.compose_online_class_platform_ui.components.video

import android.content.Context
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.MediaMetadata
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.TrackGroupArray
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.trackselection.TrackSelectionArray
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassVideo


@Composable
fun VideoPlayer(
    mediaItems: List<MediaItem>,
    /** Indicates which media item in the playlist to play first */
    mediaItemIndex: Int,
    videoIsBuffering: (isBuffering: Boolean) -> Unit,
    videoTrackChanged: (mediaId: String) -> Unit = {},
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current

    var currentPlaybackPosition by rememberSaveable { mutableStateOf(0L) }
    var currentMediaItemIndex by rememberSaveable { mutableStateOf(mediaItemIndex) }

    val trackSelector = DefaultTrackSelector(context).apply {
        setParameters(buildUponParameters().setMaxVideoSizeSd())
    }

    val videoStateListener: Player.Listener = object : Player.Listener {

        override fun onPlaybackStateChanged(playbackState: Int) {

            val stateString: String = when (playbackState) {
                ExoPlayer.STATE_IDLE -> {
                    videoIsBuffering(true)
                    "ExoPlayer.STATE_IDLE"
                }
                ExoPlayer.STATE_BUFFERING -> {
                    videoIsBuffering(true)
                    "ExoPlayer.STATE_BUFFERING"
                }
                ExoPlayer.STATE_READY -> {
                    videoIsBuffering(false)
                    "ExoPlayer.STATE_READY"
                }
                ExoPlayer.STATE_ENDED -> {
                    videoIsBuffering(false)
                    "ExoPlayer.STATE_ENDED"
                }
                else -> {
                    videoIsBuffering(true)
                    "UNKNOWN_STATE"
                }
            }
            println("Video state: $stateString")
        }

        override fun onMediaItemTransition(mediaItem: MediaItem?, reason: Int) {
            val currentMediaItem = mediaItems.find {
                it.mediaMetadata.displayTitle == mediaItem?.mediaId
            }
            currentMediaItemIndex = mediaItems.indexOf(currentMediaItem)
            currentMediaItem?.mediaId?.let { mediaId: String ->
                videoTrackChanged(mediaId)
            }
            println("Media item changed to index [$currentMediaItemIndex]: ${mediaItem?.mediaMetadata?.displayTitle}")
        }
    }

    val exoPlayer: ExoPlayer = remember {
        ExoPlayer.Builder(context)
            .setTrackSelector(trackSelector)
            .build().apply {
                mediaItems.forEach { mediaItem -> this.addMediaItem(mediaItem) }
                addListener(videoStateListener)
                seekTo(currentMediaItemIndex, currentPlaybackPosition)
                playWhenReady = true
                prepare()
            }
    }

    LocalLifecycleOwner.current.lifecycle.addObserver(object : DefaultLifecycleObserver {
        override fun onStart(owner: LifecycleOwner) {
            super.onStart(owner)
            if (!exoPlayer.isPlaying) {
                exoPlayer.play()
            }
        }

        override fun onStop(owner: LifecycleOwner) {
            super.onStop(owner)
            exoPlayer.release()
        }
    })

    DisposableEffect(
        // Video Player
        AndroidView(
            modifier = modifier,
            factory = { ctx: Context ->
                StyledPlayerView(ctx).apply {
                    player = exoPlayer
                    layoutParams =
                        FrameLayout.LayoutParams(
                            ViewGroup.LayoutParams.MATCH_PARENT,
                            ViewGroup.LayoutParams.MATCH_PARENT
                        )
                }
            },

            )
    ) {
        onDispose {
            // Save the current position and the current
            currentPlaybackPosition = exoPlayer.currentPosition
            currentMediaItemIndex = exoPlayer.currentMediaItemIndex
            exoPlayer.release()
        }
    }
}