package cu.my.practice.kmp.feature.home

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material.icons.sharp.Refresh
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cu.my.practice.kmp.core.ui.Route
import cu.my.practice.kmp.feature.home.component.NavigationBarComponent
import cu.my.practice.kmp.feature.home.model.BottomNavigationItem
import my_practice_kmp.composeapp.generated.resources.Res
import my_practice_kmp.composeapp.generated.resources.account_circle_24dp
import my_practice_kmp.composeapp.generated.resources.chat_24dp
import my_practice_kmp.composeapp.generated.resources.home_24dp
import org.koin.compose.viewmodel.koinViewModel

@OptIn(ExperimentalMaterial3Api::class)
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
            NavigationBarComponent(
                items = listOf(
                    BottomNavigationItem(
                        title = "Person",
                        selectedIcon = Res.drawable.account_circle_24dp,
                        unselectedIcon = Res.drawable.account_circle_24dp,
                        hasNews = true
                    ),
                    BottomNavigationItem(
                        title = "Home",
                        selectedIcon = Res.drawable.home_24dp,
                        unselectedIcon = Res.drawable.home_24dp
                    ),
                    BottomNavigationItem(
                        title = "Settings",
                        selectedIcon = Res.drawable.chat_24dp,
                        unselectedIcon = Res.drawable.chat_24dp,
                        hasNews = true,
                        badgeCount = 4
                    )
                )
            )
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
                    modifier = Modifier.fillMaxSize().padding(8.dp),
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
                    modifier = Modifier.fillMaxSize().padding(8.dp),
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
                    modifier = Modifier.fillMaxSize().padding(8.dp),
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
                    modifier = Modifier.fillMaxSize().padding(8.dp),
                    shape = RoundedCornerShape(
                        20.dp
                    )
                ) {
                    Text(text = "Datastore")
                }

            }
            Card(modifier = Modifier.height(200.dp)) {
                Button(
                    onClick = { navigateTo(Route.Gallery) },
                    modifier = Modifier.fillMaxSize().padding(8.dp),
                    shape = RoundedCornerShape(
                        20.dp
                    )
                ) {
                    Text(text = "Gallery")
                }

            }
        }

    }//End Column
}