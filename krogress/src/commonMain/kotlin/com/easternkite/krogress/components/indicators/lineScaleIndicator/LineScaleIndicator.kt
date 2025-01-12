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
package com.easternkite.krogress.components.indicators.lineScaleIndicator

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import com.easternkite.krogress.enums.PunchType

@Composable
fun LineScaleIndicator(
    color: Color = Color.White,
    rectCount: Int = 5,
    distanceOnXAxis: Float = 30f,
    lineHeight: Int = 100,
    animationDuration: Int = 500,
    punchType: PunchType,
    lineType: StrokeCap = StrokeCap.Round,
    minScale: Float = 0.3f,
    maxScale: Float = 1.5f,
    penThickness: Float = 15f
) {
    when (punchType) {
        PunchType.RANDOM_PUNCH -> LineScalePartyIndicator(
            color = color,
            lineCount = rectCount,
            lineHeight = lineHeight,
            animationDuration = animationDuration,
            penThickness = penThickness,
            minScale = minScale,
            maxScale = maxScale,
            distanceOnXAxis = distanceOnXAxis,
            lineType = lineType
        )

        PunchType.ACCORDION_PUNCH -> SimpleLineScaleIndicator(
            color = color,
            lineCount = rectCount,
            lineHeight = lineHeight,
            animationDuration = 600,
            penThickness = penThickness,
            minScale = minScale,
            maxScale = maxScale,
            distanceOnXAxis = distanceOnXAxis,
            lineType = lineType
        )

        PunchType.SYMMETRIC_PUNCH -> LineScalePulseOutIndicator(
            color = color,
            lineCount = rectCount,
            lineHeight = lineHeight,
            animationDuration = animationDuration,
            penThickness = penThickness,
            minScale = minScale,
            maxScale = maxScale,
            distanceOnXAxis = distanceOnXAxis,
            lineType = lineType
        )

        PunchType.PULSE_OUT_PUNCH -> LineScalePulseOutRapidIndicator(
            color = color,
            lineCount = rectCount,
            distanceOnXAxis = distanceOnXAxis,
            lineHeight = lineHeight,
            animationDuration = animationDuration,
            penThickness = penThickness,
            minScale = minScale,
            maxScale = maxScale,
            lineType = lineType
        )
    }
}