package com.ife_a.compose_online_class_platform_ui.utils

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.School
import androidx.compose.material.icons.filled.Star
import com.ife_a.compose_online_class_platform_ui.components.bottomBar.MenuData
import com.ife_a.compose_online_class_platform_ui.destinations.destinationHome.CategoryItemData
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassItemData
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassListData
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassVideo

val sampleListOfMenuItems = listOf(
    MenuData(icon = Icons.Filled.Home, "Home"),
    MenuData(icon = Icons.Filled.School, "Browse"),
    MenuData(icon = Icons.Filled.Star, "Saved"),
    MenuData(icon = Icons.Filled.Person, "Profile"),
)

val sampleListOfCategories = listOf(
    CategoryItemData("all", "☂️ All"),
    CategoryItemData("des", "🎨 Design"),
    CategoryItemData("art", "👨‍🎨 Art"),
    CategoryItemData("prog", "‍🖥 Programming"),
    CategoryItemData("mark", "💻 Marketing"),
    CategoryItemData("wri", "📝 Writing"),
    CategoryItemData("his", "🗿 History"),
    CategoryItemData("mts", "🧮 Maths"),
    CategoryItemData("scs", "🧑🏽‍ Science"),
    CategoryItemData("stats", "‍📈 Statistics"),
)

// SAMPLE VIDEOS FOR A CLASS
val sampleTheoryOfRelativityClassVideos = listOf<ClassVideo>(
    ClassVideo(
        parentClassId = "cat",
        videoId = "ergfdgp-ergwr34",
        videoTitle = "Class intro",
        videoUrl = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/BigBuckBunny.mp4",
        videoDuration = 210_000L,
        isFree = true,
    ),
    ClassVideo(
        parentClassId = "cat",
        videoId = "mohytor-g4tdg",
        videoTitle = "Preparation",
        videoUrl = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4",
        videoDuration = 210_000L,
        isFree = true,
    ),
    ClassVideo(
        parentClassId = "cat",
        videoId = "lk[pkir94-24",
        videoTitle = "About the Class Project",
        videoUrl = "http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/Sintel.mp4",
        videoDuration = 135_000L,
        isFree = false,
    )
)

val sampleProductivityClassVideos = listOf<ClassVideo>(
    ClassVideo(
        parentClassId = "dog",
        videoId = "rtrtg-tgth",
        videoTitle = "Welcome to the Class",
        videoUrl = "",
        videoDuration = 210_000L,
        isFree = true,
    ),
    ClassVideo(
        parentClassId = "dog",
        videoId = "kmbopo-cvn",
        videoTitle = "About the Class Project",
        videoUrl = "",
        videoDuration = 135_000L,
        isFree = false,
    ),
    ClassVideo(
        parentClassId = "dog",
        videoId = "ergerg-83620",
        videoTitle = "Healthy routines",
        videoUrl = "",
        videoDuration = 224_000L,
        isFree = false,
    ),
    ClassVideo(
        parentClassId = "dog",
        videoId = "loii-33f3g",
        videoTitle = "10 ways to learn faster",
        videoUrl = "",
        videoDuration = 224_000L,
        isFree = false,
    ),
    ClassVideo(
        parentClassId = "dog",
        videoId = "rgeo0534-24",
        videoTitle = "Why you need more sleep",
        videoUrl = "",
        videoDuration = 224_000L,
        isFree = false,
    ),
    ClassVideo(
        parentClassId = "dog",
        videoId = "ncigoslk-947",
        videoTitle = "How to read",
        videoUrl = "",
        videoDuration = 224_000L,
        isFree = false,
    ),
)

val samplePhotographyClassVideos = listOf<ClassVideo>(
    ClassVideo(
        parentClassId = "fish",
        videoId = "ljnno0i-9rikledg",
        videoTitle = "Photography class 1",
        videoUrl = "",
        videoDuration = 210_000L,
        isFree = true,
    ),
    ClassVideo(
        parentClassId = "fish",
        videoId = "14309fjv-sg4",
        videoTitle = "Photography class 2",
        videoUrl = "",
        videoDuration = 135_000L,
        isFree = false,
    )
)

val sampleListAllClassVideos = listOf<ClassVideo>(
    *sampleTheoryOfRelativityClassVideos.toTypedArray(),
    *sampleProductivityClassVideos.toTypedArray(),
    *samplePhotographyClassVideos.toTypedArray()
)

// SAMPLE CLASSES
// Sample ClassItemData for Theory of relativity classes
val sampleClassItemDataTheoryOfRelativityClass = ClassItemData(
    classId = "cat",
    imageSrc = "https://unsplash.com/photos/2Q3Ivd-HsaM/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8MzV8fGNsYXNzfGVufDB8fHx8MTY0Mjc2MjAzOQ&force=true&w=640",
    noOfStudents = 83,
    categoryItemData = sampleListOfCategories.find { it.categoryId == "scs" }!!,
    classTitle = "Theory of Relativity",
    classTeacher = "Diane Abbott",
    isFavorite = true,
    videos = sampleTheoryOfRelativityClassVideos
)

val sampleClassItemDataProductivityClass = ClassItemData(
    classId = "dog",
    imageSrc = "https://unsplash.com/photos/w9i7wMaM3EE/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8NDJ8fGNsYXNzfGVufDB8fHx8MTY0Mjc3MTg2Mg&force=true&w=640",
    noOfStudents = 0,
    categoryItemData = sampleListOfCategories.find { it.categoryId == "wri" }!!,
    classTitle = "Productivity Masterclass -Principles and Tools to Boost Your Productivity", //1hour in millis + 30mins in millis
    classTeacher = "Lindsey Donin",
    isFavorite = false,
    videos = sampleProductivityClassVideos
)

val sampleClassItemDataPhotographyClass = ClassItemData(
    classId = "fish",
    imageSrc = "https://unsplash.com/photos/N_aihp118p8/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8N3x8Y2xhc3N8fDB8fHx8MTY0Mjc2MjAwMw&force=true&w=640",
    noOfStudents = 2342,
    categoryItemData = sampleListOfCategories.find { it.categoryId == "scs" }!!,
    classTitle = "Photography Basics",
    classTeacher = "India Malone",
    isFavorite = true,
    videos = samplePhotographyClassVideos
)

val sampleListOfClassItemData = listOf(
    sampleClassItemDataTheoryOfRelativityClass,
    sampleClassItemDataProductivityClass,
    sampleClassItemDataPhotographyClass
)

val sampleListOfClassListData = listOf(
    ClassListData(
        headerTitle = "Featured classes",
        classDetails = listOf(
            sampleClassItemDataTheoryOfRelativityClass,
            sampleClassItemDataProductivityClass
        )
    ),
    ClassListData(
        headerTitle = "Popular classes",
        classDetails = listOf(
            sampleClassItemDataTheoryOfRelativityClass,
            sampleClassItemDataPhotographyClass,
        )
    )
)
