package com.ife_a.compose_online_class_platform_ui.features.classes

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ife_a.compose_online_class_platform_ui.components.headers.LazyRowHeader
import com.ife_a.compose_online_class_platform_ui.utils.sampleListOfClassItemData

data class ClassListData(
    var headerTitle: String = "",
    var classDetails: List<ClassItemData>
)

@Preview
@Composable
fun ClassList(
    classListData: ClassListData = ClassListData(
        headerTitle = "Header title",
        classDetails = sampleListOfClassItemData
    ),
    classItemClicked: (classId: String) -> Unit = {},
    viewAllButtonClicked: (sectionTitle: String) -> Unit = {},
    classItemFavoriteButtonClicked: (classId: String) -> Unit = {}
) {
    LazyRowHeader(
        headerText = classListData.headerTitle,
        viewAllButtonClicked = viewAllButtonClicked
    )
    LazyRow(
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 30.dp)

    ) {
        items(items = classListData.classDetails) { classDetails ->
            ClassItem(
                classItemData = classDetails,
                onClassItemClick = classItemClicked,
                onFavoriteClick = classItemFavoriteButtonClicked
            )
        }
    }
}