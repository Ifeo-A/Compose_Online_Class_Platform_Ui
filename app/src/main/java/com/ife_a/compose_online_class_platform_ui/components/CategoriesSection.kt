package com.ife_a.compose_online_class_platform_ui.components

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ife_a.compose_online_class_platform_ui.ui.theme.AppTheme

@Preview(name = "Categories Section", widthDp = 300)
@Composable
fun CategoriesSection(
    categories: List<String> = listOf("👋🏼 hello".repeat(3)),
    viewAllClicked: (buttonText: String) -> Unit = {}
){
    val context = LocalContext.current

    AppTheme() {
        Surface(
            color = MaterialTheme.colors.background
        ) {
            Column() {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(text = "Categories", style = MaterialTheme.typography.h4)
                    TextButton(onClick = {viewAllClicked("View all")}) {
                        Text(text = "View all")
                    }
                }
                LazyRow{
                    items(items = categories){ text ->
                        MyChip(text = text){
                            Toast.makeText(
                                context,
                                "$it clicked",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
                }
            }
        }
    }
}