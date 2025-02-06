package cu.my.practice.kmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material.icons.rounded.Person
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.material.icons.sharp.Info
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material.icons.sharp.Refresh
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import cu.my.practice.kmp.exercite.nowInAndroid.day2.saySafeOreUnSafe
import cu.my.practice.kmp.shared.App

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            saySafeOreUnSafe()

            App()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview
@Composable
fun ShowHome() {
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


        Context(it)
    }
}

@Composable
fun Context(paddingValues: PaddingValues) {
    Column(
        modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()
    ) {
        Card(modifier = Modifier.height(200.dp)) {
              Button(onClick = {}, modifier = Modifier.fillMaxWidth().padding(8.dp), shape = RoundedCornerShape(
                  20.dp
              )) {
                  Text(text = "Paging 3")
              }

        }

        Card(modifier = Modifier.height(200.dp)) {
            Button(onClick = {}, modifier = Modifier.fillMaxWidth().padding(8.dp), shape = RoundedCornerShape(
                20.dp
            )) {
                Text(text = "Room Database")
            }

        }

        Card(modifier = Modifier.height(200.dp)) {
            Button(onClick = {}, modifier = Modifier.fillMaxWidth().padding(8.dp), shape = RoundedCornerShape(
                20.dp
            )) {
                Text(text = "Ktor Network")
            }
        }
        Card(modifier = Modifier.height(200.dp)) {
            Button(onClick = {}, modifier = Modifier.fillMaxWidth().padding(8.dp), shape = RoundedCornerShape(
                20.dp
            )) {
                Text(text = "Datastore")
            }

        }
    }
}