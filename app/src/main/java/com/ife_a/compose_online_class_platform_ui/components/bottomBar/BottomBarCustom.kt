package com.ife_a.compose_online_class_platform_ui.components.bottomBar

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.compose.ui.unit.dp
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_primary
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_secondary
import com.ife_a.compose_online_class_platform_ui.utils.sampleListOfMenuItems


data class MenuData(
    val icon: ImageVector,
    val text: String
)

@Composable
fun BottomBarCustom(
    menuItems: List<MenuData>,
    onMenuItemClicked: (menuTitle: String) -> Unit
) {

    var selectedMenuItem by remember { mutableStateOf("Home") }


    Surface() {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            menuItems.forEach { menuItemData ->
                MyMenuItem(
                    menuData = menuItemData,
                    isSelected = menuItemData.text == selectedMenuItem,
                    menuItemClicked = {
                        selectedMenuItem = menuItemData.text
                        onMenuItemClicked(menuItemData.text)
                    }
                )
            }
        }
    }
}


@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MyMenuItem(
    menuData: MenuData,
    isSelected: Boolean = false,
    menuItemClicked: () -> Unit
) {
    Surface(
        shape = CircleShape,
        onClick = { menuItemClicked() },
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(12.dp),
        ) {
            Icon(
                imageVector = menuData.icon,
                contentDescription = null,
                tint = if (isSelected) md_theme_light_primary else md_theme_light_secondary.copy(
                    0.4f
                )
            )
            Text(
                text = menuData.text,
                fontSize = MaterialTheme.typography.h6.fontSize,
                color = if (isSelected) md_theme_light_primary else md_theme_light_secondary.copy(
                    0.4f
                )
            )
        }
    }
}

data class MyMenuItemPreviewData(
    val menuData: MenuData,
    val isSelected: Boolean,
    val menuItemClicked: () -> Unit
)

class MyMenuItemPreviewParameterProvider : PreviewParameterProvider<MyMenuItemPreviewData> {
    override val values: Sequence<MyMenuItemPreviewData> =
        sequenceOf(
            MyMenuItemPreviewData(
                menuData = sampleListOfMenuItems.first { it.text == "Home" },
                isSelected = false,
                menuItemClicked = {}
            ),
            MyMenuItemPreviewData(
                menuData = sampleListOfMenuItems.first { it.text == "Home" },
                isSelected = true,
                menuItemClicked = {}
            )
        )
}

@Preview
@Composable
fun PreviewBottomBarCustom() {
    BottomBarCustom(
        menuItems = sampleListOfMenuItems,
        onMenuItemClicked = {
            println("Menu $it clicked")
        }
    )
}

@Preview(name = "Preview MyMenu states", showBackground = true)
@Composable
fun PreviewMenuItem(
    @PreviewParameter(MyMenuItemPreviewParameterProvider::class) previewData: MyMenuItemPreviewData
) {
    MyMenuItem(
        menuData = previewData.menuData,
        isSelected = previewData.isSelected,
        menuItemClicked = previewData.menuItemClicked
    )
}