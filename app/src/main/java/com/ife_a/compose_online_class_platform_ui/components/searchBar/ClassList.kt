package com.ife_a.compose_online_class_platform_ui.components.searchBar

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ife_a.compose_online_class_platform_ui.components.ClassDetails
import com.ife_a.compose_online_class_platform_ui.components.ClassItem
import com.ife_a.compose_online_class_platform_ui.components.headers.LazyRowHeader

data class ClassListData(
    var headerTitle: String = "",
    var classDetails: List<ClassDetails>
)

@Composable
fun ClassList(
    classListData: ClassListData,
    classItemClicked: (classId: String) -> Unit
) {
    LazyRowHeader(
        headerText = classListData.headerTitle
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 30.dp)

    ) {
        items(items = classListData.classDetails) { classDetails ->
            ClassItem(
                classDetails = classDetails,
                onclick = classItemClicked
            )
        }
    }
}