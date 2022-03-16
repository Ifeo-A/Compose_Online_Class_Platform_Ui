package com.ife_a.compose_online_class_platform_ui.components.headers

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ife_a.compose_online_class_platform_ui.components.text.TitleLarge
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_gray
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_secondary

@Preview(showBackground = true)
@Composable
fun LazyRowHeader(
    headerText: String = "Header text",
    buttonText: String = "View all",
    viewAllButtonClicked: (buttonText: String) -> Unit = {}
){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ) {
        TitleLarge(text = headerText)
        TextButton(onClick = { viewAllButtonClicked(headerText) }) {
            Text(text = buttonText)
        }
    }
}