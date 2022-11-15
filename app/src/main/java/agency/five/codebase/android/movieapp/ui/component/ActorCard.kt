package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import agency.five.codebase.android.movieapp.mock.MoviesMock
import agency.five.codebase.android.movieapp.model.Actor
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

data class ActorCardViewState(
    val imageUrl: String?,
    val name: String,
    val character: String,
)

@Composable
fun ActorCard(
    actorCardViewState: ActorCardViewState,
    modifier: Modifier = Modifier,
) {
    Card(
        modifier = modifier,
        elevation = dimensionResource(id = R.dimen.card_elevation),
        shape = AbsoluteRoundedCornerShape(dimensionResource(id = R.dimen.card_corner_radius)),
    )
    {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            AsyncImage(
                model = actorCardViewState.imageUrl,
                contentDescription = "${actorCardViewState.name} profile image",
                Modifier
                    .fillMaxWidth()
                    .height(dimensionResource(id = R.dimen.actor_image_height)),
            )
            Text(
                text = actorCardViewState.name,
                fontSize = dimensionResource(id = R.dimen.actor_name).value.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(
                    start = dimensionResource(id = R.dimen.padding_small),
                    top = dimensionResource(id = R.dimen.padding_small)
                )
            )
            Text(
                text = actorCardViewState.character,
                fontSize = dimensionResource(id = R.dimen.character_name).value.sp,
                color = Color.Gray,
                modifier = Modifier.padding(
                    start = dimensionResource(id = R.dimen.padding_small),
                    top = dimensionResource(id = R.dimen.padding_small)
                )
            )
        }
    }
}

@Preview
@Composable
private fun ActorCardPreview() {
    val actor: Actor = MoviesMock.getActor()
    val mockActorCardViewState = ActorCardViewState(
        name = actor.name,
        character = actor.character,
        imageUrl = actor.imageUrl,
    )
    ActorCard(
        actorCardViewState = mockActorCardViewState,
        modifier = Modifier
            .size(
                width = dimensionResource(id = R.dimen.card_width),
                height = dimensionResource(id = R.dimen.card_height)
            )
            .padding(
                dimensionResource(id = R.dimen.card_padding)
            ),
    )
}
