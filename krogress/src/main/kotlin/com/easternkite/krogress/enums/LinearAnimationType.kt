package com.easternkite.krogress.enums

enum class LinearAnimationType(val animDuration: Int, val circleDelay: Long) {
    CIRCULAR(500, 100L),
    SKIP_AND_REPEAT(250, 250L);
}