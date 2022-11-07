package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.ui.theme.GreenProgressBar
import agency.five.codebase.android.movieapp.ui.theme.GreenProgressBarBackground
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CircularProgressBar(
    modifier: Modifier = Modifier,
    score: Double,
) {
    val animationPlayed = remember { mutableStateOf(false) }
    val currentPercentage = animateFloatAsState(
        targetValue = (if (animationPlayed.value) score.toFloat() else 0f),
        animationSpec = tween(
            durationMillis = 650
        )
    )

    LaunchedEffect(key1 = true) {
        animationPlayed.value = true
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(35.dp * 2f)
    ) {
        Canvas(
            modifier = modifier
                .padding(2.dp)
                .size(30.dp * 2f)
        ) {
            drawArc(
                color = GreenProgressBarBackground,
                startAngle = -90f,
                sweepAngle = 360f,
                useCenter = false,
                style = Stroke(8.dp.toPx(), cap = StrokeCap.Round)
            )
            drawArc(
                color = GreenProgressBar,
                startAngle = -90f,
                sweepAngle = 360 * currentPercentage.value,
                useCenter = false,
                style = Stroke(8.dp.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(
            text = (score * 10).toString(),
            fontSize = 15.sp,
            color = Color.Black,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CircularProgressBarPreview() {
    CircularProgressBar(score = 0.75)
}