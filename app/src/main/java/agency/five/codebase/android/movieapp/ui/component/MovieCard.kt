package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.mock.MoviesMock.getMoviesList
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage

data class MovieCardViewState(
    val imageUrl: String?,
    val isFavorite: Boolean,
)

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun MovieCard(
    movieCardViewState: MovieCardViewState,
    onMovieCardClick: () -> Unit,
    onFavoriteButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier,
        onClick = onMovieCardClick,
        shape = MaterialTheme.shapes.medium,
    ) {
        Box()
        {
            AsyncImage(
                model = movieCardViewState.imageUrl,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth(1f),
                contentScale = ContentScale.FillWidth
            )
            FavoriteButton(
                modifier = Modifier,
                isSelected = movieCardViewState.isFavorite,
                onFavoriteButtonClick = onFavoriteButtonClick
            )
        }
    }
}

@Preview
@Composable
private fun MovieCardPreview() {
    val movieCardViewState = remember {
        val mockMovie = getMoviesList()[1]

        mutableStateOf(
            MovieCardViewState(
                imageUrl = mockMovie.imageUrl,
                isFavorite = mockMovie.isFavorite,
            )
        )
    }
    val movieCardModifier = Modifier
        .padding(4.dp)
        .size(
            width = 170.dp,
            height = 230.dp
        )
    MovieCard(
        movieCardViewState = movieCardViewState.value,
        modifier = movieCardModifier,
        onMovieCardClick = { },
        onFavoriteButtonClick = {
            val newMovieCardViewState = movieCardViewState.value.copy(
                isFavorite = !(movieCardViewState.value.isFavorite)
            )
            movieCardViewState.value = newMovieCardViewState
        }
    )
}
