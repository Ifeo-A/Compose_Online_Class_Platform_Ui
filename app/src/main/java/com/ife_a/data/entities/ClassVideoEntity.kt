package com.ife_a.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "class_video_entity")

data class ClassVideoEntity(
    @PrimaryKey
    val parentClassId: String,
    val videoId: String,
    val videoTitle: String,
    val videoUrl: String,
    val videoDuration: Long = 0L,
    val isFree: Boolean,
)