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
package com.easternkite.krogress.enums

enum class TriangleCardFace(
    val axis: RotationAxis,
    val initValue: Float,
    val targetValue: Float
) {
    AxisY(axis = RotationAxis.AxisY, initValue = 0f, targetValue = 180f) {
        override val next: TriangleCardFace
            get() = AxisX
    },
    AxisX(axis = RotationAxis.AxisX, initValue = 0f, targetValue = 180f) {
        override val next: TriangleCardFace
            get() = MAxisY
    },
    MAxisY(axis = RotationAxis.AAxisY, initValue = 180f, targetValue = 0f) {
        override val next: TriangleCardFace
            get() = MAxisX
    },
    MAxisX(axis = RotationAxis.AAxisX, initValue = 180f, targetValue = 0f) {
        override val next: TriangleCardFace
            get() = AxisY
    };

    abstract val next: TriangleCardFace
}