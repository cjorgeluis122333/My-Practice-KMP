package cu.my.practice.kmp.feature.home

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.BottomAppBar
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material.icons.sharp.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cu.my.practice.kmp.core.ui.Route
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = koinViewModel(),
    navigateTo: (Route) -> Unit = {},
    logOut: () -> Unit = {}
) {
    val state by viewModel.state.collectAsStateWithLifecycle()


    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Sharp.Menu, contentDescription = null)
                    }
                },
                title = { Text("Home") },
                actions = {

                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Sharp.Refresh, contentDescription = null)
                    }
                    IconButton(onClick = {}) {
                        Icon(imageVector = Icons.Sharp.Info, contentDescription = null)
                    }

                }
            )
        },
        bottomBar = {
            BottomAppBar {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    IconButton(
                        onClick = {},
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Person, contentDescription = null,
                            modifier = Modifier
                        )


                    }
                    IconButton(
                        onClick = {},
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Home, contentDescription = null,
                            modifier = Modifier

                        )
                    }
                    IconButton(
                        onClick = {},
                    ) {
                        Icon(
                            imageVector = Icons.Rounded.Settings, contentDescription = null,
                            modifier = Modifier

                        )
                    }
                }
            }
        }
    ) {


        HomeContent(it, navigateTo)
    }
}

@Composable
fun HomeContent(paddingValues: PaddingValues, navigateTo: (Route) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize(),
    ) {
        item {

            Card(modifier = Modifier.height(200.dp)) {
                Button(
                    onClick = { navigateTo(Route.Rick) },
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    shape = RoundedCornerShape(
                        20.dp
                    )
                ) {
                    Text(text = "Paging 3")
                }

            }

            Card(modifier = Modifier.height(200.dp)) {
                Button(
                    onClick = { navigateTo(Route.Contact) },
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    shape = RoundedCornerShape(
                        20.dp
                    )
                ) {
                    Text(text = "Room Database")
                }

            }

            Card(modifier = Modifier.height(200.dp)) {
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    shape = RoundedCornerShape(
                        20.dp
                    )
                ) {
                    Text(text = "Ktor Network")
                }
            }//paging
            Card(modifier = Modifier.height(200.dp)) {
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth().padding(8.dp),
                    shape = RoundedCornerShape(
                        20.dp
                    )
                ) {
                    Text(text = "Datastore")
                }

            }

        }

    }//End Column
}