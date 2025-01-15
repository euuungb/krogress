package com.easternkite.krogress.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * A composable function that draws a circle (ball) on the canvas.
 * This [Ball] will be used to generate ball-based indicators.
 *
 * @param modifier Modifier to apply to the canvas. Default is an empty Modifier.
 * @param color The color of the ball. Default is [Color.White].
 */
@Composable
fun Ball(
    modifier: Modifier = Modifier,
    color: Color = Color.White,
) {
    Canvas(modifier = modifier.size(48.dp)) {
        drawCircle(
            color = color,
            radius = size.width / 2,
            center = Offset(size.width / 2, size.height / 2),
        )
    }
}