package cu.my.practice.kmp.core.ui.xetid_ticket.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.dp
import cu.my.practice.kmp.core.ui.xetid_ticket.dimen
import my_practice_kmp.composeapp.generated.resources.Res
import org.jetbrains.compose.resources.stringResource
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
fun TiCard(
    modifier: Modifier = Modifier,
    shape: Shape = CardDefaults.shape,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    clickable: Boolean = false,
    enabled: Boolean = true,
    onClick: () -> Unit = {},
    content: @Composable () -> Unit,
) {
    if (clickable) {
        ElevatedCard(
            onClick = { onClick() },
            modifier = modifier,
            shape = shape,
            colors = CardDefaults.cardColors(containerColor = containerColor),
            enabled = enabled,
        ) {
            content()
        }
    } else {
        ElevatedCard(
            modifier = modifier,
            shape = shape,
            colors = CardDefaults.cardColors(containerColor = containerColor),
        ) {
            content()
        }
    }
}
@Preview
@Composable
fun TiCardPrev() {
    MaterialTheme {
        TiCard(Modifier.padding(12.dp)) {
            Box(modifier = Modifier.size(200.dp)) {
                Text(text = "Hello World", modifier = Modifier.align(Alignment.Center))
            }
        }
    }
}

@Composable
fun DatePickerLegendCard(modifier: Modifier = Modifier) {
    ElevatedCard(
        modifier = modifier
            .padding(MaterialTheme.dimen.mediumSmall)
            .fillMaxWidth()
    ) {
        Column(
            Modifier.padding(MaterialTheme.dimen.medium),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimen.small)
        ) {
            Text(
                text = "Legend",
                style = MaterialTheme.typography.titleMedium
            )

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "5",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onPrimary,
                    modifier = Modifier
                        .background(MaterialTheme.colorScheme.primary, CircleShape)
                        .padding(
                            horizontal = MaterialTheme.dimen.lessLarge,
                            vertical = MaterialTheme.dimen.mediumSmall
                        )
                )

                Spacer(modifier = Modifier.width(MaterialTheme.dimen.medium))

                Text(
                    text = "Selected",
                    style = MaterialTheme.typography.titleMedium,
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "5",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary,
                    modifier = Modifier
                        .border(1.dp, MaterialTheme.colorScheme.primary, CircleShape)
                        .padding(
                            horizontal = MaterialTheme.dimen.lessLarge,
                            vertical = MaterialTheme.dimen.mediumSmall
                        )
                )

                Spacer(modifier = Modifier.width(MaterialTheme.dimen.medium))

                Text(
                    text = "Today",
                    style = MaterialTheme.typography.titleMedium,
                )
            }

            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = "5",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onSurface,
                    modifier = Modifier
                        .padding(
                            horizontal = MaterialTheme.dimen.lessLarge,
                            vertical = MaterialTheme.dimen.mediumSmall
                        )
                )

                Spacer(modifier = Modifier.width(MaterialTheme.dimen.medium))

                Text(
                    text = "",
                    style = MaterialTheme.typography.titleMedium,
                )
            }
        }
    }
}

@Preview
@Composable
fun LegendCardPrev() {
    MaterialTheme { DatePickerLegendCard() }
}
