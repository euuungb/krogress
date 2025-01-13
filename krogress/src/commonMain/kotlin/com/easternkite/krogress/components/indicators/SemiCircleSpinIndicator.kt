/*
 * Copyright 2025 easternkite
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.easternkite.krogress.components.indicators

import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * A composable function that displays a semi-circle spinning animation.
 *
 * The animation is achieved by rotating a semi-circle arc continuously.
 *
 * @param modifier Modifier to be applied to the canvas.
 * @param color The color of the semi-circle arc. Default is [Color.White].
 * @param startAngle The starting angle of the arc in degrees. Default is -90f.
 * @param endAngle The ending angle of the arc in degrees. Default is 270f.
 * @param sweepAngle The angle (in degrees) to sweep when drawing the arc. Default is 180f, which creates a semi-circle.
 * @param animationDuration The duration of the animation in milliseconds. Default is 600.
 */
@Composable
fun SemiCircleSpinIndicator(
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    startAngle: Float = -90f,
    endAngle: Float = 270f,
    sweepAngle: Float = 180f,
    animationDuration: Int = 600,
) {

    val rotation by rememberInfiniteTransition().animateFloat(
        initialValue = startAngle,
        targetValue = endAngle,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = animationDuration, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    Canvas(modifier = modifier.size(48.dp)) {
        drawArc(
            color = color,
            startAngle = rotation,
            sweepAngle = sweepAngle,
            topLeft = Offset(0f, 0f),
            size = Size(size.width, size.height),
            useCenter = true
        )
    }
}