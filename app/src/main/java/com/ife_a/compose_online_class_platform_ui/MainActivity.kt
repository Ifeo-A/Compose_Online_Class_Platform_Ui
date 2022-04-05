package com.ife_a.compose_online_class_platform_ui

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.ui.platform.LocalContext
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.navigation.compose.rememberNavController
import com.ife_a.compose_online_class_platform_ui.components.bottomBar.BottomBarCustom
import com.ife_a.compose_online_class_platform_ui.navigation.NavigationHelper
import com.ife_a.compose_online_class_platform_ui.ui.theme.AppTheme
import com.ife_a.compose_online_class_platform_ui.utils.toast

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        shouldMakeFullScreen(
            fullScreen = false,
            hideStatusBar = true,
            window = window
        )

        setContent {
            AppTheme {
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
                    val navController = rememberNavController()
                    NavigationHelper.SetupNavGraph(
                        navController = navController,
                        navBarPadding = scaffoldPaddingValues.calculateBottomPadding().value.toInt()
                    )
                }
            }
        }
    }
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
        ViewCompat.getWindowInsetsController(this.decorView).let {
            if (hideStatusBar) it?.hide(WindowInsetsCompat.Type.statusBars())
            if (hideNavigationBar) {
                it?.hide(WindowInsetsCompat.Type.navigationBars())
                it?.systemBarsBehavior =
                    WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE

            }
        }
    }
}