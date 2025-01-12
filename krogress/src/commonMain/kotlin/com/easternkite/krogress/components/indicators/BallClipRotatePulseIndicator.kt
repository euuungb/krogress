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
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.StrokeJoin
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Composable
fun BallClipRotatePulseIndicator(
    color: Color = Color.White,
    canvasSize: Float = 80f,
    penThickness: Dp = 2.dp,
    circleDiameter: Float = canvasSize / 2,
    animationDuration: Int = 500
) {

    val transition = rememberInfiniteTransition()

    val rotation by transition.animateFloat(
        initialValue = 0F, targetValue = 180F, animationSpec = infiniteRepeatable(
            animation = tween(animationDuration * 2, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        )
    )

    val scale by transition.animateFloat(
        initialValue = 0.5f, targetValue = 1f, animationSpec = infiniteRepeatable(
            animation = tween(animationDuration, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Canvas(modifier = Modifier) {

        val sweepAngle = 120f
        val topArcStartAngle = 150f - rotation // Starting angle in degrees
        val bottomArcStartAngle = 330f - rotation // Starting angle in degrees

        val topArcPath = Path().apply {
            addArc(
                oval = Rect(
                    left = -canvasSize * scale,
                    top = -canvasSize * scale,
                    right = canvasSize * scale,
                    bottom = canvasSize * scale
                ),
                startAngleDegrees = topArcStartAngle,
                sweepAngleDegrees = sweepAngle
            )
        }

        val bottomArcPath = Path().apply {
            addArc(
                oval = Rect(
                    left = -canvasSize * scale,
                    top = -canvasSize * scale,
                    right = canvasSize * scale,
                    bottom = canvasSize * scale
                ),
                startAngleDegrees = bottomArcStartAngle,
                sweepAngleDegrees = sweepAngle
            )
        }

        drawPath(
            path = topArcPath,
            color = color,
            style = Stroke(
                width = penThickness.toPx(),
                cap = StrokeCap.Round,
                join = StrokeJoin.Round
            )
        )

        drawCircle(
            color = color,
            radius = (circleDiameter / 2) * scale,
        )

        drawPath(
            path = bottomArcPath,
            color = color,
            style = Stroke(
                width = penThickness.toPx(),
                cap = StrokeCap.Round,
                join = StrokeJoin.Round
            )
        )
    }
}