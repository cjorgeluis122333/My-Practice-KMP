package cu.my.practice.kmp.core.ui.xetid_ticket.components
/*
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.unit.dp
import cu.my.practice.kmp.core.ui.xetid_ticket.dimen
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.random.Random

@Preview
@Composable
fun DetailsHeaderPlaceholder(modifier: Modifier = Modifier) {

    Row(modifier, verticalAlignment = Alignment.CenterVertically) {
        Box(
            modifier = Modifier
                .size(85.dp)
                .background(MaterialTheme.colorScheme.surfaceVariant, MaterialTheme.shapes.small)
        )

        Spacer(modifier = Modifier.width(MaterialTheme.dimen.medium))

        Column(verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimen.verySmall)) {
            TextPlaceholder(
                widthFraction = .8f,
                modifier = Modifier.padding(end = MaterialTheme.dimen.mediumSmall),
                heightDp = MaterialTheme.dimen.medium
            )

            Row {

                IconPlaceholder()

                Spacer(modifier = Modifier.width(MaterialTheme.dimen.verySmall))

                TextPlaceholder(
                    widthFraction = .5f,
                    heightDp = MaterialTheme.dimen.medium
                )
            }
        }
    }
}

@Composable
private fun IconPlaceholder() {
    Box(
        modifier = Modifier
            .size(MaterialTheme.dimen.medium)
            .clip(MaterialTheme.shapes.small)
            .background(MaterialTheme.colorScheme.surfaceVariant)
    )
}

@Composable
fun DetailsHeader2Placeholder(columns: Int, modifier: Modifier = Modifier) {

    Row(
        horizontalArrangement = Arrangement.spacedBy(MaterialTheme.dimen.verySmall),
        modifier = modifier
    ) {
        repeat(columns) { index ->
            DetailsHeader2ColPlaceholder(Modifier.width(50.dp))

            if (index < columns - 1) {
                VerticalDivider(height = 32)
            }
        }
    }
}

@Preview
@Composable
private fun DetailsHeader2PlaceholderPrev() {
    DetailsHeader2Placeholder(4)
}

@Preview
@Composable
private fun DetailsHeader2ColPlaceholder(modifier: Modifier = Modifier) {
    Column(modifier.widthIn(max = 60.dp)) {
        Row {
            Box(
                modifier = Modifier
                    .height(MaterialTheme.dimen.medium)
                    .weight(2f)
                    .clip(MaterialTheme.shapes.small)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            )

            Spacer(modifier = Modifier.width(MaterialTheme.dimen.verySmall))

            Box(
                modifier = Modifier
                    .height(MaterialTheme.dimen.medium)
                    .weight(1f)
                    .clip(MaterialTheme.shapes.small)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            )
        }

        Spacer(modifier = Modifier.height(MaterialTheme.dimen.verySmall))

        TextPlaceholder(widthFraction = 1f, heightDp = MaterialTheme.dimen.medium)
    }
}

@Preview
@Composable
fun EstablishmentPlaceholder(modifier: Modifier = Modifier) {
    Column(modifier, verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimen.small)) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            TextPlaceholder(widthFraction = .3f, heightDp = MaterialTheme.dimen.medium)
            IconPlaceholder()
        }

        TextPlaceholder(
            widthFraction = .5f,
            heightDp = MaterialTheme.dimen.medium
        )

        Row {
            IconPlaceholder()

            Spacer(modifier = Modifier.width(MaterialTheme.dimen.verySmall))

            TextPlaceholder(
                widthFraction = .4f,
                heightDp = MaterialTheme.dimen.medium
            )
        }
    }
}

@Composable
fun DescriptionPlaceholder(lines: Int, modifier: Modifier = Modifier) {

    Column(modifier) {
        TextPlaceholder(widthFraction = .4f, heightDp = MaterialTheme.dimen.medium)

        Spacer(modifier = Modifier.height(MaterialTheme.dimen.verySmall))

        Column(verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimen.verySmall)) {
            repeat(lines) {
                TextPlaceholder(widthFraction = 1f)
            }
            TextPlaceholder(
                widthFraction = Random.nextDouble(.6).toFloat()
            )
        }
    }
}

@Preview
@Composable
private fun DescriptionPlaceholderPrev() {
    DescriptionPlaceholder(lines = 3)
}

@Composable
fun ButtonsPlaceholder(modifier: Modifier = Modifier) {

    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextPlaceholder(widthFraction = .5f, heightDp = MaterialTheme.dimen.veryLarge)
        SpacerHeight()
        TextPlaceholder(widthFraction = .5f, heightDp = MaterialTheme.dimen.veryLarge)
    }
}

@Preview
@Composable
private fun ButtonsPlaceholderPrev() {
    ButtonsPlaceholder()
}

@Preview
@Composable
fun BiggerRatingPlaceholder(modifier: Modifier = Modifier) {
    Column(
        modifier
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            TextPlaceholder(widthFraction = .3f)

            IconPlaceholder()
        }

        Spacer(modifier = Modifier.height(MaterialTheme.dimen.verySmall))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimen.small),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1.2f)
            ) {
                TextPlaceholder(
                    widthFraction = .5f,
                    heightDp = MaterialTheme.dimen.veryLarge,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                ReadOnlyRating(
                    value = 0f,
                    size = 14.dp,
                    spaceBetween = 4.dp
                )
                TextPlaceholder(
                    widthFraction = .5f,
                    heightDp = MaterialTheme.dimen.small,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )
            }
            Spacer(modifier = Modifier.width(MaterialTheme.dimen.small))

            Column(
                Modifier.weight(3f),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimen.superSmall)
            ) {
                repeat(5) {
                    SingleProgressBar(
                        label = "",
                        percent = 0F
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun BeneficiaryPlaceholder(modifier: Modifier = Modifier) {
    Column(
        modifier
    ) {
        Row(horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
            TextPlaceholder(widthFraction = .3f)

        }

        Spacer(modifier = Modifier.height(MaterialTheme.dimen.verySmall))

        Row(verticalAlignment = Alignment.CenterVertically) {
            Column(
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimen.small),
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(1.2f)
            ) {
                Box(
                    modifier = Modifier
                        .size(MaterialTheme.dimen.profilePhoto)
                        .clip(MaterialTheme.shapes.extraLarge)
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                )

            }
            Spacer(modifier = Modifier.width(MaterialTheme.dimen.small))

            Column(
                Modifier.weight(3f),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimen.superSmall)
            ) {
                repeat(3) {
                    SingleProgressBar(
                        label = "",
                        percent = 0F
                    )
                }
            }
        }
    }
}

@Preview
@Composable
fun ResourceAndDatePlaceholder(modifier: Modifier = Modifier) {
    Column(modifier.widthIn(max = 60.dp)) {
        Row {
            Box(
                modifier = Modifier
                    .height(MaterialTheme.dimen.medium)
                    .weight(1f)
                    .clip(MaterialTheme.shapes.small)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            )

            Spacer(modifier = Modifier.width(MaterialTheme.dimen.verySmall))

            Box(
                modifier = Modifier
                    .height(MaterialTheme.dimen.medium)
                    .weight(3f)
                    .clip(MaterialTheme.shapes.small)
                    .background(MaterialTheme.colorScheme.surfaceVariant)
            )
        }

        Spacer(modifier = Modifier.height(MaterialTheme.dimen.verySmall))

        TextPlaceholder(
            widthFraction = 0.1f,
            heightDp = MaterialTheme.dimen.small,
            modifier = Modifier.padding(start = MaterialTheme.dimen.lessLarge)
        )

        Column(
            modifier
                .widthIn(max = 60.dp)
                .padding(top = MaterialTheme.dimen.veryLarge)
        ) {
            Row {
                Box(
                    modifier = Modifier
                        .height(MaterialTheme.dimen.medium)
                        .weight(1f)
                        .clip(MaterialTheme.shapes.small)
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                )

                Spacer(modifier = Modifier.width(MaterialTheme.dimen.verySmall))

                Box(
                    modifier = Modifier
                        .height(MaterialTheme.dimen.medium)
                        .weight(3f)
                        .clip(MaterialTheme.shapes.small)
                        .background(MaterialTheme.colorScheme.surfaceVariant)
                )
            }

            Spacer(modifier = Modifier.height(MaterialTheme.dimen.verySmall))

            TextPlaceholder(
                widthFraction = 1f,
                heightDp = MaterialTheme.dimen.small,
                modifier = Modifier.padding(start = MaterialTheme.dimen.lessLarge)
            )
        }
    }

}*/