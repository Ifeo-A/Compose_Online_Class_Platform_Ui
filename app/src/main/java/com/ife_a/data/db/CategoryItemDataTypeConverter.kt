package com.ife_a.data.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.ife_a.compose_online_class_platform_ui.destinations.destinationHome.CategoryItemData
import com.ife_a.data.entities.ClassVideoEntity
import com.squareup.moshi.Moshi
import javax.inject.Inject

@ProvidedTypeConverter
class CategoryItemDataTypeConverter @Inject constructor(
    moshi: Moshi
) {

    private val categoryItemDataTypeConverter = moshi.adapter(CategoryItemData::class.java)

    @TypeConverter
    fun categoryItemDataToString(categoryItemData: CategoryItemData): String {
        return categoryItemDataTypeConverter.toJson(categoryItemData)
    }

    @TypeConverter
    fun categoryItemDataJsonStringToObject(jsonString: String): CategoryItemData {
        return categoryItemDataTypeConverter.fromJson(jsonString) as CategoryItemData
    }
}