package com.ife_a.compose_online_class_platform_ui.destinations

import android.content.Context
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.LifecycleOwner
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.util.MimeTypes
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassItemData
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassVideo
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_highlight
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_onSecondary
import com.ife_a.compose_online_class_platform_ui.utils.*

@OptIn(ExperimentalMaterialApi::class)
@Preview(heightDp = 600, widthDp = 300)
@Composable
fun DestinationVideo(
    videoId: String = sampleClassItemDataProductivityClass.videos.first().videoId,
    videoClicked: () -> Unit = {},
    navBarPadding: Int = 0
) {

    // Find the class the video belongs to
    val classItemData: ClassItemData? = sampleListOfClassItemData.firstOrNull { classItemData ->
        // Find the video in the list of all classes where the video id matches the
        // video id passed to this composable.
        val video: ClassVideo? = classItemData.videos.find { classVideo: ClassVideo ->
            classVideo.videoId == videoId
        }
        video?.parentClassId == classItemData.classId
    }
    val currentVideo: ClassVideo? = classItemData?.videos?.firstOrNull { classVideo ->
        classVideo.videoId == videoId
    }

//    val videoPlaylist = listOf<MediaItem>(
//        MediaItem.Builder()
//            .setUri("https://www.youtube.com/api/manifest/dash/id/bf5bb2419360daf1/source/youtube?as=fmp4_audio_clear,fmp4_sd_hd_clear&sparams=ip,ipbits,expire,source,id,as&ip=0.0.0.0&ipbits=0&expire=19000000000&signature=51AF5F39AB0CEC3E5497CD9C900EBFEAECCCB5C7.8506521BFC350652163895D4C26DEE124209AA9E&key=ik0")
//            .setMimeType(MimeTypes.APPLICATION_MPD)
//            .build(),
//        MediaItem.fromUri("https://cdn.videvo.net/videvo_files/video/free/2020-01/large_watermarked/191126_2_HD_Party_Cropped_02_preview.mp4"),
//        MediaItem.fromUri("https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4")
//    )

    val videoPlaylist = classItemData?.videos?.map {
        MediaItem.fromUri(it.videoUrl)
    }?.toTypedArray()?.toList() ?: emptyList()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = navBarPadding.dp)
    ) {
        Column(
            modifier = Modifier
        ) {
            VideoPlayer(
                videoPlaylist = videoPlaylist,
                mediaItemIndex = classItemData?.videos?.indexOfFirst { it.videoId == currentVideo?.videoId }
                    ?: 0,
                modifier = Modifier
                    .background(color = Color.Gray)
                    .weight(0.6f)
                    .fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(24.dp))

            // More videos from class
            LazyColumn(
                modifier = Modifier
                    .weight(1f)
            ) {
                item {
                    classItemData?.videos?.forEach { classVideo ->
                        Spacer(modifier = Modifier.height(4.dp))
                        VideoCard(
                            videoTitle = classVideo.videoTitle,
                            videoDuration = getPlayTimeFromMillis(
                                classVideo.videoDuration
                            ),
                            teacherName = classItemData.classTeacher,
                            isCurrentlyPlaying = classVideo.videoId == currentVideo?.videoId,
                            videoClicked = videoClicked
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 300)
@Composable
fun VideoCard(
    isCurrentlyPlaying: Boolean = false,
    videoTitle: String = "Video title",
    videoDuration: String = "Duration",
    teacherName: String = "Duration",
    videoClicked: () -> Unit = {}
) {
    Surface(
        color = if (isCurrentlyPlaying) md_theme_highlight else md_theme_light_onSecondary,
        modifier = Modifier
            .fillMaxWidth()
            .clickable(
                onClick = { videoClicked() },
                interactionSource = remember { MutableInteractionSource() },
                indication = rememberRipple(bounded = true)
            )
    ) {
        Column(
            modifier = Modifier
                .height(80.dp)
                .padding(horizontal = 14.dp, vertical = 8.dp)
        ) {
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(text = videoTitle)
                Text(text = videoDuration)
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f)
            ) {
                Text(text = teacherName)
            }
        }
    }
}

@Composable
fun VideoPlayer(
    videoPlaylist: List<MediaItem>,
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