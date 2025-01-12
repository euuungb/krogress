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
fun PulsatingDot(
    color: Color = Color.White,
    ballDiameter: Float = 40f,
    horizontalSpace: Float = 20f,
    animationDuration: Int = 600,
    minAlpha: Float = 0f,
    maxAlpha: Float = 1f
) {

    val dotsCount = 3

    val scales: List<Float> = (0 until dotsCount).map { index ->
        var scale by remember { mutableStateOf(maxAlpha) }

        LaunchedEffect(key1 = Unit) {

            delay(animationDuration / dotsCount * index.toLong())
            animate(
                initialValue = minAlpha,
                targetValue = maxAlpha,
                animationSpec = infiniteRepeatable(
                    animation = tween(
                        durationMillis = animationDuration,
                        easing = LinearEasing
                    ),
                    repeatMode = RepeatMode.Reverse,
                ),
            ) { value, _ ->
                scale = value
            }
        }
        scale
    }

    Canvas(modifier = Modifier) {
        for (index in 0 until dotsCount) {

            val xOffset = ballDiameter + horizontalSpace

            drawCircle(
                color = color,
                radius = (ballDiameter / 2) * scales[index],
                center = Offset(
                    x = when {
                        index < dotsCount / 2 -> -(center.x + xOffset)
                        index == dotsCount / 2 -> center.x
                        else -> center.x + xOffset
                    },
                    y = 0f
                )
            )
        }
    }
}