package com.ife_a.compose_online_class_platform_ui

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.google.accompanist.insets.ProvideWindowInsets
import com.ife_a.compose_online_class_platform_ui.components.bottomBar.BottomBarCustom
import com.ife_a.compose_online_class_platform_ui.destinations.DestinationClassDetail
import com.ife_a.compose_online_class_platform_ui.destinations.DestinationHome
import com.ife_a.compose_online_class_platform_ui.destinations.NavGraphs
import com.ife_a.compose_online_class_platform_ui.destinations.destinations.DestinationClassDetailDestination
import com.ife_a.compose_online_class_platform_ui.destinations.destinations.DestinationHomeDestination
import com.ife_a.compose_online_class_platform_ui.ui.theme.AppTheme
import com.ife_a.compose_online_class_platform_ui.utils.listOfClassDetailsSample
import com.ife_a.compose_online_class_platform_ui.utils.sampleClassItemDataPhotographyClass
import com.ife_a.compose_online_class_platform_ui.utils.toast
import com.ramcosta.composedestinations.DestinationsNavHost
import com.ramcosta.composedestinations.navigation.navigateTo

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        shouldMakeFullScreen(
            fullScreen = false,
            hideStatusBar = true,
            window = window
        )

        setContent {
            val navController = rememberNavController()
            DestinationsNavHost(
                navController = navController,
                navGraph = NavGraphs.root
            )

            ProvideWindowInsets(windowInsetsAnimationsEnabled = true) {
                AppTheme {
                    ProvideWindowInsets {
                        val context = LocalContext.current
                        Scaffold(
                            bottomBar = {
                                BottomBarCustom(onMenuItemClicked = {
                                    toast(
                                        context = context,
                                        text = "Menu $it clicked"
                                    )
                                })
                            }
                        ) { scaffoldPaddingValues ->
                            Box(
                                modifier = Modifier
                                    .padding(bottom = scaffoldPaddingValues.calculateBottomPadding())
                            ) {
//                                navController.navigateTo(direction = DestinationHomeDestination)
                                DestinationHome(
                                    classIdClicked = { classId ->
                                        println("Home efe Class item with id $classId clicked")
                                        val clickedClass =
                                            listOfClassDetailsSample.firstOrNull { it.classId == classId }
                                        clickedClass?.let {
//                                            DestinationClassDetail(classId = it.classId)
                                            navigateToD(
                                                id = it.classId,
                                                navController = navController
                                            )
                                        }
                                    }
                                )
//                                DestinationClassDetail()
                            }
                        }
                    }
                }
            }
        }
    }
}

fun navigateToD(id: String, navController: NavController) {
    navController.navigateTo(direction = DestinationClassDetailDestination(classId = id))
}


fun shouldMakeFullScreen(
    window: Window,
    fullScreen: Boolean,
    hideStatusBar: Boolean = false,
    hideNavigationBar: Boolean = false
) {
    if (fullScreen) {
        //The only required part for full screen.
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.apply {
            setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
    }

    window.apply {
        WindowInsetsControllerCompat(this, this.decorView).let {
            if (hideStatusBar) it.hide(WindowInsetsCompat.Type.statusBars())
            if (hideNavigationBar) {
                it.hide(WindowInsetsCompat.Type.navigationBars())
                it.systemBarsBehavior =
                    WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

            }
        }
    }
}