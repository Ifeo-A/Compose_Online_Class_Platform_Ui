package com.ife_a.compose_online_class_platform_ui.destinations

import android.content.Context
import android.widget.ImageView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.content.ContextCompat
import com.ife_a.compose_online_class_platform_ui.R

@Preview(showBackground = true, heightDp = 600, widthDp = 300)
@Composable
fun DestinationVideo() {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            modifier = Modifier
        ) {
            AndroidView(
                modifier = Modifier
                    .background(color = Color.Gray)
                    .weight(0.6f)
                    .fillMaxWidth(),
                factory = { context: Context ->
                    ImageView(context).apply {
                        val drawable = ContextCompat.getDrawable(
                            context,
                            R.drawable.ic_launcher_background
                        )
                        setImageDrawable(drawable)
                    }
                }
            )
            Spacer(modifier = Modifier.height(30.dp))
            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {
                item {
                    for (i in 1..10) {
                        VideoCard()
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 300)
@Composable
fun VideoCard() {
    Column(
        modifier = Modifier
            .height(80.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text(text = "Video title")
            Text(text = "Duration")
        }
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            Text(text = "Teacher name")
        }
    }
}