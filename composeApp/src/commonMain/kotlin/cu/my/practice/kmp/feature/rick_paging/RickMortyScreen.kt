package cu.my.practice.kmp.feature.rick_paging

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.snapshotFlow
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import com.valentinilk.shimmer.shimmer
import cu.my.practice.kmp.core.model.character.CharacterDataModel
import cu.my.practice.kmp.core.ui.component.ShimmerPictureAntTowText
import cu.my.practice.kmp.core.ui.xetid_ticket.components.PullToRefreshContainer
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.distinctUntilChanged
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
    // Creamos un estado para controlar la posición de la lista
    var isShimmerLoading by remember { mutableStateOf(true) }
    val listState = rememberLazyListState().apply {

    }

    LaunchedEffect(key1 = getCharacters.loadState.refresh) {
        isShimmerLoading = getCharacters.loadState.refresh == LoadState.Loading
    }
    // Detectamos automáticamente cuando el usuario llega al final y hay un error en la paginación (append)
    LaunchedEffect(getCharacters.loadState.append) {
        snapshotFlow { listState.layoutInfo.visibleItemsInfo.lastOrNull()?.index }
            .distinctUntilChanged()
            .collect { lastVisibleIndex ->
                val totalItems = getCharacters.itemCount
                // Si el último índice visible es el último elemento y existe un error en append, se dispara el retry
                if (lastVisibleIndex == totalItems - 1 && getCharacters.loadState.append is LoadState.Error) {
                    // Se puede agregar un pequeño retraso si se requiere debounce
                    delay(300)
                    getCharacters.retry()
                }
            }
    }


    PullToRefreshContainer(
        refreshing = isShimmerLoading,
        onRefresh = {
            getCharacters.refresh()
        },
        state = listState,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.then(
            if (isShimmerLoading) Modifier.shimmer().padding(paddingValues) else modifier.padding(
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

                // Capturamos el error en la carga inicial cuando no hay datos
                getCharacters.loadState.refresh is LoadState.Error && getCharacters.itemCount == 0 -> {
                    val error = (getCharacters.loadState.refresh as LoadState.Error).error
                    item {
                        Box(
                            modifier = modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Check if you have internet connection",
                                    color = MaterialTheme.colorScheme.error,
                                    textAlign = TextAlign.Center
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                Button(onClick = { getCharacters.retry() }) {
                                    Text("Try Again")
                                }
                            }
                        }
                    }
                }
                //Is empty
                getCharacters.loadState.refresh is LoadState.NotLoading && getCharacters.itemCount == 0 -> {
                    item {
                        Box(
                            modifier = modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("The server steal not add any item")
                        }
                    }
                }

                else -> {
                    //If i not have a control fore de  error
                    items(getCharacters.itemCount) { it ->
                        getCharacters[it]?.let { ItemList(it) }
                    }
////
                    // Estado de carga para la siguiente página (append)
                    if (getCharacters.loadState.append is LoadState.Loading) {
                        item {
                            Box(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp),
                                contentAlignment = Alignment.Center
                            ) {
                                CircularProgressIndicator()
                            }
                        }
                    }

                    // Si ocurre un error al cargar la siguiente página, se muestra el mensaje y el botón "Try Again"
                    if (getCharacters.loadState.append is LoadState.Error) {
                        item {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .background(MaterialTheme.colorScheme.errorContainer)
                                    .padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = "Check you internet connection",
                                    color = MaterialTheme.colorScheme.error,
                                    textAlign = TextAlign.Center
                                )
                                Spacer(modifier = Modifier.height(8.dp))
                                TextButton(onClick = { getCharacters.retry() }) {
                                    Text(
                                        "Try Again",
                                        textAlign = TextAlign.Center,
                                        color = MaterialTheme.colorScheme.primary,
                                    )
                                }
                            }
                        }
                    }
                }//End else
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

