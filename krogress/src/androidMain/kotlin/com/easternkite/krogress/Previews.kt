package com.easternkite.krogress

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.easternkite.krogress.components.indicators.PacmanIndicator
import com.easternkite.krogress.components.indicators.SemiCircleSpinIndicator

@Composable
@Preview
fun PacmanIndicatorPreview() {
    PacmanIndicator()
}

@Composable
@Preview
fun LineSpinFadeLoaderIndicatorPreview() {
    SemiCircleSpinIndicator()
}