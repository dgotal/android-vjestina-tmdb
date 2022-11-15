package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.mock.MoviesMock.getMoviesList
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
    val movieId: Int,
    val isFavorite: Boolean,
)

@Composable
fun MovieCard(
    movieCardViewState: MovieCardViewState,
    onMovieCardClick: () -> Unit,
    onFavoriteButtonClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.clickable { onMovieCardClick() },
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
                modifier = Modifier
                    .padding(9.dp)
                    .size(30.dp),
                isSelected = movieCardViewState.isFavorite,
                onFavoriteButtonClick = { onFavoriteButtonClick() }
            )
        }
    }
}

@Preview
@Composable
fun MovieCardPreview() {
    val movie = getMoviesList()[1]
    var onCardClick by remember { mutableStateOf(true) }
    var onFavoriteButtonClick by remember { mutableStateOf(true) }

    MovieCard(
        movieCardViewState = MovieCardViewState(
            imageUrl = movie.imageUrl,
            movieId = movie.id, isFavorite = movie.isFavorite
        ),
        modifier = Modifier.size(200.dp, 295.dp),
        onMovieCardClick = { onCardClick = !onCardClick },
        onFavoriteButtonClick = { onFavoriteButtonClick = !onFavoriteButtonClick },
    )
}
