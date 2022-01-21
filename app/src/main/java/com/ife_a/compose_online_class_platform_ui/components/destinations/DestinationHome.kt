package com.ife_a.compose_online_class_platform_ui.components.destinations

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.google.accompanist.insets.ProvideWindowInsets
import com.google.accompanist.insets.statusBarsPadding
import com.ife_a.compose_online_class_platform_ui.components.CategoriesSection
import com.ife_a.compose_online_class_platform_ui.components.MyTopBar
import com.ife_a.compose_online_class_platform_ui.ui.theme.AppTheme
import com.ife_a.compose_online_class_platform_ui.utils.toast

@Composable
fun DestinationHome() {
    val context = LocalContext.current

    val categories = listOf(
        "🎨 Design",
        "👨‍🎨 Art",
        "‍🖥 Programming",
        "💻 Marketing",
        "📝 Writing",
        "🗿 History",
        "🧮 Maths",
        "🧑🏽‍ Science",
        "‍📈 Statistics"
    )

    ProvideWindowInsets(windowInsetsAnimationsEnabled = true) {
        val scrollState = rememberScrollState()
        AppTheme {
            ProvideWindowInsets {
                Surface(
                    color = MaterialTheme.colors.background,
                    modifier = Modifier
                        .statusBarsPadding()
                        .fillMaxSize()
                ) {
                    Column(
                        modifier = Modifier
                            .statusBarsPadding()
                            .verticalScroll(scrollState)
                    ) {
                        MyTopBar()
                        CategoriesSection(
                            categories = categories,
                            viewAllClicked = {
                                toast(
                                    context = context,
                                    text = "$it clicked"
                                )
                            }
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 400, heightDp = 800)
@Composable
fun DefaultPreview() {
    DestinationHome()
}