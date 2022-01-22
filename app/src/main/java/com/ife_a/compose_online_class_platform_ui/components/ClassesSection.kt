package com.ife_a.compose_online_class_platform_ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ife_a.compose_online_class_platform_ui.components.searchBar.ClassList
import com.ife_a.compose_online_class_platform_ui.components.searchBar.ClassListData

@Preview(showBackground = true, heightDp = 800)
@Composable
fun ClassesSection(listOfClassListData: List<ClassListData> = listOf()) {
    Column{
        listOfClassListData.forEach {
            ClassList(classListData = it)
        }
    }
}