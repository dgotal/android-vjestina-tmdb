package agency.five.codebase.android.movieapp.ui.component

import agency.five.codebase.android.movieapp.R
import agency.five.codebase.android.movieapp.ui.theme.Blue
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FavoriteButton(
    isSelected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .size(width = 55.dp, height = 65.dp)
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
                .background(Blue.copy(alpha = 0.5f))
                .clickable(onClick = onClick)
        ) {
            Icon(
                painter = painterResource(id = if (isSelected) R.drawable.heart_icon_selected else R.drawable.heart_icon_notselected),
                contentDescription = null,
                modifier = Modifier
                    .size(25.dp),
            )
        }
    }

}

@Preview
@Composable
fun FavoriteButtonPreview() {
    var selected by remember { mutableStateOf(false) }
    FavoriteButton(isSelected = selected, onClick = { selected = selected.not() })
}