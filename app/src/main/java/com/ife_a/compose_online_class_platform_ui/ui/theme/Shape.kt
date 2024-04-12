package com.ife_a.compose_online_class_platform_ui.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Shapes
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp

val Shapes = Shapes(
    small = RoundedCornerShape(4.dp),
    medium = RoundedCornerShape(8.dp),
    large = RoundedCornerShape(14.dp),
)

val ShapesV2 = Shapes(
    small = RoundedCornerShape(14.dp),
    medium = RoundedCornerShape(18.dp),
    large = RoundedCornerShape(24.dp),
)

fun Shapes.xLarge() = RoundedCornerShape(10.dp)

val roundedBottomLarge = RoundedCornerShape(bottomStart = 24.dp, bottomEnd = 24.dp)
