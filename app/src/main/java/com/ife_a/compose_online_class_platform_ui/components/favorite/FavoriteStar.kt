package com.ife_a.compose_online_class_platform_ui.components.favorite

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.filled.StarOutline
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider

@Composable
fun FavoriteStar(
    isFavorite: Boolean = true,
    onClick: () -> Unit = {}
) {
    Image(
        imageVector = if (isFavorite) {
            Icons.Filled.Star
        } else {
            Icons.Filled.StarOutline
        },
        contentDescription = null,
        colorFilter = ColorFilter.tint(
            if (isFavorite) Color.Blue else Color.Black
        ),
        modifier = Modifier.clickable {
            onClick()
        }
    )
}

data class FavoriteStarPreviewData(
    val isFavorite: Boolean,
    val onClick: () -> Unit = {}
)

class FavoriteStarPreviewParameterProvider : PreviewParameterProvider<FavoriteStarPreviewData> {
    override val values: Sequence<FavoriteStarPreviewData> =
        sequenceOf(
            FavoriteStarPreviewData(isFavorite = true),
            FavoriteStarPreviewData(isFavorite = false),
        )
}

@Preview(name = "Favorite star previews", showBackground = true, widthDp = 30, heightDp = 30)
@Composable
fun PreviewMyFavoriteStar(
    @PreviewParameter(FavoriteStarPreviewParameterProvider::class)
    previewData: FavoriteStarPreviewData
) {
    FavoriteStar(isFavorite = previewData.isFavorite)
}