package cu.my.practice.kmp.feature.rick_paging

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.paging.LoadState
import app.cash.paging.compose.LazyPagingItems
import app.cash.paging.compose.collectAsLazyPagingItems
import coil3.compose.AsyncImage
import cu.my.practice.kmp.core.model.character.CharacterDataModel
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun RickMortyScreen(
    viewModel: RickMortyViewModel = koinViewModel()
) {
    val getCharacters = viewModel.getCharacters.collectAsLazyPagingItems()

    RickContent(getCharacters)
}

@Composable
fun RickContent(getCharacters: LazyPagingItems<CharacterDataModel>) {
    LazyColumn() {

        when {
            //Carga inicial
            getCharacters.loadState.refresh is LoadState.Loading && getCharacters.itemCount == 0 -> {
                item {
                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

                        CircularProgressIndicator(
                            modifier = Modifier.size(64.dp),
                            color = Color.White
                        )
                    }
                }
            }

            //Estado vacio
            getCharacters.loadState.refresh is LoadState.NotLoading && getCharacters.itemCount == 0 -> {
                item {
                    Text(text = "Todavía no hay personajes")
                }
            }

            getCharacters.loadState.hasError -> {
                item {

                    Box(
                        Modifier
                            .fillMaxSize()
                            .background(Color.Red), contentAlignment = Alignment.Center
                    ) {
                        Text(text = "Ha ocurrido un error")
                    }
                }
            }

            else -> {
                items(getCharacters.itemCount) { it ->
                    getCharacters[it]?.let { ItemList(it) }

                }
            }
        }


    }

}


@Composable
fun ItemList(character: CharacterDataModel) {
    Card(modifier = Modifier.fillMaxWidth().height(180.dp)) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

            AsyncImage(
                contentDescription = null,
                model = character.image,
                contentScale = ContentScale.FillBounds
            )
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(character.name)
            Text(character.location.name)
        }
    }
}