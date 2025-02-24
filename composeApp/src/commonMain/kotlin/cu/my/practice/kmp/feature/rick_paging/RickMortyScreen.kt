package cu.my.practice.kmp.feature.rick_paging

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
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
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import com.valentinilk.shimmer.shimmer
import cu.my.practice.kmp.core.model.character.CharacterDataModel
import cu.my.practice.kmp.core.ui.component.ShimmerPictureAntTowText
import cu.my.practice.kmp.core.ui.xetid_ticket.components.PullToRefreshContainer
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RickMortyScreen(
    viewModel: RickMortyViewModel = koinViewModel()
) {
    val getCharacters = viewModel.getCharacters.collectAsLazyPagingItems()
    Scaffold {
        RickContent(getCharacters, paddingValues = it)
    }
}

@Composable
fun RickContent(
    getCharacters: LazyPagingItems<CharacterDataModel>,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    var isShimmerLoading by remember { mutableStateOf(true) }

    LaunchedEffect(key1 = getCharacters.loadState.refresh) {
        isShimmerLoading = getCharacters.loadState.refresh == LoadState.Loading
    }

    PullToRefreshContainer(
        refreshing = isShimmerLoading, onRefresh = {
            getCharacters.refresh()
        }, horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.then(
            if (isShimmerLoading) Modifier.shimmer().padding(paddingValues) else Modifier.padding(
                paddingValues
            )
        )
    ) {

        if (isShimmerLoading) {
            item {
                ShimmerPictureAntTowText()
            }
        } else {

            when {
                //Initial charge
                getCharacters.loadState.refresh is LoadState.Loading && getCharacters.itemCount == 0 -> {
                    item {
                        ShimmerPictureAntTowText()
                    }
                }

                //Estado vacio
                getCharacters.loadState.refresh is LoadState.NotLoading && getCharacters.itemCount == 0 -> {
                    item {
                        Text(text = "Todavía no hay personajes")
                    }
                }

                else -> {
                     //If i no control de
                    items(getCharacters.itemCount) { it ->
                        getCharacters[it]?.let { ItemList(it) }

                    }
                }
            }


        }//End else
    }//End PullToRefreshContainer
}//End Methode


@Composable
fun ItemList(
    character: CharacterDataModel, modifier: Modifier = Modifier
) {

    Spacer(modifier.height(16.dp))
    Card {
        Row(
            modifier = modifier.fillMaxWidth().height(100.dp)
                .clip(shape = RoundedCornerShape(20.dp)),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center

        ) {

            Spacer(modifier.weight(0.05f))
            Box(
                modifier = modifier.size(64.dp).clip(
                    shape = RoundedCornerShape(64.dp)
                )
            ) {
                AsyncImage(
                    contentDescription = null,
                    model = character.image,
                    contentScale = ContentScale.FillBounds
                )

            }
            Spacer(modifier.weight(0.1f))

            Column(modifier.weight(0.8f)) {
                Box(modifier.fillMaxWidth().height(24.dp)) {
                    Text(text = character.name)
                }
                Spacer(modifier.height(12.dp))
                Box(
                    modifier.fillMaxWidth().height(24.dp).padding(end = 16.dp)
                ) {
                    Text(text = character.location.name)
                }
            }

            Spacer(modifier.weight(0.05f))

        }
    }
}

