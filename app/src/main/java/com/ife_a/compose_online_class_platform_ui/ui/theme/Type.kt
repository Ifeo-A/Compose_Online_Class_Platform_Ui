package com.ife_a.compose_online_class_platform_ui.ui.theme
import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
//Replace with your font locations
val Roboto = FontFamily.Default

val AppTypography = Typography(
	body1 = TextStyle(
		fontFamily = FontFamily.Default,
		fontWeight = FontWeight.Normal,
		fontSize = 16.sp
	),
	h6 = TextStyle(fontSize = 12.sp)
)
