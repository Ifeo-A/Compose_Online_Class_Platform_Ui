package com.ife_a.compose_online_class_platform_ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassVideo
import com.ife_a.compose_online_class_platform_ui.utils.getPlayTimeFromMillis

/* Shows a list of all the videos in a particular class */
@Composable
fun ClassVideoList(videoEntries: List<ClassVideo>) {
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
            Row() {
                ClassVideoBulletPoint(
                    imageVector = if (video.isFree) Icons.Filled.PlayArrow else Icons.Outlined.Lock,
                    text = "${index + 1} - ${video.videoTitle} ${
                        getPlayTimeFromMillis(
                            video.videoDuration,
                            true
                        )
                    }"
                )
            }
        }
    }
}
