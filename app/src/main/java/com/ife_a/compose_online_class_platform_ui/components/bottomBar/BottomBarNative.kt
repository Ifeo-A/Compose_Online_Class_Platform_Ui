package com.ife_a.compose_online_class_platform_ui.components.bottomBar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_primary
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_secondary

sealed class NavigationItem(var route: String, var icon: ImageVector, var title: String) {
    object Home : NavigationItem("home", Icons.Filled.Home, "Home")
    object Music : NavigationItem("music", Icons.Filled.School, "School")
    object Movies : NavigationItem("movies", Icons.Filled.Star, "Saved")
    object Profile : NavigationItem("profile", Icons.Filled.Person, "Profile")
}

@Preview(showBackground = true)
@Composable
fun BottomNavigationBar() {
    val items = listOf(
        NavigationItem.Home,
        NavigationItem.Music,
        NavigationItem.Movies,
        NavigationItem.Profile
    )

    Surface {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .height(60.dp)
        ) {
            BottomNavigation(
                modifier = Modifier
                    .padding(horizontal = 34.dp),
                backgroundColor = Color.Transparent,
                contentColor = md_theme_light_secondary,
                elevation = 0.dp
            ) {
                items.forEach { menuItem ->
                    BottomNavigationItem(
                        icon = {
                            Icon(
                                modifier = Modifier.noRippleClickable { },
                                imageVector = menuItem.icon,
                                contentDescription = menuItem.title,
                            )
                        },
                        label = { Text(text = menuItem.title) },
                        selectedContentColor = md_theme_light_primary,
                        unselectedContentColor = md_theme_light_secondary.copy(0.4f),
                        alwaysShowLabel = true,
                        selected = menuItem.route == "home",
                        onClick = {
                        }
                    )
                }
            }

        }

    }

}

inline fun Modifier.noRippleClickable(crossinline onClick: () -> Unit): Modifier = composed {
    clickable(
        indication = null,
        interactionSource = remember { MutableInteractionSource() }) {
        onClick()
    }
}