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
import androidx.compose.ui.graphics.Color

@Composable
fun BallPulseRiseIndicator(
    color: Color = Color.White,
    ballDiameter: Float = 40f,
    animationDuration: Int = 500,
    verticalSpace: Float = 50f,
    horizontalSpace: Float = 20f,
) {

    val position by rememberInfiniteTransition().animateFloat(
        initialValue = -verticalSpace,
        targetValue = verticalSpace,
        animationSpec = infiniteRepeatable(
            animation = tween(animationDuration, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Canvas(modifier = Modifier) {

        // ----------------- first row
        val xOffset = ballDiameter / 2 + horizontalSpace

        drawCircle(
            color = color,
            radius = ballDiameter / 2,
            center = Offset(
                x = center.x / 2 - xOffset,
                y = center.y / 2 + position,
            )
        )
        drawCircle(
            color = color,
            radius = ballDiameter / 2,
            center = Offset(
                x = center.x / 2 + xOffset,
                y = center.y / 2 + position,
            )
        )


        //------------ second row
        drawCircle(
            color = color,
            radius = ballDiameter / 2,
            center = Offset(
                x = center.x / 2 - 2 * xOffset,
                y = center.y / 2 - position,
            )
        )
        drawCircle(
            color = color,
            radius = ballDiameter / 2,
            center = Offset(
                x = center.x / 2,
                y = center.y / 2 - position,
            )
        )
        drawCircle(
            color = color,
            radius = ballDiameter / 2,
            center = Offset(
                x = center.x / 2 + 2 * xOffset,
                y = center.y / 2 - position,
            )
        )
    }
}