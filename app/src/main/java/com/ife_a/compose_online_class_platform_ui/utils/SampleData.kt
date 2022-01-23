package com.ife_a.compose_online_class_platform_ui.utils

import com.ife_a.compose_online_class_platform_ui.components.CategoryItemData
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassItemData
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassListData


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

val listOfClassDetailsSample = listOf(
    ClassItemData(
        classId = "cat",
        imageSrc = "https://unsplash.com/photos/2Q3Ivd-HsaM/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8MzV8fGNsYXNzfGVufDB8fHx8MTY0Mjc2MjAzOQ&force=true&w=640",
        noOfStudents = 0,
        classDuration = 8860040,
        classTitle = "Theory of Relativity",
        classTeacher = "Diane Abbott",
        isFavorite = true
    ),
    ClassItemData(
        classId = "dog",
        imageSrc = "https://unsplash.com/photos/w9i7wMaM3EE/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8NDJ8fGNsYXNzfGVufDB8fHx8MTY0Mjc3MTg2Mg&force=true&w=640",
        noOfStudents = 0,
        classDuration = 1860600, //1hour in millis + 30mins in millis
        classTitle = "Productivity Masterclass -Principles and Tools to Boost Your Productivity",
        classTeacher = "Lindsey Donin",
        isFavorite = false
    )
)

val listOfClassListDataSample = listOf(
    ClassListData(
        headerTitle = "Featured classes",
        classDetails = listOf(
            ClassItemData(
                classId = "apple",
                imageSrc = "https://unsplash.com/photos/wRdYnqXtyYk/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8MjB8fGNsYXNzfHwwfHx8fDE2NDI3NjIwMDM&force=true&w=640",
                noOfStudents = 12843,
                classDuration = 5400000,
                classTitle = "Productivity Masterclass -Principles and Tools to Boost Your Productivity",
                classTeacher = "Lindsey Donin",
                isFavorite = false
            ),
            ClassItemData(
                classId = "ball",
                imageSrc = "https://unsplash.com/photos/N_aihp118p8/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8N3x8Y2xhc3N8fDB8fHx8MTY0Mjc2MjAwMw&force=true&w=640",
                noOfStudents = 2342,
                classDuration = 2300000,
                classTitle = "Photography Basics",
                classTeacher = "India Malone",
                isFavorite = true
            ),
        )
    ),
    ClassListData(
        headerTitle = "Popular classes",
        classDetails = listOf(
            ClassItemData(
                classId = "cat",
                imageSrc = "https://unsplash.com/photos/2Q3Ivd-HsaM/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8MzV8fGNsYXNzfGVufDB8fHx8MTY0Mjc2MjAzOQ&force=true&w=640",
                noOfStudents = 0,
                classDuration = 8860040,
                classTitle = "Theory of Relativity",
                classTeacher = "Diane Abbott",
                isFavorite = true
            ),
            ClassItemData(
                classId = "dog",
                imageSrc = "https://unsplash.com/photos/w9i7wMaM3EE/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8NDJ8fGNsYXNzfGVufDB8fHx8MTY0Mjc3MTg2Mg&force=true&w=640",
                noOfStudents = 0,
                classDuration = 1860600, //1hour in millis + 30mins in millis
                classTitle = "Productivity Masterclass -Principles and Tools to Boost Your Productivity",
                classTeacher = "Lindsey Donin",
                isFavorite = false
            ),
        )
    )
)
