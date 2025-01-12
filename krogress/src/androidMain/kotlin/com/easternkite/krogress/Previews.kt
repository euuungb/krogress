package com.easternkite.krogress

import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.easternkite.krogress.components.indicators.PacmanIndicator

@Composable
@Preview
fun PacmanIndicatorPreview() {
    PacmanIndicator(modifier = Modifier.size(100.dp))
}