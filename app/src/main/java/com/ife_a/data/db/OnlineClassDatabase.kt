package com.ife_a.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.ife_a.data.db.dao.CategoryEntityDao
import com.ife_a.data.entities.CategoryEntity
import com.ife_a.data.entities.ClassEntryEntity
import com.ife_a.data.entities.ClassVideoEntity

@Database(
    entities = [
        CategoryEntity::class,
        ClassEntryEntity::class,
        ClassVideoEntity::class,
    ],
    exportSchema = false,
    version = 1
)
@TypeConverters(
    ClassVideoEntityTypeConverter::class,
    CategoryItemDataTypeConverter::class
)
abstract class OnlineClassDatabase : RoomDatabase() {
    abstract fun categoryEntityDao(): CategoryEntityDao
}