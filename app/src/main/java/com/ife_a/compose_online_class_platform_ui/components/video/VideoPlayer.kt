package com.ife_a.compose_online_class_platform_ui.components.video

import android.content.Context
import android.provider.MediaStore
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.StyledPlayerView

@Composable
fun VideoPlayer(
    videoUrls: List<String>,
    /** Indicates which media item in the playlist to play first */
    mediaItemIndex: Int,
    modifier: Modifier
) {
    val context = LocalContext.current

    var currentPlaybackPosition by rememberSaveable { mutableStateOf(0L) }
    var currentMediaItemIndex by rememberSaveable { mutableStateOf(mediaItemIndex) }

    val trackSelector = DefaultTrackSelector(context).apply {
        setParameters(buildUponParameters().setMaxVideoSizeSd())
    }

    val videoPlaylist = videoUrls.map { videoUrl -> MediaItem.fromUri(videoUrl) }

    val exoPlayer: ExoPlayer = remember {
        ExoPlayer.Builder(context)
            .setTrackSelector(trackSelector)
            .build().apply {
                videoPlaylist.forEach { mediaItem -> this.addMediaItem(mediaItem) }
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