package com.ife_a.compose_online_class_platform_ui.utils

import com.ife_a.compose_online_class_platform_ui.components.CategoryItemData
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassItemData
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassListData
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassVideo


val listOfCategoryItemDataSample = listOf(
    CategoryItemData("", "🎨 Design"),
    CategoryItemData("", "👨‍🎨 Art"),
    CategoryItemData("", "‍🖥 Programming"),
    CategoryItemData("", "💻 Marketing"),
    CategoryItemData("", "📝 Writing"),
    CategoryItemData("", "🗿 History"),
    CategoryItemData("", "🧮 Maths"),
    CategoryItemData("", "🧑🏽‍ Science"),
    CategoryItemData("", "‍📈 Statistics"),
)

// SAMPLE CLASSES
// Sample ClassItemData for Theory of relativity classes
val sampleClassItemDataTheoryOfRelativityClass = ClassItemData(
    classId = "cat",
    imageSrc = "https://unsplash.com/photos/2Q3Ivd-HsaM/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8MzV8fGNsYXNzfGVufDB8fHx8MTY0Mjc2MjAzOQ&force=true&w=640",
    noOfStudents = 83,
    classTitle = "Theory of Relativity",
    classTeacher = "Diane Abbott",
    isFavorite = true,
    videos = listOf<ClassVideo>(
        ClassVideo(
            parentClassId = "cat",
            videoTitle = "Welcome to the Class",
            videoDuration = 210_000L,
            isFree = true,
        ),
        ClassVideo(
            parentClassId = "cat",
            videoTitle = "About the Class Project",
            videoDuration = 135_000L,
            isFree = false,
        )
    ),
    categoryId = "a410"
)

val sampleClassItemDataProductivityClass = ClassItemData(
    classId = "dog",
    imageSrc = "https://unsplash.com/photos/w9i7wMaM3EE/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8NDJ8fGNsYXNzfGVufDB8fHx8MTY0Mjc3MTg2Mg&force=true&w=640",
    noOfStudents = 0,
    classTitle = "Productivity Masterclass -Principles and Tools to Boost Your Productivity", //1hour in millis + 30mins in millis
    classTeacher = "Lindsey Donin",
    isFavorite = false,
    videos = listOf<ClassVideo>(
        ClassVideo(
            parentClassId = "dog",
            videoTitle = "Productivity class 1",
            videoDuration = 210_000L,
            isFree = true,
        ),
        ClassVideo(
            parentClassId = "cat",
            videoTitle = "Productivity class 2",
            videoDuration = 135_000L,
            isFree = false,
        )
    ),
    categoryId = "g794"
)

val sampleClassItemDataPhotographyClass = ClassItemData(
    classId = "ball",
    imageSrc = "https://unsplash.com/photos/N_aihp118p8/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8N3x8Y2xhc3N8fDB8fHx8MTY0Mjc2MjAwMw&force=true&w=640",
    noOfStudents = 2342,
    classTitle = "Photography Basics",
    classTeacher = "India Malone",
    isFavorite = true,
    videos = listOf<ClassVideo>(
        ClassVideo(
            parentClassId = "fish",
            videoTitle = "Photography class 1",
            videoDuration = 210_000L,
            isFree = true,
        ),
        ClassVideo(
            parentClassId = "fish",
            videoTitle = "Photography class 2",
            videoDuration = 135_000L,
            isFree = false,
        )
    ),
    categoryId = "a410"
)

// SAMPLE VIDEOS FOR A CLASS
val sampleTheoryOfRelativityClassVideos = listOf<ClassVideo>(
    ClassVideo(
        parentClassId = "cat",
        videoTitle = "Welcome to the Class",
        videoDuration = 210_000L,
        isFree = true,
    ),
    ClassVideo(
        parentClassId = "cat",
        videoTitle = "About the Class Project",
        videoDuration = 135_000L,
        isFree = false,
    )
)

val sampleProductivityClassVideos = listOf<ClassVideo>(
    ClassVideo(
        parentClassId = "dog",
        videoTitle = "Productivity class 1",
        videoDuration = 210_000L,
        isFree = true,
    ),
    ClassVideo(
        parentClassId = "dog",
        videoTitle = "Productivity class 2",
        videoDuration = 135_000L,
        isFree = false,
    )
)

val samplePhotographyClassVideos = listOf<ClassVideo>(
    ClassVideo(
        parentClassId = "fish",
        videoTitle = "Photography class 1",
        videoDuration = 210_000L,
        isFree = true,
    ),
    ClassVideo(
        parentClassId = "fish",
        videoTitle = "Photography class 2",
        videoDuration = 135_000L,
        isFree = false,
    )
)

val listOfClassDetailsSample = listOf(
    sampleClassItemDataTheoryOfRelativityClass,
    sampleClassItemDataProductivityClass,
    sampleClassItemDataPhotographyClass
)

val listOfClassListDataSample = listOf(
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
