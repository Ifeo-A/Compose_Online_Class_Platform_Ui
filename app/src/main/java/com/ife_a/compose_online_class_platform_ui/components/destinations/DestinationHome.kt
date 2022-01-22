package com.ife_a.compose_online_class_platform_ui.components.destinations

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.statusBarsPadding
import com.ife_a.compose_online_class_platform_ui.components.*
import com.ife_a.compose_online_class_platform_ui.components.searchBar.ClassList
import com.ife_a.compose_online_class_platform_ui.components.searchBar.ClassListData
import com.ife_a.compose_online_class_platform_ui.ui.theme.AppTheme
import com.ife_a.compose_online_class_platform_ui.utils.repeat
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
                    imageSrc = "",
                    noOfStudents = 0,
                    classDuration = 3_600_000 + 1_800_000, //1hour in millis + 30mins in millis
                    classTitle = "Productivity Masterclass -Principles and Tools to Boost Your Productivity",
                    classTeacher = "Lindsey Donin",
                    isFavorite = false
                )
            ).repeat(4)
        ),
        ClassListData(
            headerTitle = "Popular classes",
            classDetails = listOf(
                ClassDetails(
                    imageSrc = "",
                    noOfStudents = 0,
                    classDuration = 3_600_000 + 1_800_000, //1hour in millis + 30mins in millis
                    classTitle = "Productivity Masterclass -Principles and Tools to Boost Your Productivity",
                    classTeacher = "Lindsey Donin",
                    isFavorite = false
                )
            ).repeat(4)
        )
    )

    ProvideWindowInsets(windowInsetsAnimationsEnabled = true) {
        val scrollState = rememberScrollState()
        AppTheme {
            ProvideWindowInsets {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier
                        .statusBarsPadding()
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .statusBarsPadding()
                    ) {
                        MyTopBar()
                        CategoriesSection(
                            categories = categories
                        ) {
                            toast(
                                context = context,
                                text = "$it clicked"
                            )
                        }
                        ClassesSection(listOfClassListData)
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, heightDp = 800)
@Composable
fun ClassesSection(listOfClassListData: List<ClassListData> = listOf()) {
    LazyColumn {
        items(items = listOfClassListData) { item: ClassListData ->
            ClassList(classListData = item)
        }
    }
}

@Preview(showBackground = true, heightDp = 800)
@Composable
fun DefaultPreview() {
    DestinationHome()
}