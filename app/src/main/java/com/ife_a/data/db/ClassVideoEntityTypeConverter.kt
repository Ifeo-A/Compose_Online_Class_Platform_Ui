package com.ife_a.data.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.ife_a.compose_online_class_platform_ui.destinations.destinationHome.CategoryItemData
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassVideo
import com.ife_a.data.entities.CategoryEntity
import com.ife_a.data.entities.ClassVideoEntity
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class ClassVideoEntityTypeConverter @Inject constructor(
    moshi: Moshi
) {

    private val classVideoType =
        Types.newParameterizedType(List::class.java, ClassVideoEntity::class.java)
    private val classVideoAdapter = moshi.adapter<List<ClassVideoEntity>>(classVideoType)

//    private val classVideoTypeAdapter = moshi.adapter(ClassVideoEntity::class.java)

    @TypeConverter
    fun classVideoEntityToJsonString(listOfClassVideoEntity: List<ClassVideoEntity>): String {
        return classVideoAdapter.toJson(listOfClassVideoEntity)
    }

    @TypeConverter
    fun jsonStringToCategoryItemData(string: String): List<ClassVideoEntity> {
        return classVideoAdapter.fromJson(string) as List<ClassVideoEntity>
    }
}