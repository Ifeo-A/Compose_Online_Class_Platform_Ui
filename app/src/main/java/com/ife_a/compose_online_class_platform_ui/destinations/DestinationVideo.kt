package com.ife_a.compose_online_class_platform_ui.destinations

import android.content.Context
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector
import com.google.android.exoplayer2.ui.StyledPlayerView
import com.google.android.exoplayer2.util.MimeTypes
import com.ife_a.compose_online_class_platform_ui.R
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

//    val playWhenReady by rememberSaveable { mutableStateOf(true) }
    var currentWindow = 0
    var playbackPosition = 0L

    val playlist by lazy {
        listOf<MediaItem>(
            MediaItem.Builder()
                .setUri("https://www.youtube.com/api/manifest/dash/id/bf5bb2419360daf1/source/youtube?as=fmp4_audio_clear,fmp4_sd_hd_clear&sparams=ip,ipbits,expire,source,id,as&ip=0.0.0.0&ipbits=0&expire=19000000000&signature=51AF5F39AB0CEC3E5497CD9C900EBFEAECCCB5C7.8506521BFC350652163895D4C26DEE124209AA9E&key=ik0")
                .setMimeType(MimeTypes.APPLICATION_MPD)
                .build(),
            MediaItem.fromUri("https://cdn.videvo.net/videvo_files/video/free/2020-01/large_watermarked/191126_2_HD_Party_Cropped_02_preview.mp4"),
            MediaItem.fromUri("https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4")
        )
    }

    val context = LocalContext.current

    val trackSelector = DefaultTrackSelector(context).apply {
        setParameters(buildUponParameters().setMaxVideoSizeSd())
    }
    val exoPlayer: ExoPlayer = remember {
        ExoPlayer.Builder(context)
            .setTrackSelector(trackSelector)
            .build().apply {
                playlist.forEach { mediaItem ->
                    this.addMediaItem(mediaItem)
                }
                playWhenReady = true
                seekTo(currentWindow, playbackPosition)
                prepare()
            }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = navBarPadding.dp)
    ) {
        Column(
            modifier = Modifier
        ) {
            DisposableEffect(
                // Video Player
                AndroidView(
                    modifier = Modifier
                        .background(color = Color.Gray)
                        .weight(0.6f)
                        .fillMaxSize(),
                    factory = { context: Context ->
                        StyledPlayerView(context).apply {
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
                    exoPlayer.apply {
                        playbackPosition = this.currentPosition
                        currentWindow = this.currentMediaItemIndex
                        playWhenReady = this.playWhenReady
//                        removeListener(playbackStateListener)
                        release()
                    }
                }
            }

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
fun VideoPlayer() {
//    val context = LocalContext.current
//
//    val trackSelector = DefaultTrackSelector(context).apply {
//        setParameters(buildUponParameters().setMaxVideoSizeSd())
//    }
//    val exoPlayer: ExoPlayer = rememberSaveable {
//        ExoPlayer.Builder(context)
//            .setTrackSelector(trackSelector)
//            .build()
//    }
//
//    DisposableEffect(
//        // Video Player
//        AndroidView(
//            modifier = Modifier
//                .background(color = Color.Gray)
//                .weight(0.6f)
//                .fillMaxWidth(),
//            factory = { context: Context ->
//                ImageView(context).apply {
//                    val drawable = ContextCompat.getDrawable(
//                        context,
//                        R.drawable.ic_launcher_background
//                    )
//                    setImageDrawable(drawable)
//                }
//            },
//
//        )
//    ){
//        onDispose {
//            exoPlayer.release()
//        }
//    }
}