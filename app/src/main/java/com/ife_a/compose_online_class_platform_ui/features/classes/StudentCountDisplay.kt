package com.ife_a.compose_online_class_platform_ui.features.classes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ife_a.compose_online_class_platform_ui.ui.theme.Shapes
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_gray
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_secondary

@Preview(showBackground = true)
@Composable
fun StudentCountDisplay(noOfStudents: Int = 0, showBackground: Boolean = false) {
    Surface(
        color = if (showBackground) md_theme_light_gray else MaterialTheme.colors.surface,
        shape = Shapes.medium,
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(4.dp)
        ) {
            Image(
                imageVector = Icons.Outlined.PersonOutline,
                contentDescription = null,
                colorFilter = ColorFilter.tint(
                    color = md_theme_light_secondary,
                )
            )
            Text(text = "$noOfStudents students", color = md_theme_light_secondary)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun StudentCountDisplayWithBackground() {
    StudentCountDisplay(0, true)
}

