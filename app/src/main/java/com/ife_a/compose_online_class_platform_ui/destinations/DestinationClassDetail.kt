package com.ife_a.compose_online_class_platform_ui.destinations

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material.icons.outlined.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.ife_a.compose_online_class_platform_ui.components.buttons.MyIconButton
import com.ife_a.compose_online_class_platform_ui.components.favorite.FavoriteStar
import com.ife_a.compose_online_class_platform_ui.components.text.Subtitle
import com.ife_a.compose_online_class_platform_ui.components.text.TitleLarge
import com.ife_a.compose_online_class_platform_ui.features.classes.ClassItemData
import com.ife_a.compose_online_class_platform_ui.utils.*
import com.ife_a.compose_online_class_platform_ui.features.classes.StudentCountDisplay
import com.ife_a.compose_online_class_platform_ui.features.classes.VideoPlaytimeDisplay
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_secondary

@Preview(showBackground = false, showSystemUi = false, heightDp = 800)
@Composable
fun DestinationClassDetail(
    classItemData: ClassItemData = sampleClassItemData
) {

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .navigationBarsWithImePadding()
            .padding(bottom = 20.dp)
    ) {
        LazyColumn {
            item {
                Box(
                    contentAlignment = Alignment.Center,
                    modifier = Modifier
                        .height(240.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
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
                        verticalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(start = 20.dp, end = 20.dp, top = 30.dp, bottom = 20.dp)

                    ) {
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            //back button and notification button
                            MyIconButton(Icons.Filled.ArrowLeft)
                            MyIconButton(Icons.Outlined.Notifications)
                        }
                        Row(
                            horizontalArrangement = Arrangement.SpaceBetween,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            //student and total play time
                            StudentCountDisplay(
                                noOfStudents = sampleClassItemData.noOfStudents,
                                showBackground = true
                            )
                            VideoPlaytimeDisplay(
                                durationMillis = sampleClassItemData.classDuration,
                                showBackground = true
                            )
                        }
                    }
                }

                Column(
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 10.dp, bottom = 10.dp)
                ) {
                    Row(
                        modifier = Modifier
                            .padding(bottom = 20.dp)
                    ) {
                        TitleLarge(text = classItemData.classTitle)
                    }

                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                    ) {
                        Subtitle(text = classItemData.classTeacher)
                        FavoriteStar(classItemData.isFavorite, onClick = {})
                    }

                    Row(
                        modifier = Modifier
                            .padding(top = 20.dp)
                    ) {
                        Column(
                            modifier = Modifier
                                .padding(vertical = 20.dp, horizontal = 10.dp)
                        ) {
                            Text(
                                text = "You will get:",
                                modifier = Modifier
                                    .padding(bottom = 8.dp)
                            )
                            ClassBulletPoint(
                                imageVector = Icons.Outlined.ThumbUpOffAlt,
                                text = "Unlimited access to every class"
                            )
                            ClassBulletPoint(
                                imageVector = Icons.Outlined.FavoriteBorder,
                                text = "Supportive online creative community"
                            )
                            ClassBulletPoint(
                                imageVector = Icons.Outlined.PhoneIphone,
                                text = "Learn offline with our app"
                            )
                        }
                    }
                }
            }
        }
    }

}

@Composable
fun ClassBulletPoint(imageVector: ImageVector, text: String) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(4.dp)
    ) {
        Icon(
            imageVector = imageVector,
            contentDescription = null,
            modifier = Modifier.padding(end = 10.dp),
            tint = md_theme_light_secondary
        )
        Text(text = text)
    }
}