package com.ife_a.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.ife_a.data.entities.ClassVideoEntity

@Dao
interface ClassVideoEntityDao {

    @Query("SELECT * FROM class_video_entity")
    fun getAllClassVideos(): List<ClassVideoEntity>
}