package com.ife_a.compose_online_class_platform_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ife_a.compose_online_class_platform_ui.components.TopBar

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App(){
    TopBar()
}

@Preview(showBackground = false, widthDp = 300)
@Composable
fun DefaultPreview() {
    App()
}