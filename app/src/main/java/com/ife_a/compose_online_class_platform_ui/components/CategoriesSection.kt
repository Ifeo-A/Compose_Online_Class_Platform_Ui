package com.ife_a.compose_online_class_platform_ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ife_a.compose_online_class_platform_ui.components.chip.MyChip
import com.ife_a.compose_online_class_platform_ui.components.headers.LazyRowHeader
import com.ife_a.compose_online_class_platform_ui.utils.sampleListOfCategories

data class CategoryItemData(
    val categoryId: String = "",
    val categoryName: String = ""
)

@Preview(name = "Categories Section", widthDp = 300)
@Composable
fun CategoriesSection(
    categories: List<CategoryItemData> = sampleListOfCategories,
    viewAllButtonClicked: (sectionTitle: String) -> Unit = {},
    categoryClicked: (categoryName: String) -> Unit = {}
){
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.padding(bottom = 30.dp)
    ) {
        Column{
            LazyRowHeader(
                headerText = "Categories",
                viewAllButtonClicked = viewAllButtonClicked
            )
            LazyRow{
                items(items = categories) { categoryItemData ->
                    MyChip(
                        text = categoryItemData.categoryName,
                        onClick = categoryClicked
                    )
                }
            }
        }
    }
}
