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

enum class SquareCardFace(val angle: Float, val axis: RotationAxis) {
    AxisX(angle = 180f, axis = RotationAxis.AxisX) {
        override val next: SquareCardFace
            get() = AxisY
    },
    AxisY(angle = 180f, axis = RotationAxis.AxisY) {
        override val next: SquareCardFace
            get() = AxisX
    };

    abstract val next: SquareCardFace
}