package com.ife_a.compose_online_class_platform_ui.destinations

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.ife_a.compose_online_class_platform_ui.components.CategoriesSection
import com.ife_a.compose_online_class_platform_ui.components.ClassesSection
import com.ife_a.compose_online_class_platform_ui.components.MyTopBar
import com.ife_a.compose_online_class_platform_ui.utils.sampleListOfCategories
import com.ife_a.compose_online_class_platform_ui.utils.sampleListOfClassListData
import com.ife_a.compose_online_class_platform_ui.utils.toast

@Preview(showBackground = true, showSystemUi = false, heightDp = 800)
@Composable
fun DestinationHome(
    notificationButtonClicked: () -> Unit = {},
    categoryClicked: (categoryId: String) -> Unit = {},
    viewAllButtonClicked: (sectionTitle: String) -> Unit = {},
    classItemClicked: (classId: String) -> Unit = {},
    classItemFavoriteButtonClicked: (classId: String) -> Unit = {},
) {
    val context = LocalContext.current

    val listOfCategories = sampleListOfCategories
    val listOfClassListData = sampleListOfClassListData

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .navigationBarsWithImePadding()
            .padding(bottom = 20.dp)
    ) {
        LazyColumn {
            item {
                MyTopBar(
                    userName = "Jack",
                    notificationButtonClicked = {
                        toast(
                            context = context,
                            text = "Notifications clicked"
                        )
                    }
                )
                CategoriesSection(
                    categories = listOfCategories,
                    viewAllButtonClicked = {
                        toast(
                            context = context,
                            text = "View all $it clicked"
                        )
                    },
                    categoryClicked = { categoryName: String ->
                        toast(
                            context = context,
                            text = "Category $categoryName clicked"
                        )

                        // Find category item data so I can get the Id from it using the category name
                        val categoryItemData = sampleListOfCategories.find {
                            it.categoryName == categoryName
                        }
                        categoryItemData?.let {
                            categoryClicked(it.categoryId)
                        }
                    }
                )
                ClassesSection(
                    listOfClassListData = listOfClassListData,
                    classListItemClicked = {
                        toast(
                            context = context,
                            text = "Class item with id $it clicked"
                        )
                        classItemClicked(it)
                    },
                    viewAllButtonClicked = {
                        toast(
                            context = context,
                            text = "View all $it"
                        )
                    },
                    classItemFavoriteButtonClicked = {
                        toast(
                            context = context,
                            text = "Toggle favorite for $it"
                        )
                    }
                )
            }
        }
    }
}