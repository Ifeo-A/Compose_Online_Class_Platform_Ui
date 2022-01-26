package com.ife_a.compose_online_class_platform_ui.destinations

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.accompanist.insets.navigationBarsWithImePadding

@Preview(showBackground = true, showSystemUi = false, heightDp = 800)
@Composable
fun DestinationClassDetail() {
    val context = LocalContext.current

    Surface(
        color = MaterialTheme.colors.background,
        modifier = Modifier
            .navigationBarsWithImePadding()
            .padding(bottom = 20.dp)
    ) {
        LazyColumn {
            item {

            }
        }
    }

}
