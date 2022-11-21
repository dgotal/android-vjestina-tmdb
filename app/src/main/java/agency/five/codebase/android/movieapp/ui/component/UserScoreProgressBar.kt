package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
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
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.sp

private const val STARTING_POSITION_OF_CIRCLE = -90f
private const val SWEEP_ANGLE = 360f
private const val DURATION_MILLIS = 650
private const val TO_GRADE = 10

@Composable
fun CircularProgressBar(
    score: Double,
    modifier: Modifier = Modifier,
    fontSize: TextUnit = dimensionResource(id = R.dimen.user_score_font_size).value.sp,
    strokeWidth: Dp = dimensionResource(id = R.dimen.padding_small)
) {
    val animationPlayed = remember { mutableStateOf(false) }
    val currentPercentage = animateFloatAsState(
        targetValue = (if (animationPlayed.value) score.toFloat() else 0f),
        animationSpec = tween(
            durationMillis = DURATION_MILLIS
        )
    )
    LaunchedEffect(key1 = true) {
        animationPlayed.value = true
    }
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .size(dimensionResource(id = R.dimen.movie_canvas_box_size) * 2f)
    ) {
        Canvas(
            modifier = modifier
                .padding(dimensionResource(id = R.dimen.padding_extra_small))
                .size(dimensionResource(id = R.dimen.movie_canvas_size) * 2f)
        ) {
            drawArc(
                color = GreenProgressBarBackground,
                startAngle = STARTING_POSITION_OF_CIRCLE,
                sweepAngle = SWEEP_ANGLE,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
            drawArc(
                color = GreenProgressBar,
                startAngle = STARTING_POSITION_OF_CIRCLE,
                sweepAngle = SWEEP_ANGLE * currentPercentage.value,
                useCenter = false,
                style = Stroke(strokeWidth.toPx(), cap = StrokeCap.Round)
            )
        }
        Text(
            text = (score * TO_GRADE).toString(),
            color = Color.Black,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold
        )
    }
}

@Preview(showBackground = true)
@Composable
fun CircularProgressBarPreview() {
    CircularProgressBar(score = 0.75)
}
