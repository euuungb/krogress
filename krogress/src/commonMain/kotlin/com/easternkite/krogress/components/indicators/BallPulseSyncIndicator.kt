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

import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import kotlinx.coroutines.delay

@Composable
fun BallPulseSyncIndicator(
    color: Color = Color.White,
    delay: Long = 90L,
    spaceBetweenBalls: Float = 20f,
    ballDiameter: Float = 40f,
    animationDuration: Int = 350
) {

    val ballCount = 3

    val positions = (1..ballCount).map { index ->

        var animatedValue: Float by remember { mutableStateOf(0f) }

        LaunchedEffect(key1 = Unit) {
            delay(delay + delay * index)

            animate(
                initialValue = 0f, targetValue = 50f, animationSpec = infiniteRepeatable(
                    animation = tween(durationMillis = animationDuration),
                    repeatMode = RepeatMode.Reverse,
                )
            ) { value, _ -> animatedValue = value }
        }

        animatedValue
    }

    Canvas(modifier = Modifier) {

        val center = Offset(0f, 0f)
        val xOffset = ballDiameter + spaceBetweenBalls

        for (index in 0 until ballCount) {
            drawCircle(
                color = color, radius = ballDiameter / 2, center = Offset(
                    x = when {
                        index < ballCount / 2 -> -(center.x + xOffset)
                        index == ballCount / 2 -> center.x
                        else -> center.x + xOffset
                    },
                    y = center.y - positions[index]
                )
            )
        }
    }
}
