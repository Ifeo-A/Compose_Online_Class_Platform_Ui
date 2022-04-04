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
import com.ife_a.compose_online_class_platform_ui.utils.listOfCategoryItemDataSample
import com.ife_a.compose_online_class_platform_ui.utils.listOfClassListDataSample
import com.ife_a.compose_online_class_platform_ui.utils.toast

@Preview(showBackground = true, showSystemUi = false, heightDp = 800)
@Composable
fun DestinationHome(
    classItemClicked: (classId: String) -> Unit = {}
) {
    val context = LocalContext.current

    val listOfCategories = listOfCategoryItemDataSample
    val listOfClassListData = listOfClassListDataSample

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
                    categoryClicked = {
                        toast(
                            context = context,
                            text = "Category $it clicked"
                        )
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