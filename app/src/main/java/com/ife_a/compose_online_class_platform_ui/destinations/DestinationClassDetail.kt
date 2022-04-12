package com.ife_a.compose_online_class_platform_ui.destinations

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowLeft
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material.icons.outlined.PhoneIphone
import androidx.compose.material.icons.outlined.ThumbUpOffAlt
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.google.accompanist.insets.navigationBarsWithImePadding
import com.ife_a.compose_online_class_platform_ui.components.ClassSellingPoints
import com.ife_a.compose_online_class_platform_ui.components.ClassVideoList
import com.ife_a.compose_online_class_platform_ui.components.buttons.MyIconButton
import com.ife_a.compose_online_class_platform_ui.components.favorite.FavoriteStar
import com.ife_a.compose_online_class_platform_ui.components.text.Subtitle
import com.ife_a.compose_online_class_platform_ui.components.text.TitleLarge
import com.ife_a.compose_online_class_platform_ui.features.classes.StudentCountDisplay
import com.ife_a.compose_online_class_platform_ui.features.classes.VideoPlaytimeDisplay
import com.ife_a.compose_online_class_platform_ui.ui.theme.ShapesV2
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_dark_primaryContainer
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_onPrimary
import com.ife_a.compose_online_class_platform_ui.ui.theme.md_theme_light_onSecondary
import com.ife_a.compose_online_class_platform_ui.utils.sampleListOfClassItemData

@Preview(showBackground = true, showSystemUi = true, heightDp = 800)
@Composable
fun DestinationClassDetail(
    classId: String = "cat",
    navBarPadding: Int = 0,
    classVideoClicked: (videoId: String) -> Unit = {}
) {
    val classItemData = sampleListOfClassItemData.find { classItemData ->
        classItemData.classId == classId
    }

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .navigationBarsWithImePadding()
            .padding(bottom = navBarPadding.dp)
    ) {
        classItemData?.let {
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
                                    noOfStudents = classItemData.noOfStudents,
                                    showBackground = true
                                )

                                VideoPlaytimeDisplay(
                                    durationMillis = classItemData.classDuration,
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

                        Surface(
                            shape = ShapesV2.medium,
                            color = md_theme_light_onSecondary,
                            modifier = Modifier
                                .padding(vertical = 20.dp)
                        ) {
                            Row() {
                                Column(
                                    modifier = Modifier
                                        .padding(vertical = 20.dp, horizontal = 14.dp)
                                ) {
                                    Text(
                                        text = "You will get:",
                                        fontWeight = FontWeight.Bold,
                                        fontSize = 18.sp,
                                        modifier = Modifier
                                            .padding(bottom = 8.dp)
                                    )
                                    ClassSellingPoints(
                                        imageVector = Icons.Outlined.ThumbUpOffAlt,
                                        text = "Unlimited access to every class"
                                    )
                                    ClassSellingPoints(
                                        imageVector = Icons.Outlined.FavoriteBorder,
                                        text = "Supportive online creative community"
                                    )
                                    ClassSellingPoints(
                                        imageVector = Icons.Outlined.PhoneIphone,
                                        text = "Learn offline with our app"
                                    )
                                }
                            }
                        }
                    }

                    Row(
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(horizontal = 20.dp)

                    ) {
                        TextButton(
                            shape = ShapesV2.small,
                            onClick = { },
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = md_theme_dark_primaryContainer
                            ),
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Text(
                                text = "Get started for free",
                                textAlign = TextAlign.Center,
                                fontWeight = FontWeight.Bold,
                                fontSize = 18.sp,
                                color = md_theme_light_onPrimary,
                                modifier = Modifier
                                    .padding(vertical = 6.dp)
                            )
                        }
                    }
                    ClassVideoList(
                        videoEntries = classItemData.videos,
                        classVideoClicked = classVideoClicked
                    )
                }
            }
        }
    }
}

