package com.ife_a.compose_online_class_platform_ui.components.text

import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview

@Preview(showBackground = true)
@Composable
fun TitleLarge(text: String = "Header text") {
    Text(
        text = text,
        style = MaterialTheme.typography.h4,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        fontWeight = FontWeight.Bold
    )
}

@Preview(showBackground = true)
@Composable
fun TitleMedium(text: String = "Header text") {
    Text(
        text = text,
        style = MaterialTheme.typography.h5,
        maxLines = 2,
        overflow = TextOverflow.Ellipsis,
        fontWeight = FontWeight.Bold
    )
}

