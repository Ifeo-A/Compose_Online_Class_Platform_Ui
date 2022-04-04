package com.ife_a.compose_online_class_platform_ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassList
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassListData
import com.ife_a.compose_online_class_platform_ui.utils.sampleListOfClassListData

@Preview(showBackground = true)
@Composable
fun ClassesSection(
    listOfClassListData: List<ClassListData> = sampleListOfClassListData,
    /**
     * Called when a class item in the list is clicked
     */
    classListItemClicked: (classId: String) -> Unit = {},

    /**
     * Called when the View all button for a section is clicked.
     */
    viewAllButtonClicked: (sectionTitle: String) -> Unit = {},

    /**
     * Called when the favorite button on a class card is clicked
     */
    classItemFavoriteButtonClicked: (classId: String) -> Unit = {},
) {
    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier.padding(bottom = 30.dp)
    ){
        Column {
            listOfClassListData.forEach {
                ClassList(
                    classListData = it,
                    classItemClicked = classListItemClicked,
                    viewAllButtonClicked = viewAllButtonClicked,
                    classItemFavoriteButtonClicked = classItemFavoriteButtonClicked
                )
            }
        }
    }
}