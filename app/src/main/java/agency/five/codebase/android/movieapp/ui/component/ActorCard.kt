package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.mock.MoviesMock
import agency.five.codebase.android.movieapp.model.Actor
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.AbsoluteRoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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
        modifier.size(width = 150.dp, height = 270.dp),
        elevation = 50.dp,
        shape = AbsoluteRoundedCornerShape(18.dp),
    )
    {
        Column {
            Box(
                modifier.size(200.dp)
            ) {
                AsyncImage(
                    model = actorCardViewState.imageUrl,
                    contentDescription = null,
                    modifier
                        .scale(1.35f)
                        .size(170.dp),
                )
            }
            Box(
                modifier
                    .background(color = Color.White)
                    .size(width = 150.dp, height = 75.dp),
                contentAlignment = Alignment.Center,
            ) {
                Column {
                    Text(
                        text = actorCardViewState.name,
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                    )
                    Text(
                        text = actorCardViewState.character,
                        fontSize = 15.sp,
                        color = Color.Gray,
                    )
                }
            }
        }
    }
}

@Preview
@Composable
private fun ActorCardPreview() {
    val actor: Actor = MoviesMock.getActor()
    val actorCardViewState = ActorCardViewState(
        imageUrl = actor.imageUrl,
        name = actor.name,
        character = actor.character,
    )
    ActorCard(actorCardViewState = actorCardViewState)
}