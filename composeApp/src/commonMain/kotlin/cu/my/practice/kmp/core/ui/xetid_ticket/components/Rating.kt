package cu.my.practice.kmp.core.ui.xetid_ticket.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import cu.my.practice.kmp.core.ui.xetid_ticket.dimen
import cu.my.practice.kmp.core.ui.xetid_ticket.rememberVectorPainter
/*
/**
 * @param value between 0 and 5f
 * */
@Composable
fun ReadOnlyRating(
    value: Float,
    modifier: Modifier = Modifier,
    size: Dp = 16.dp,
    spaceBetween: Dp = 2.dp
) {
    RatingBar(
        value = value,
        onValueChange = {},
        onRatingChanged = {},
        modifier = modifier,
        painterEmpty = rememberVectorPainter(
            image = Icons.Rounded.Star, MaterialTheme.colorScheme.surfaceVariant
        ),
        painterFilled = rememberVectorPainter(
            Icons.Rounded.Star, Gold
        ), size = size, spaceBetween = spaceBetween
    )
}

@Composable
fun SingleProgressBar(
    label: String,
    percent: Float,
    modifier: Modifier = Modifier,
) {
    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = label,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(end = MaterialTheme.dimen.verySmall)
        )
        LinearProgressIndicator(
            progress = { percent },
            modifier = Modifier
                .height(12.dp)
                .weight(1f),
            strokeCap = StrokeCap.Round,
        )
    }
}*/