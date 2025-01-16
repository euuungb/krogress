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
package com.easternkite.krogress.components.indicators.gridIndicator

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
 * A composable function that displays a grid of animated balls, each pulsating with a beat effect.
 *
 * @param modifier Modifier for the layout of the indicator.
 * @param color The color of the balls.
 * @param rowCount The number of rows in the grid.
 * @param columnCount The number of columns in the grid.
 * @param minAlpha The minimum alpha value of the ball during animation.
 * @param maxAlpha The maximum alpha value of the ball during animation.
 * @param animationDuration The duration of the animation for each ball in milliseconds.
 */
@Composable
fun BallGridBeatIndicator(
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    rowCount: Int = 3,
    columnCount: Int = 3,
    minAlpha: Float = 0.2f,
    maxAlpha: Float = 1f,
    animationDuration: Int = 600,
) {
    val totalBallsCount = columnCount * rowCount

    val alphas: List<Float> = (0 until totalBallsCount).map { index ->
        var alpha by remember { mutableStateOf(maxAlpha) }

        LaunchedEffect(key1 = Unit) {
            delay(200L * index)

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
                alpha = value
            }
        }
        alpha
    }

    Canvas(modifier = modifier.size(48.dp)) {
        val spacing = (size.width / rowCount) / 10
        val bd = (size.width - (spacing * rowCount.plus(1))) / rowCount
        val radius = bd / 2
        var extraY = radius
        for (row in 0 ..< rowCount) {
            val weightY = row.coerceAtMost(1)
            val centerY = extraY + spacing + bd * weightY

            var extraX = radius
            for (col in 0 ..< columnCount) {
                val weightX = col.coerceAtMost(1)
                val centerX = extraX + spacing + bd * weightX
                drawCircle(
                    color = color,
                    radius = radius,
                    center = Offset(
                        x = centerX,
                        y = centerY
                    ),
                    alpha = alphas[row * columnCount + col]
                )
                extraX = centerX
            }
            extraY = centerY
        }
    }
}

/**
 * A composable function that displays a ball grid beat indicator.
 *
 * This indicator consists of a grid of circles that pulse in opacity, creating a beat effect.
 * The grid is determined by the `spanCount` which specifies both the number of rows and columns.
 *
 * @param modifier The modifier to be applied to the layout.
 * @param color The color of the circles.
 * @param spanCount The number of rows and columns in the grid (e.g., 3 creates a 3x3 grid).
 * @param minAlpha The minimum alpha value of the circles during the animation.
 * @param maxAlpha The maximum alpha value of the circles during the animation.
 * @param animationDuration The duration of one complete pulse cycle in milliseconds.
 */
@Composable
fun BallGridBeatIndicator(
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    spanCount: Int = 3,
    minAlpha: Float = 0.2f,
    maxAlpha: Float = 1f,
    animationDuration: Int = 600,
) {
    BallGridBeatIndicator(
        color = color,
        rowCount = spanCount,
        columnCount = spanCount,
        minAlpha = minAlpha,
        maxAlpha = maxAlpha,
        animationDuration = animationDuration,
        modifier = modifier,
    )
}

