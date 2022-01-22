package com.ife_a.compose_online_class_platform_ui.components.searchBar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.ife_a.compose_online_class_platform_ui.components.ClassDetails
import com.ife_a.compose_online_class_platform_ui.components.ClassItem
import com.ife_a.compose_online_class_platform_ui.components.headers.LazyRowHeader
import com.ife_a.compose_online_class_platform_ui.utils.repeat

data class ClassListData(
    var headerTitle: String = "",
    var classDetails: List<ClassDetails>
)

@Composable
fun ClassList(classListData: ClassListData){
    LazyRowHeader(
        headerText = classListData.headerTitle
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
    ){
        items(items = classListData.classDetails){
            classListData.classDetails.forEach { classDetails ->
                ClassItem(classDetails)
            }
        }
    }
}