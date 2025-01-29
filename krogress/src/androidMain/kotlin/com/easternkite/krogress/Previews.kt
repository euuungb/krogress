package com.easternkite.krogress

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.easternkite.krogress.components.indicators.PacmanIndicator
import com.easternkite.krogress.components.indicators.PulsatingDot
import com.easternkite.krogress.components.indicators.SemiCircleSpinIndicator
import com.easternkite.krogress.components.indicators.gridIndicator.BallGridBeatIndicator

@Composable
@Preview
fun PacmanIndicatorPreview() {
    PacmanIndicator()
}

@Composable
@Preview
fun SemiCircleSpinIndicatorPreview() {
    SemiCircleSpinIndicator()
}

@Composable
@Preview
fun PulsatingDotPreview() {
    PulsatingDot(modifier = Modifier.size(200.dp), dotsCount = 3, animationDuration = 600)
}

@Composable
@Preview
fun GridIndicatorPreview() {
    BallGridBeatIndicator(
        spanCount = 5,
        modifier = Modifier.size(100.dp)
    )
}