package com.ife_a.compose_online_class_platform_ui.components.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_secondary

@Preview(showBackground = true)
@Composable
fun Subtitle(text: String = "Subtitle text") {
    Text(
        text = text,
        color = md_theme_light_secondary,
        style = MaterialTheme.typography.h5
    )
}