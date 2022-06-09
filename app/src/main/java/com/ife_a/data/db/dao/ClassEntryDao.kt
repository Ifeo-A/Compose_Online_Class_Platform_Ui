package com.ife_a.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.ife_a.data.entities.ClassEntryEntity

@Dao
interface ClassEntryDao {

    @Query("SELECT * FROM class_entry_entity")
    fun getAllCassEntries(): List<ClassEntryEntity>
}