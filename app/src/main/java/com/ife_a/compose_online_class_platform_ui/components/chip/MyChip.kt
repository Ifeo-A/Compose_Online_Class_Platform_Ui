package com.ife_a.compose_online_class_platform_ui.components.chip

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ife_a.compose_online_class_platform_ui.ui.theme.ShapesV2
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_onPrimary


@Preview(name = "Chip")
@Composable
fun MyChip(
    icon: ImageVector = Icons.Outlined.Image,
    text: String = "🎉 Party",
    onClick: (text: String) -> Unit = {}
){
    Card (
        backgroundColor = md_theme_light_onPrimary,
        shape = ShapesV2.large,
        modifier = Modifier
            .padding(6.dp)
            .clickable { onClick(text) },
        elevation = 4.dp
    ){
        Row(
            modifier = Modifier.padding(8.dp),
            horizontalArrangement = Arrangement.Center
        ) {
            Text(text = text)
        }
    }
}