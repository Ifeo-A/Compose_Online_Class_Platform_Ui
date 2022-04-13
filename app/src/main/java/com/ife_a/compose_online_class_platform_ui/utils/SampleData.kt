package com.ife_a.compose_online_class_platform_ui.utils

import com.ife_a.compose_online_class_platform_ui.components.CategoryItemData
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassItemData
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassListData
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassVideo


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
        videoUrl = "https://cdn.videvo.net/videvo_files/video/free/2021-08/large_watermarked/210722_04_Festival_4k_018_preview.mp4",
        videoDuration = 210_000L,
        isFree = true,
    ),
    ClassVideo(
        parentClassId = "cat",
        videoId = "mohytor-g4tdg",
        videoTitle = "Preparation",
        videoUrl = "https://cdn.videvo.net/videvo_files/video/free/2020-01/large_watermarked/191126_2_HD_Party_Cropped_02_preview.mp4",
        videoDuration = 210_000L,
        isFree = true,
    ),
    ClassVideo(
        parentClassId = "cat",
        videoId = "lk[pkir94-24",
        videoTitle = "About the Class Project",
        videoUrl = "https://storage.googleapis.com/exoplayer-test-media-0/BigBuckBunny_320x180.mp4",
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
