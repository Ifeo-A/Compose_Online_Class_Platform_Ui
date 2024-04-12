package com.ife_a.compose_online_class_platform_ui.domain

import com.ife_a.compose_online_class_platform_ui.destinations.destinationHome.CategoryItemData
import com.ife_a.data.entities.CategoryEntity

interface CategoryRepository {

    fun getAllCategories(): List<CategoryEntity>
}