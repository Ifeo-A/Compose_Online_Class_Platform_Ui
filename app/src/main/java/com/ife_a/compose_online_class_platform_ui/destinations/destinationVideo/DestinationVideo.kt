package com.ife_a.compose_online_class_platform_ui.destinations.destinationVideo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.exoplayer2.MediaItem
import com.ife_a.compose_online_class_platform_ui.components.video.VideoCard
import com.ife_a.compose_online_class_platform_ui.components.video.VideoPlayer
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassItemData
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassVideo
import com.ife_a.compose_online_class_platform_ui.utils.getPlayTimeFromMillis
import com.ife_a.compose_online_class_platform_ui.utils.sampleClassItemDataProductivityClass
import com.ife_a.compose_online_class_platform_ui.utils.sampleListOfClassItemData

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

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = navBarPadding.dp)
    ) {
        Column(
            modifier = Modifier
        ) {
            VideoPlayer(
                videoUrls = classItemData?.videos?.map { classVideo ->
                    classVideo.videoUrl
                } ?: emptyList(),
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