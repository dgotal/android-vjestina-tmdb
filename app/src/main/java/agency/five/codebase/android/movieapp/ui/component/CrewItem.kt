package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.mock.MoviesMock.getCrewman
import agency.five.codebase.android.movieapp.model.Crewman
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp

data class CrewItemViewState(
    val name: String,
    val job: String,
)

@Composable

fun CrewItem(
    crewItemViewState: CrewItemViewState,
    modifier: Modifier = Modifier,
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = crewItemViewState.name,
            fontSize = 15.sp,
            fontWeight = FontWeight.Bold,
        )
        Text(
            text = crewItemViewState.job,
            fontSize = 12.sp,
        )
    }
}
@Preview
@Composable
fun CrewItemPreview() {
    val crewman: Crewman = getCrewman()
    CrewItem(crewItemViewState = CrewItemViewState(name = crewman.name, job = crewman.job))
}