package com.ife_a.compose_online_class_platform_ui.features.classes

data class ClassVideo(
    val parentClassId: String,
    val videoTitle: String,
    val videoDuration: Long = 0L,
    val isFree: Boolean,
)