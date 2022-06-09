package com.ife_a.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "category_entity")

data class CategoryEntity(
    @PrimaryKey
    val categoryId: String,
    val categoryName: String,
)