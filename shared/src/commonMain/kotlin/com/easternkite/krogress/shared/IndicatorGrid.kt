package com.easternkite.krogress.shared

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.easternkite.krogress.components.indicators.BallBeatIndicator
import com.easternkite.krogress.components.indicators.BallClipRotateMultipleIndicator
import com.easternkite.krogress.components.indicators.BallClipRotatePulseIndicator
import com.easternkite.krogress.components.indicators.BallPulseRiseIndicator
import com.easternkite.krogress.components.indicators.BallPulseSyncIndicator
import com.easternkite.krogress.components.indicators.BallRotateIndicator
import com.easternkite.krogress.components.indicators.BallScaleIndicator
import com.easternkite.krogress.components.indicators.BallScaleMultipleIndicator
import com.easternkite.krogress.components.indicators.BallScaleRippleIndicator
import com.easternkite.krogress.components.indicators.BallScaleRippleMultipleIndicator
import com.easternkite.krogress.components.indicators.BallSpinFadeLoaderIndicator
import com.easternkite.krogress.components.indicators.BallTrianglePathIndicator
import com.easternkite.krogress.components.indicators.BallZigZagDeflectIndicator
import com.easternkite.krogress.components.indicators.BallZigZagIndicator
import com.easternkite.krogress.components.indicators.CircularPulsatingIndicator
import com.easternkite.krogress.components.indicators.CubeTransitionIndicator
import com.easternkite.krogress.components.indicators.LineSpinFadeLoaderIndicator
import com.easternkite.krogress.components.indicators.PacmanIndicator
import com.easternkite.krogress.components.indicators.PacmanIndicatorColors
import com.easternkite.krogress.components.indicators.PulsatingDot
import com.easternkite.krogress.components.indicators.SemiCircleSpinIndicator
import com.easternkite.krogress.components.indicators.SquareSpinIndicator
import com.easternkite.krogress.components.indicators.TriangleSpinIndicator
import com.easternkite.krogress.components.indicators.gridIndicator.BallGridBeatIndicator
import com.easternkite.krogress.components.indicators.gridIndicator.GridIndicator
import com.easternkite.krogress.components.indicators.lineScaleIndicator.LineScaleIndicator
import com.easternkite.krogress.enums.GridAnimationType
import com.easternkite.krogress.enums.PunchType
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun IndicatorGrid() {
    val rowHeight: Dp = 50.dp

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer),
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        // ------------------ Row #1 ----------------------
        Row(
            modifier = Modifier
                .height(rowHeight)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            PulsatingDot()
            GridIndicator(animationType = GridAnimationType.PULSATING)
            CircularPulsatingIndicator()
            BallClipRotatePulseIndicator()
        }

        // ------------------ Row #2 ----------------------
        Row(
            modifier = Modifier
                .height(rowHeight)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            SquareSpinIndicator()
            BallClipRotateMultipleIndicator()
            BallPulseRiseIndicator()
            BallRotateIndicator()
        }

        // ------------------ Row #3 ----------------------
        Row(
            modifier = Modifier
                .height(rowHeight)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            CubeTransitionIndicator()
            BallZigZagIndicator()
            BallZigZagDeflectIndicator()
            BallTrianglePathIndicator()
        }

        // ------------------ Row #4 ----------------------
        Row(
            modifier = Modifier
                .height(rowHeight)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BallScaleIndicator()
            LineScaleIndicator(punchType = PunchType.ACCORDION_PUNCH)
            LineScaleIndicator(punchType = PunchType.RANDOM_PUNCH)
            BallScaleMultipleIndicator()
        }

        // ------------------ Row #5 ----------------------
        Row(
            modifier = Modifier
                .height(rowHeight)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BallPulseSyncIndicator()
            BallBeatIndicator()
            LineScaleIndicator(punchType = PunchType.SYMMETRIC_PUNCH)
            LineScaleIndicator(punchType = PunchType.PULSE_OUT_PUNCH)
        }

        // ------------------ Row #6 ----------------------
        Row(
            modifier = Modifier
                .height(rowHeight)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            BallScaleRippleIndicator()
            BallScaleRippleMultipleIndicator()
            BallSpinFadeLoaderIndicator()
            LineSpinFadeLoaderIndicator()
        }

        // ------------------ Row #7 ----------------------
        Row(
            modifier = Modifier
                .height(rowHeight)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly,
            verticalAlignment = Alignment.CenterVertically
        ) {
            TriangleSpinIndicator()
            PacmanIndicator(
                colors = PacmanIndicatorColors.Default().copy(
                    arcColor = MaterialTheme.colorScheme.onPrimary,
                    circleColor = MaterialTheme.colorScheme.error
                )
            )
            GridIndicator(animationType = GridAnimationType.BEATING)
            SemiCircleSpinIndicator(modifier = Modifier.size(48.dp))
        }
    }
}

@Composable
fun NewIndicators() {
    LazyColumn(Modifier.fillMaxSize().background(MaterialTheme.colorScheme.primary).padding(vertical = 16.dp)) {
        item {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                PacmanIndicator(
                    colors = PacmanIndicatorColors.Default().copy()
                )
                SemiCircleSpinIndicator()
                PulsatingDot()
                BallGridBeatIndicator()
            }
        }
    }
}

@Preview
@Composable
fun IndicatorPreview() {
    NewIndicators()
}