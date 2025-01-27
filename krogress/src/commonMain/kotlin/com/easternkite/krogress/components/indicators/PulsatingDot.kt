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
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay

/**
 * A composable function that displays a series of pulsating dots.
 *
 * The dots will animate in a staggered fashion, growing and shrinking in size repeatedly.
 *
 * @param modifier Modifier to be applied to the Canvas.
 * @param color The color of the dots. Default is [Color.White].
 * @param dotsCount The number of dots to display. Default is 3.
 * @param animationDuration The duration of the animation for one full pulse (grow and shrink) in milliseconds. Default is 600.
 */
@Composable
fun PulsatingDot(
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    dotsCount: Int = 3,
    animationDuration: Int = 600
) {
    val targetMax = 1f
    val targetMin = 0.2f

    val scales: List<Float> = (0 until dotsCount).map { index ->
        var scale by remember { mutableStateOf(targetMax) }

        LaunchedEffect(key1 = Unit) {

            delay(animationDuration / dotsCount * index.toLong())
            animate(
                initialValue = targetMin,
                targetValue = targetMax,
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

    Canvas(modifier = modifier.size(48.dp)) {
        val spacing = (size.width / dotsCount) / 10
        val ballDiameter = (size.width - (spacing * dotsCount.plus(1))) / dotsCount
        val radius = ballDiameter / 2
        var extra = radius
        (0 ..< dotsCount).forEach {
            val weight = it.coerceAtMost(1)
            val centerX = extra + spacing + ballDiameter * weight
            drawCircle(
                color = color,
                radius = radius * scales[it],
                center = Offset(
                    x = centerX,
                    y = size.height / 2
                ),
            )
            extra = centerX
        }
    }
}