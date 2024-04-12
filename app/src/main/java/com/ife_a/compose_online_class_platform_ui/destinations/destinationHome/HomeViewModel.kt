package com.ife_a.compose_online_class_platform_ui.destinations.destinationHome

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ife_a.compose_online_class_platform_ui.domain.CategoryRepository
import com.ife_a.data.entities.CategoryEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val categoryRepository: CategoryRepository
) : ViewModel() {

    private val _categoriesLiveData: MutableLiveData<List<CategoryEntity>> = MutableLiveData()
    val categoriesLiveData: LiveData<List<CategoryEntity>> = _categoriesLiveData

    fun getAllCategories() {
        _categoriesLiveData.value = categoryRepository.getAllCategories()
    }
}