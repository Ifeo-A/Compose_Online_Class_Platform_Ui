package com.ife_a.compose_online_class_platform_ui.destinations.destinationHome

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.ife_a.compose_online_class_platform_ui.components.topBar.MyTopBar
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassItem
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassItemData
import com.ife_a.compose_online_class_platform_ui.utils.sampleListOfCategories
import com.ife_a.compose_online_class_platform_ui.utils.sampleListOfClassItemData
import com.ife_a.compose_online_class_platform_ui.utils.sampleListOfClassListData
import com.ife_a.compose_online_class_platform_ui.utils.toast

sealed class ClassState {
    data class ShowClassesByCategory(val categoryId: String) : ClassState()
    object ShowDefaultClasses : ClassState()
}

@Preview(showBackground = true, showSystemUi = false, heightDp = 800)
@Composable
fun DestinationHome(
    navBarPadding: Int = 0,
    notificationButtonClicked: () -> Unit = {},
    viewAllButtonClicked: (sectionTitle: String) -> Unit = {},
    classItemClicked: (classId: String) -> Unit = {},
    classItemFavoriteButtonClicked: (classId: String) -> Unit = {},
) {
    val context = LocalContext.current

    val listOfCategories = sampleListOfCategories
    val listOfClassListData = sampleListOfClassListData
    val listOfClasses = sampleListOfClassItemData

    var classesView by remember { mutableStateOf<ClassState>(ClassState.ShowDefaultClasses) }

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
                            classesView = if (it.categoryId == "all") {
                                ClassState.ShowDefaultClasses
                            } else {
                                ClassState.ShowClassesByCategory(it.categoryId)
                            }
                        }
                    }
                )
                when (classesView) {
                    is ClassState.ShowDefaultClasses -> {
                        println("Show default classes")
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

                    is ClassState.ShowClassesByCategory -> {
                        val categoryId =
                            (classesView as ClassState.ShowClassesByCategory).categoryId

                        val classesForCategory = listOfClasses.filter {
                            it.categoryItemData.categoryId == categoryId
                        }

                        Column(
                            modifier = Modifier
                                .padding(bottom = navBarPadding.dp)
                        ) {
                            classesForCategory.forEach { item: ClassItemData ->
                                ClassItem(
                                    classItemData = item,
                                    onClassItemClick = {
                                        classItemClicked(it)
                                    },
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(start = 10.dp, end = 10.dp, bottom = 20.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}