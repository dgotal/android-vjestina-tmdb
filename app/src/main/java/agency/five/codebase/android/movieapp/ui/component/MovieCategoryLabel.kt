package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import androidx.annotation.StringRes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

data class MovieCategoryLabelViewState(
    val itemId: Int,
    val isSelected: Boolean,
    val categoryText: MovieCategoryLabelTextViewState
)

sealed class MovieCategoryLabelTextViewState {
    class InputText(val text: String) : MovieCategoryLabelTextViewState()
    class ResourceText(@StringRes val textRes: Int) : MovieCategoryLabelTextViewState()
}

@Composable
fun MovieCategoryLabel(
    movieCategoryLabelViewState: MovieCategoryLabelViewState,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    if (movieCategoryLabelViewState.isSelected) {
        Column(
            modifier = modifier
                .width(intrinsicSize = IntrinsicSize.Max)
                .clickable(onClick = onClick)
        ) {
            Text(
                text = selectTextSource(movieCategoryLabelViewState = movieCategoryLabelViewState),
                color = Color.Black,
                fontWeight = FontWeight.Bold,
                fontSize = dimensionResource(id = R.dimen.movie_category_label_font_size).value.sp,
                modifier = Modifier
                    .padding(dimensionResource(id = R.dimen.padding_small))
                    .fillMaxWidth()
            )
            Spacer(
                modifier = Modifier
                    .size(dimensionResource(id = R.dimen.movie_label_spacer_size))
            )
            Divider(
                color = Color.Black,
                thickness = dimensionResource(id = R.dimen.movie_label_thickness),
                modifier = Modifier
                    .fillMaxWidth()
            )
        }
    } else {
        Text(
            text = selectTextSource(movieCategoryLabelViewState = movieCategoryLabelViewState),
            color = Color.Gray,
            fontSize = dimensionResource(id = R.dimen.movie_category_label_font_size).value.sp,
            modifier = modifier
                .padding(dimensionResource(id = R.dimen.padding_small))
                .clickable(onClick = onClick)
        )
    }
}

@Composable
fun selectTextSource(movieCategoryLabelViewState: MovieCategoryLabelViewState): String {
    return when (val categoryText = movieCategoryLabelViewState.categoryText) {
        is MovieCategoryLabelTextViewState.InputText -> categoryText.text
        is MovieCategoryLabelTextViewState.ResourceText -> stringResource(id = categoryText.textRes)
    }
}

@Preview
@Composable
fun MovieCategoryLabelPreview() {
    val inputText = MovieCategoryLabelTextViewState.InputText("Movies")
    val stringRes = MovieCategoryLabelTextViewState.ResourceText(R.string.app_name)
    val categoryViewState1 = MovieCategoryLabelViewState(0, true, stringRes)
    val categoryViewState2 = MovieCategoryLabelViewState(1, false, inputText)
    Row {
        MovieCategoryLabel(movieCategoryLabelViewState = categoryViewState1,
            { })
        MovieCategoryLabel(movieCategoryLabelViewState = categoryViewState2,
            { })
    }
}
