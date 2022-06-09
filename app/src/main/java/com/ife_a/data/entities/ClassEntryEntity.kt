package com.ife_a.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.ife_a.compose_online_class_platform_ui.destinations.destinationHome.CategoryItemData
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassVideo

@Entity(tableName = "class_entry_entity")
data class ClassEntryEntity(
    @PrimaryKey
    val classId: String,
    val imageSrc: String = "https://unsplash.com/photos/F8t2VGnI47I/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8MjN8fGNsYXNzfGVufDB8fHx8MTY0Mjc2MjAzOQ&force=true&w=640",
    val noOfStudents: Int = 0,
    val classTitle: String,
    val classTeacher: String,
    val isFavorite: Boolean = false,
    val videos: List<ClassVideoEntity>,
    val categoryItemData: CategoryItemData,
)