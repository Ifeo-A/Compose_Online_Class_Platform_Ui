package com.ife_a.compose_online_class_platform_ui

import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import com.ife_a.compose_online_class_platform_ui.components.destinations.DestinationHome

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        shouldMakeFullScreen(
            fullScreen = true,
            window = window,
        )

        setContent {
            DestinationHome()
        }
    }
}

fun shouldMakeFullScreen(
    window: Window,
    fullScreen: Boolean,
    hideStatusBar: Boolean = false,
    hideNavigationBar: Boolean = false
){
    if(fullScreen){
        WindowCompat.setDecorFitsSystemWindows(window, false)
    }
    window.apply {
        setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )
        WindowInsetsControllerCompat(this, this.decorView).let {
            if(hideStatusBar){
                it.hide(WindowInsetsCompat.Type.statusBars())
            }
            if(hideNavigationBar) it.hide(WindowInsetsCompat.Type.navigationBars())

            it.systemBarsBehavior = WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }
}