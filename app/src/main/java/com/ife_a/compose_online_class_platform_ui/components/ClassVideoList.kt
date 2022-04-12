package com.ife_a.compose_online_class_platform_ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassVideo
import com.ife_a.compose_online_class_platform_ui.utils.getPlayTimeFromMillis
import com.ife_a.compose_online_class_platform_ui.utils.sampleProductivityClassVideos

/* Shows a list of all the videos in a particular class */
@Preview
@Composable
fun ClassVideoList(
    videoEntries: List<ClassVideo> = sampleProductivityClassVideos,
    classVideoClicked: (videoId: String) -> Unit = {}
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 20.dp)
    ) {

        val totalVideosDuration = videoEntries.sumOf { video -> video.videoDuration }

        Row() {
            Text(
                text = "${videoEntries.size} Lessons (${getPlayTimeFromMillis(totalVideosDuration)})",
                fontWeight = FontWeight.Bold,
                fontSize = 18.sp,
                modifier = Modifier
                    .padding(top = 10.dp, bottom = 8.dp)
            )
        }

        videoEntries.forEachIndexed() { index, video ->
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier
                    .clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = rememberRipple(),
                        onClick = {
                            println("Class video clicked ${video.videoId}")
                            classVideoClicked(video.videoId)
                        }
                    )
            ) {
                ClassVideoBulletPoint(
                    imageVector = if (video.isFree) Icons.Filled.PlayArrow else Icons.Outlined.Lock,
                    text = "${index + 1} - ${video.videoTitle} ${
                        getPlayTimeFromMillis(video.videoDuration, true)
                    }"
                )
            }
            Spacer(modifier = Modifier.height(4.dp))

        }
    }
}
