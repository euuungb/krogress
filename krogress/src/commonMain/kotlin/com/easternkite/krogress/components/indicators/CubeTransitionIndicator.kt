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

import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import com.easternkite.krogress.extension.toRadians
import kotlin.math.cos
import kotlin.math.sin

@Composable
fun CubeTransitionIndicator(
    color: Color = Color.White,
    movingBalls: Int = 2,
    diameter: Float = 20f,
    spacing: Float = 60f,
    duration: Int = 1000
) {

    val transition = rememberInfiniteTransition()

    val rotation by transition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(duration, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val scale by transition.animateFloat(
        initialValue = 0.4f,
        targetValue = 2.0f,
        animationSpec = infiniteRepeatable(
            animation = tween(duration / 2, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Canvas(modifier = Modifier) {

        val center = Offset(x = size.width / 2, y = size.height / 2)
        val angleStep = 360f / movingBalls

        // The surrounding circles are spinning
        for (index in 0 until movingBalls) {

            val angle = index * angleStep
            val offsetX = center.x + ((spacing) * cos(angle.toRadians() + rotation.toDouble())).toFloat()
            val offsetY = center.y + ((spacing) * sin(angle.toRadians() + rotation.toDouble())).toFloat()
            val offset = Offset(x = offsetX, y = offsetY)

            drawRect(
                color = color,
                size = Size(width = diameter * scale, height = diameter * scale),
                topLeft = offset
            )
        }
    }
}