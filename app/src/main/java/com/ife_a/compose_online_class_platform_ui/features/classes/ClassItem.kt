package com.ife_a.compose_online_class_platform_ui.features.classes

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PersonOutline
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.ife_a.compose_online_class_platform_ui.components.favorite.FavoriteStar
import com.ife_a.compose_online_class_platform_ui.ui.theme.ShapesV2
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_onPrimary
import com.ife_a.compose_online_class_platform_ui.utils.getPlayTimeFromMillis


data class ClassItemData(
    val classId: String,
    val imageSrc: String = "https://unsplash.com/photos/F8t2VGnI47I/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8MjN8fGNsYXNzfGVufDB8fHx8MTY0Mjc2MjAzOQ&force=true&w=640",
    val noOfStudents: Int = 0,
    val classDuration: Long = 0L,
    val classTitle: String,
    val classTeacher: String,
    val isFavorite: Boolean = false,
)

val listOfImages = listOf(
    "https://unsplash.com/photos/FIxxQDwpJ2g/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8MzR8fGNsYXNzfGVufDB8fHx8MTY0Mjc2MjAzOQ&force=true&w=640",
    "https://unsplash.com/photos/wRdYnqXtyYk/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8MjB8fGNsYXNzfHwwfHx8fDE2NDI3NjIwMDM&force=true&w=640",
    "https://unsplash.com/photos/N_aihp118p8/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8N3x8Y2xhc3N8fDB8fHx8MTY0Mjc2MjAwMw&force=true&w=640",
    "https://unsplash.com/photos/2Q3Ivd-HsaM/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8MzV8fGNsYXNzfGVufDB8fHx8MTY0Mjc2MjAzOQ&force=true&w=640",
    "https://unsplash.com/photos/FoB-ImUjLqE/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8MzZ8fGNsYXNzfGVufDB8fHx8MTY0Mjc2MjAzOQ&force=true&w=640",
    "https://unsplash.com/photos/w9i7wMaM3EE/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8NDJ8fGNsYXNzfGVufDB8fHx8MTY0Mjc3MTg2Mg&force=true&w=640",
    "https://unsplash.com/photos/IsX2ZkbSk1Y/download?ixid=MnwxMjA3fDB8MXxzZWFyY2h8NjV8fGNsYXNzfGVufDB8fHx8MTY0Mjc2NjkwNQ&force=true&w=640",
    "https://unsplash.com/photos/UKEq4ompWow/download?force=true&w=640",
)

@ExperimentalMaterialApi
@Preview
@Composable
fun ClassItem(
    classItemData: ClassItemData = ClassItemData(
        classId = "",
        imageSrc = listOfImages.random(),
        noOfStudents = 0,
        classDuration = 5_400_000, //1hour in millis + 30mins in millis
        classTitle = "",
        classTeacher = "",
        isFavorite = false
    ),
    onClassItemClick: (classId: String) -> Unit = {},
    onFavoriteClick: (classId: String) -> Unit = {}
) {

    Card(
        shape = ShapesV2.large,
        backgroundColor = md_theme_light_onPrimary,
        modifier = Modifier
            .size(width = 380.dp, height = 340.dp)
            .padding(start = 14.dp, end = 14.dp),
        onClick = { onClassItemClick(classItemData.classId) },
        elevation = 4.dp
    ) {
        Column() {
            Row(
                modifier = Modifier
                    .weight(1f),
            ) {
                Image(
                    painter = rememberImagePainter(
                        data = classItemData.imageSrc,
                        builder = {
                            crossfade(300)
                        }
                    ),
                    modifier = Modifier
                        .fillMaxSize(),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
            }

            Column(
                verticalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
                    .weight(1f)
            ) {
                //Students and duration
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(imageVector = Icons.Outlined.PersonOutline, contentDescription = null)
                        Text(text = "${classItemData.noOfStudents} students")
                    }
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Image(imageVector = Icons.Outlined.PlayArrow, contentDescription = null)
                        Text(
                            text = getPlayTimeFromMillis(classItemData.classDuration),
                            textAlign = TextAlign.End
                        )

                    }
                }
                // Class title
                Text(
                    text = classItemData.classTitle,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis,
                    fontWeight = FontWeight.Bold
                )
                // Class teacher and favourited icon
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(
                            start = 0.dp,
                            top = 18.dp,
                            end = 0.dp,
                            bottom = 0.dp
                        )
                ) {
                    Text(text = classItemData.classTeacher)
                    FavoriteStar(
                        isFavorite = classItemData.isFavorite,
                        onClick = { onFavoriteClick(classItemData.classId) }
                    )
                }
            }
        }
    }
}


