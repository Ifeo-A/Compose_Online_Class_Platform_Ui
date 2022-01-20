package com.ife_a.compose_online_class_platform_ui.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ife_a.compose_online_class_platform_ui.components.buttons.MyIconButton
import com.ife_a.compose_online_class_platform_ui.components.searchBar.MySearchBar
import com.ife_a.compose_online_class_platform_ui.ui.theme.AppTheme
import com.ife_a.compose_online_class_platform_ui.ui.theme.Shapes

@Preview(name = "Top bar", widthDp = 300)
@Composable
fun MyTopBar(
    name: String = "Jack"
) {
    var searchValue by remember { mutableStateOf("") }

    AppTheme {
        Surface(
            color = MaterialTheme.colors.primary,
            shape = Shapes.large,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(start = 10.dp, top = 30.dp, end = 10.dp, bottom = 20.dp)
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 0.dp, top = 0.dp, end = 0.dp, bottom = 30.dp)

                ) {
                    Column() {
                        Text(text = "Hi, $name ✋")
                        Text(text = "Let's start learning!")
                    }
                    MyIconButton(icon = Icons.Outlined.Notifications)
                }
                MySearchBar(searchValue = searchValue) { searchValue = it }
            }
        }
    }
}