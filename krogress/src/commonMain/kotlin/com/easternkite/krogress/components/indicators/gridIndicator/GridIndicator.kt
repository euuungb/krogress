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

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.easternkite.krogress.enums.GridAnimationType

@Composable
fun GridIndicator(
    color: Color = Color.White,
    ballDiameter: Float = 40f,
    verticalSpace: Float = 20f,
    horizontalSpace: Float = 20f,
    minAlpha: Float = 0.2f,
    maxAlpha: Float = 1f,
    animationDuration: Int = 600,
    animationType: GridAnimationType
) {
    when (animationType) {
        GridAnimationType.BEATING -> BallGridBeatIndicator(
//            color,
//            ballDiameter,
//            verticalSpace,
//            horizontalSpace,
//            minAlpha,
//            maxAlpha,
//            animationDuration,
        )

        GridAnimationType.PULSATING -> GridPulsatingDot(
            color,
            ballDiameter,
            verticalSpace,
            horizontalSpace,
            minAlpha,
            maxAlpha,
            animationDuration,
        )

        GridAnimationType.DIAGONAL -> GridFadeDiagonal(
            color,
            ballDiameter,
            verticalSpace,
            horizontalSpace,
            minAlpha,
            maxAlpha,
            animationDuration,
        )

        GridAnimationType.ANTI_DIAGONAL -> GridFadeAntiDiagonal(
            color,
            ballDiameter,
            verticalSpace,
            horizontalSpace,
            minAlpha,
            maxAlpha,
            animationDuration,
        )
    }
}