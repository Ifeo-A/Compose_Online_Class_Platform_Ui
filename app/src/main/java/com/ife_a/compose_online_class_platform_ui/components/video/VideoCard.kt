package com.ife_a.compose_online_class_platform_ui.components.video

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_highlight
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_onSecondary

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