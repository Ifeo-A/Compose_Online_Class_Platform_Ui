package com.ife_a.compose_online_class_platform_ui.destinations.destinationVideo

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

    var videoIsBuffering by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = navBarPadding.dp)
    ) {
        Column(
            modifier = Modifier
        ) {
            Box(
                modifier = Modifier
                    .background(color = Color.Gray)
                    .weight(0.6f)
                    .fillMaxWidth()
            ) {
                VideoPlayer(
                    videoUrls = classItemData?.videos?.map { classVideo ->
                        classVideo.videoUrl
                    } ?: emptyList(),
                    mediaItemIndex = classItemData?.videos?.indexOfFirst { it.videoId == currentVideo?.videoId }
                        ?: 0,
                    videoIsBuffering = { isBuffering -> videoIsBuffering = isBuffering },
                )
                if (videoIsBuffering) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center,
                        modifier = Modifier.fillMaxSize()
                    ) {
                        CircularProgressIndicator()
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