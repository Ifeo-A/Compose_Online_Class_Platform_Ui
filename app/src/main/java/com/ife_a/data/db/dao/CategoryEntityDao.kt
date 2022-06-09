package com.ife_a.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.ife_a.data.entities.CategoryEntity

@Dao
interface CategoryEntityDao {

    @Query("SELECT * FROM category_entity")
    fun getAllCategories(): List<CategoryEntity>
}