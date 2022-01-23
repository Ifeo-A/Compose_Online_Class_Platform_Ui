package com.ife_a.compose_online_class_platform_ui.components.destinations

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.ProvideWindowInsets
import com.ife_a.compose_online_class_platform_ui.components.CategoriesSection
import com.ife_a.compose_online_class_platform_ui.components.ClassesSection
import com.ife_a.compose_online_class_platform_ui.components.MyTopBar
import com.ife_a.compose_online_class_platform_ui.ui.theme.AppTheme
import com.ife_a.compose_online_class_platform_ui.utils.listOfCategoryItemDataSample
import com.ife_a.compose_online_class_platform_ui.utils.listOfClassListDataSample
import com.ife_a.compose_online_class_platform_ui.utils.toast

@Composable
fun DestinationHome() {
    val context = LocalContext.current

    val listOfCategories = listOfCategoryItemDataSample
    val listOfClassListData = listOfClassListDataSample

    ProvideWindowInsets(windowInsetsAnimationsEnabled = true) {
        AppTheme {
            ProvideWindowInsets {
                Surface(
                    color = MaterialTheme.colors.background,
                ) {
                    LazyColumn {
                        item {
                            MyTopBar()
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
                                },
                                viewAllButtonClicked = {
                                    toast(
                                        context = context,
                                        text = "View all $it"
                                    )
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true, heightDp = 800)
@Composable
fun DefaultPreview() {
    DestinationHome()
}