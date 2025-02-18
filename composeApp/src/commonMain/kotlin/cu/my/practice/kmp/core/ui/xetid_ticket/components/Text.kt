package cu.my.practice.kmp.core.ui.xetid_ticket.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Clear
import androidx.compose.material.icons.rounded.LocationOn
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import cu.my.practice.kmp.core.ui.xetid_ticket.dimen
import org.jetbrains.compose.ui.tooling.preview.Preview

/**
 * @param widthFraction will be applied to fillMaxWidth()
 * */
@Composable
fun TextPlaceholder(
    widthFraction: Float,
    modifier: Modifier = Modifier,
    heightDp: Dp = MaterialTheme.dimen.mediumSmall,
) {
    Box(
        modifier = modifier
            .fillMaxWidth(widthFraction)
            .height(heightDp)
            .background(
                MaterialTheme.colorScheme.surfaceVariant,
                CircleShape
            )
    )
}

@Composable
fun TiTextInfo(
    leadingIcon: ImageVector,
    label: String,
    text: String,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        Row(verticalAlignment = Alignment.Top) {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null,
                Modifier
                    .padding(end = MaterialTheme.dimen.small)
            )
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Light
            )
        }

        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            modifier = Modifier.padding(start = MaterialTheme.dimen.large)
        )
    }
}

@Composable
fun TiTextInfoList(
    leadingIcon: ImageVector,
    label: String,
    names: List<String>,
    modifier: Modifier = Modifier,
) {
    Column(modifier) {
        Row(verticalAlignment = Alignment.Top) {
            Icon(
                imageVector = leadingIcon,
                contentDescription = null,
                Modifier
                    .padding(end = MaterialTheme.dimen.small)
            )
            Text(
                text = label,
                style = MaterialTheme.typography.bodySmall,
                fontWeight = FontWeight.Light
            )
        }

        names.map { text ->
            Text(
                text = text,
                style = MaterialTheme.typography.bodyMedium,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(start = MaterialTheme.dimen.large)
            )
        }
    }
}


@Composable
fun TiTextAction(
    modifier: Modifier = Modifier,
    text: String,
    trailingIcon: ImageVector = Icons.Rounded.Clear,
    onClickAction: () -> Unit = {},
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.SemiBold,
            maxLines = 2,
            modifier = Modifier
                .padding(horizontal = MaterialTheme.dimen.small)
                .weight(5F),
        )

        IconButton(
            onClick = onClickAction,
            modifier = Modifier
                .align(alignment = Alignment.CenterVertically)
                .weight(1F),
        ) {
            Icon(
                imageVector = trailingIcon,
                contentDescription = null,
            )
        }
    }
}

@Preview
@Composable
fun TextInfoPrev() {
    MaterialTheme {
        TiTextInfo(
            leadingIcon = Icons.Rounded.LocationOn,
            label = "Ubicacion",
            text = "Shangai"
        )
    }
}

@Preview
@Composable
fun TextActionPrev() {
    MaterialTheme {
        TiTextAction(
            text = "Shangai",
            trailingIcon = Icons.Rounded.LocationOn,
            onClickAction = {}
        )
    }
}
