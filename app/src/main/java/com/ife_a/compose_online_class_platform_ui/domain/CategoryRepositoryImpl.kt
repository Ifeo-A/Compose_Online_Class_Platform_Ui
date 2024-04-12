package com.ife_a.compose_online_class_platform_ui.domain

import com.ife_a.data.db.dao.CategoryEntityDao
import com.ife_a.data.entities.CategoryEntity
import javax.inject.Inject

class CategoryRepositoryImpl @Inject constructor(
    private val categoryEntityDao: CategoryEntityDao
) : CategoryRepository {

    override fun getAllCategories(): List<CategoryEntity> {
        return categoryEntityDao.getAllCategories()
    }
}