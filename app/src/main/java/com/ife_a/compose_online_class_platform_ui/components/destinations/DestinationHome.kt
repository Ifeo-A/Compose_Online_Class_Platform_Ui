package com.ife_a.compose_online_class_platform_ui.components.destinations

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.ProvideWindowInsets
import com.ife_a.compose_online_class_platform_ui.components.CategoriesSection
import com.ife_a.compose_online_class_platform_ui.components.ClassDetails
import com.ife_a.compose_online_class_platform_ui.components.ClassesSection
import com.ife_a.compose_online_class_platform_ui.components.MyTopBar
import com.ife_a.compose_online_class_platform_ui.components.searchBar.ClassListData
import com.ife_a.compose_online_class_platform_ui.ui.theme.AppTheme
import com.ife_a.compose_online_class_platform_ui.utils.toast

@Composable
fun DestinationHome() {
    val context = LocalContext.current

    val categories = listOf(
        "🎨 Design",
        "👨‍🎨 Art",
        "‍🖥 Programming",
        "💻 Marketing",
        "📝 Writing",
        "🗿 History",
        "🧮 Maths",
        "🧑🏽‍ Science",
        "‍📈 Statistics"
    )

    val listOfClassListData = listOf(
        ClassListData(
            headerTitle = "Featured classes",
            classDetails = listOf(
                ClassDetails(
                    classId = "apple",
                    imageSrc = "",
                    noOfStudents = 0,
                    classDuration = 3_600_000 + 1_800_000, //1hour in millis + 30mins in millis
                    classTitle = "Productivity Masterclass -Principles and Tools to Boost Your Productivity",
                    classTeacher = "Lindsey Donin",
                    isFavorite = false
                ),
                ClassDetails(
                    classId = "ball",
                    imageSrc = "",
                    noOfStudents = 0,
                    classDuration = 3_600_000 + 1_800_000, //1hour in millis + 30mins in millis
                    classTitle = "Productivity Masterclass -Principles and Tools to Boost Your Productivity",
                    classTeacher = "Lindsey Donin",
                    isFavorite = false
                ),
            )
        ),
        ClassListData(
            headerTitle = "Popular classes",
            classDetails = listOf(
                ClassDetails(
                    classId = "cat",
                    imageSrc = "",
                    noOfStudents = 0,
                    classDuration = 3_600_000 + 1_800_000, //1hour in millis + 30mins in millis
                    classTitle = "Productivity Masterclass -Principles and Tools to Boost Your Productivity",
                    classTeacher = "Lindsey Donin",
                    isFavorite = false
                ),
                ClassDetails(
                    classId = "dog",
                    imageSrc = "",
                    noOfStudents = 0,
                    classDuration = 3_600_000 + 1_800_000, //1hour in millis + 30mins in millis
                    classTitle = "Productivity Masterclass -Principles and Tools to Boost Your Productivity",
                    classTeacher = "Lindsey Donin",
                    isFavorite = false
                ),
            )
        )
    )

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
                                categories = categories,
                                viewAllButtonClicked = {
                                    toast(
                                        context = context,
                                        text = "$it clicked"
                                    )
                                }
                            )
                            ClassesSection(
                                listOfClassListData = listOfClassListData,
                                classListItemClicked = {
                                    println("Class item with id $it clicked")
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, heightDp = 800)
@Composable
fun DefaultPreview() {
    DestinationHome()
}