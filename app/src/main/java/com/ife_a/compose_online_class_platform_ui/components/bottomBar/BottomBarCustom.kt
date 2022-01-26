package com.ife_a.compose_online_class_platform_ui.components.bottomBar

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_primary
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_secondary


data class MenuData(
    val icon: ImageVector,
    val text: String
)

@Preview
@Composable
fun BottomBarCustom() {

    val listOfMenuItems = listOf(
        MenuData(icon = Icons.Filled.Home, "Home"),
        MenuData(icon = Icons.Filled.School, "School"),
        MenuData(icon = Icons.Filled.Star, "Saved"),
        MenuData(icon = Icons.Filled.Person, "Profile"),
    )

    Surface() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            listOfMenuItems.forEach {
                MyMenuItem(menuData = it, isSelected = it.text == "Home")
            }
        }
    }
}

@Composable
fun MyMenuItem(menuData: MenuData, isSelected: Boolean = false) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            imageVector = menuData.icon,
            contentDescription = null,
            tint = if (isSelected) md_theme_light_primary else md_theme_light_secondary.copy(0.4f)
        )
        Text(
            text = menuData.text,
            fontSize = MaterialTheme.typography.h6.fontSize,
            color = if (isSelected) md_theme_light_primary else md_theme_light_secondary.copy(0.4f)
        )
    }
}