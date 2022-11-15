package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import agency.five.codebase.android.movieapp.ui.theme.Blue
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteButton(
    isSelected: Boolean = false,
    onFavoriteButtonClick: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    Image(
        painter = painterResource(id = if (isSelected) R.drawable.heart_icon_selected else R.drawable.heart_icon_notselected),
        contentDescription = null,
        modifier = modifier
            .clickable { onFavoriteButtonClick(isSelected.not()) }
            .size(32.dp)
            .background(Blue.copy(alpha = 0.6F), CircleShape)
            .clip(CircleShape)
            .padding(
                start = dimensionResource(id = R.dimen.padding_small), end = dimensionResource(
                    id = R.dimen.padding_small
                ), top = dimensionResource(id = R.dimen.padding_medium), bottom = dimensionResource(
                    id = R.dimen.padding_medium
                )
            )
    )
}

@Preview
@Composable
fun FavoriteButtonPreview() {
    var selected by remember { mutableStateOf(false) }
    FavoriteButton(
        isSelected = selected,
        onFavoriteButtonClick = { selected = selected.not() },
    )
}
