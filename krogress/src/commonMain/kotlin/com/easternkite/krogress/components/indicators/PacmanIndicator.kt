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
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

/**
 * A composable function that displays a Pac-Man loading indicator animation.
 *
 * The indicator consists of a Pac-Man shape that opens and closes its mouth,
 * along with a circular "dot" that moves in front of the Pac-Man.
 *
 * @param modifier Modifier to be applied to the Canvas.
 * @param colors [PacmanIndicatorColors] to customize the colors of the indicator.
 * @param animationDuration Duration in milliseconds of a single animation cycle.
 */
@Composable
fun PacmanIndicator(
    modifier: Modifier = Modifier,
    colors: PacmanIndicatorColors = PacmanIndicatorColors.Default(),
    animationDuration: Int = 500
) {
    val lipStart = 0f
    val lipEnd = 45f

    val positionAnimation by rememberInfiniteTransition().animateFloat(
        initialValue = -1f,
        targetValue = -6f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = animationDuration, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val lipAnimation by rememberInfiniteTransition().animateFloat(
        initialValue = lipStart,
        targetValue = lipEnd,
        animationSpec = infiniteRepeatable(
            animation = tween(animationDuration / 2, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Canvas(modifier = modifier.size(48.dp)) {
        val circleRadius = size.width / 10
        drawCircle(
            color = colors.circleColor,
            radius = circleRadius,
            center = Offset(
                x = size.width + (positionAnimation * circleRadius),
                y = size.height / 2
            ),
        )

        val diameter = size.height / 1.3f
        val arcOffsetY = (size.height - diameter) / 2
        drawArc(
            color = colors.arcColor,
            startAngle = lipAnimation,
            sweepAngle = 360 - lipAnimation.times(2),
            topLeft = Offset(0f, arcOffsetY),
            size = Size(diameter, diameter),
            useCenter = true
        )
    }
}

/**
 * Defines the colors used for the [PacmanIndicator].
 *
 * @property arcColor The color of the Pacman's arc (the mouth).
 * @property circleColor The color of the Pacman's circle (the body).
 */
data class PacmanIndicatorColors(
    val arcColor: Color,
    val circleColor: Color,
) {
    companion object {
        val Default = @Composable {
            PacmanIndicatorColors(
                arcColor = MaterialTheme.colorScheme.primary,
                circleColor = MaterialTheme.colorScheme.primary,
            )
        }
    }
}