package com.ife_a.compose_online_class_platform_ui.features.classes

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_onSecondary
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_secondary

@OptIn(ExperimentalMaterialApi::class)
@Preview
@Composable
fun ClassVideoBulletPoint(
    imageVector: ImageVector = Icons.Filled.PlayArrow,
    text: String = "4 - How to read 1:45"
) {
    Surface(
        shape = RoundedCornerShape(8.dp),
        color = md_theme_light_onSecondary,
        modifier = Modifier
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(8.dp)
                .fillMaxWidth()
        ) {
            Icon(
                imageVector = imageVector,
                contentDescription = null,
                modifier = Modifier.padding(end = 10.dp),
                tint = md_theme_light_secondary
            )
            Text(text = text)
        }
    }
}
