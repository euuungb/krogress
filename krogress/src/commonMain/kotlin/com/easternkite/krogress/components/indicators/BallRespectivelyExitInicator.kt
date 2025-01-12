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
import androidx.compose.animation.core.animate
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
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
fun BallRespectivelyExitIndicator(
    modifier: Modifier = Modifier,
    color: Color = Color.White,
    canvasSize: Float = 100f,
    circleDiameter: Float = 40f,
    animationDuration: Int = 2000
) {

    val circleCounts = 6

    val targetValues =
        listOf(
            0f,
            -canvasSize,
            -canvasSize / 2,
            -canvasSize,
            -canvasSize / 2,
            -canvasSize
        )

    val offsets: List<Float> = (0 until circleCounts).map { index ->
        var offset by remember { mutableStateOf(0f) }

        LaunchedEffect(key1 = Unit) {

            delay(index * (animationDuration / circleCounts).toLong())

            animate(
                initialValue = 0f,
                targetValue = 0f,
                animationSpec = infiniteRepeatable(
                    animation = keyframes {
                        durationMillis =
                            animationDuration
                        0f at 0 with FastOutSlowInEasing
                        targetValues[index] at animationDuration / circleCounts with FastOutSlowInEasing
                        targetValues[index] at animationDuration / 2 with FastOutSlowInEasing
                        0f at animationDuration / 2 with FastOutSlowInEasing
                        0f at animationDuration with FastOutSlowInEasing
                    },
                    repeatMode = RepeatMode.Restart,
                ),
            ) { value, _ -> offset = value }
        }
        offset
    }

    Canvas(modifier = modifier) {

        (0 until circleCounts).map { circleIndex ->
            drawCircle(
                color = color,
                radius = (circleDiameter / 2),
                center = when (circleIndex) {
                    0 -> Offset(x = 0f, 0f)
                    1 -> Offset(offsets[circleIndex], 0f)
                    2 -> Offset(offsets[circleIndex], offsets[circleIndex])
                    3 -> Offset(0f, offsets[circleIndex])
                    4 -> Offset(-offsets[circleIndex], offsets[circleIndex])
                    5 -> Offset(-offsets[circleIndex], 0f)
                    else -> Offset(x = 0f, 0f)
                }
            )
        }
    }
}