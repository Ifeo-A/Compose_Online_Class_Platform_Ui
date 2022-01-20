package com.ife_a.compose_online_class_platform_ui.components.buttons

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ife_a.compose_online_class_platform_ui.ui.theme.Shapes
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_gray

@Preview(name = "Icon button", widthDp = 36)
@Composable
fun MyIconButton(
    icon: ImageVector = Icons.Outlined.Image,
    imageButtonClicked: () -> Unit = {}
) {
    Surface(
        color = md_theme_light_gray,
        shape = Shapes.medium,
        modifier = Modifier.size(36.dp)
    ) {
        Row() {
            androidx.compose.material.IconButton(onClick = imageButtonClicked) {
                Icon(
                    imageVector = icon,
                    contentDescription = "",
                    tint = MaterialTheme.colors.onBackground
                )
            }
        }
    }
}