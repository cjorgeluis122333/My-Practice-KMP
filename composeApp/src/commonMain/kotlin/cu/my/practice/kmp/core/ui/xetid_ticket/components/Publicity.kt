package cu.my.practice.kmp.core.ui.xetid_ticket.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import cu.my.practice.kmp.core.model.main.Publicity
import cu.my.practice.kmp.core.ui.xetid_ticket.dimen
import kotlinx.coroutines.delay

@Composable
fun PublicityCard(
    publicity: Publicity,
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
) {
    Card(onClick = onClick, modifier = modifier) {
        when (publicity.formatID) {
            2 -> {
                PublicityItem2(
                    photo = publicity.photo,
                    title = publicity.title,
                    description = publicity.description.orEmpty()
                )
            }

            3 -> {
                PublicityItem3(
                    photo = publicity.photo,
                    title = publicity.title,
                    description = publicity.description.orEmpty()
                )
            }

            else -> {
                PublicityItem1(
                    photo = publicity.photo,
                    title = publicity.title,
                    description = publicity.description.orEmpty()
                )
            }
        }
    }

}

@Composable
fun PublicityItem1(
    photo: String?,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
) {

    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimen.small)
    ) {
        AsyncImage(
            model = photo,
            contentDescription = "publicity photo",
            modifier = Modifier
                .size(90.dp)
                .clip(MaterialTheme.shapes.small)
                .background(MaterialTheme.colorScheme.surfaceVariant),
            contentScale = ContentScale.Crop
        )

        Column(modifier = Modifier.padding(MaterialTheme.dimen.small)) {
            PublicityText(
                title = title,
                description = description,
                descriptionMaxLines = 3
            )
        }
    }
}

@Composable
fun PublicityItem2(
    photo: String?,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
) {
    Row(modifier.heightIn(max = 180.dp)) {
        AsyncImage(
            model = photo,
            contentDescription = "publicity photo",
            modifier = Modifier
                .fillMaxSize()
                .weight(2f / 3)
                .clip(MaterialTheme.shapes.small)
                .background(MaterialTheme.colorScheme.surfaceVariant),
            contentScale = ContentScale.Crop
        )

        Spacer(modifier = Modifier.width(MaterialTheme.dimen.mediumSmall))

        Column(
            Modifier
                .weight(1f / 3)
                .fillMaxHeight()
                .padding(MaterialTheme.dimen.small),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimen.small)
        ) {
            PublicityText(title = title, description = description, descriptionMaxLines = 8)
        }
    }
}

@Composable
fun PublicityItem3(
    photo: String?,
    title: String,
    description: String,
    modifier: Modifier = Modifier,
) {
    var isTextVisible by remember { mutableStateOf(true) }

    LaunchedEffect(Unit) {
        while (true) {
            delay(3000)
            isTextVisible = !isTextVisible
        }
    }

    Box(modifier.heightIn(max = 180.dp)) {
        AsyncImage(
            model = photo,
            contentDescription = "publicity photo",
            modifier = Modifier
                .fillMaxSize()
                .clip(MaterialTheme.shapes.medium)
                .background(MaterialTheme.colorScheme.surfaceVariant),
            contentScale = ContentScale.Crop,
        )

        if (isTextVisible) {
            Column(
                Modifier
                    .align(Alignment.BottomStart)
                    .background(
                        MaterialTheme.colorScheme.surface,
                        RoundedCornerShape(topEnd = MaterialTheme.dimen.medium)
                    )
                    .padding(MaterialTheme.dimen.small),
                verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimen.small)
            ) {
                PublicityText(title = title, description = description)
            }
        }
    }
}

/**
 * @param description next to title no matter layout
 * */
@Composable
fun PublicityText(
    title: String,
    description: String,
    descriptionMaxLines: Int = 3,
) {

    Text(
        text = title,
        style = MaterialTheme.typography.titleMedium,
        fontWeight = FontWeight.SemiBold,
        color = MaterialTheme.colorScheme.onBackground
    )

    Text(
        text = description,
        style = MaterialTheme.typography.bodyMedium,
        maxLines = descriptionMaxLines,
        overflow = TextOverflow.Ellipsis,
        color = MaterialTheme.colorScheme.onBackground
    )
}

@Composable
fun PublicityCardPrev() {
    MaterialTheme {
        val publicity = Publicity(
            id = 0,
            title = "Titulo de la publicidad",
            description = "Esta es la descripcion de la publicidad",
            formatID = 1
        )
        Column(
            Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(MaterialTheme.dimen.medium)
        ) {
            PublicityCard(
                publicity,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MaterialTheme.dimen.small)
            ) {}
            PublicityCard(
                publicity.copy(formatID = 2),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MaterialTheme.dimen.small)
            ) {}
            PublicityCard(
                publicity.copy(formatID = 3),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(MaterialTheme.dimen.small)
            ) {}
        }
    }
}