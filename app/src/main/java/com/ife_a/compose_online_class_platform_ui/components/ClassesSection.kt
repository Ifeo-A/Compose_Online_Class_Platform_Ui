package com.ife_a.compose_online_class_platform_ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassList
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassListData
import com.ife_a.compose_online_class_platform_ui.utils.listOfClassListDataSample

@Preview(showBackground = true)
@Composable
fun ClassesSection(
    listOfClassListData: List<ClassListData> = listOfClassListDataSample,
    /**
     * Called when a class item in the list is clicked
     */
    classListItemClicked: (classId: String) -> Unit = {},

    /**
     * Called when the View all button for a section is clicked.
     */
    viewAllButtonClicked: (sectionTitle: String) -> Unit = {},
) {
    Column {
        listOfClassListData.forEach {
            ClassList(
                classListData = it,
                classItemClicked = classListItemClicked,
                viewAllButtonClicked = viewAllButtonClicked
            )
        }
    }
}