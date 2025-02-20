package cu.my.practice.kmp.feature.home.component

import androidx.compose.material3.Badge
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import cu.my.practice.kmp.feature.home.model.BottomNavigationItem
import org.jetbrains.compose.resources.painterResource

@Composable
fun NavigationBarComponent(
    modifier: Modifier = Modifier, items: List<BottomNavigationItem>
) {
    var rememberIndex by rememberSaveable {
        mutableStateOf(0)
    }
    NavigationBar(modifier = modifier) {
        items.forEachIndexed { index, item ->


            NavigationBarItem(
                onClick = {
                    rememberIndex = index
                },
                selected = rememberIndex == index,
                icon = {

                    BadgedBox(badge = {
                        if (item.badgeCount != null) {
                            Badge {
                                Text("${item.badgeCount}")
                            }
                        } else if (item.hasNews) {
                            Badge()
                        }
                    }) {
                        Icon(
                            painter = if (rememberIndex == index) painterResource(item.selectedIcon) else painterResource(
                                item.unselectedIcon
                            ), contentDescription = item.title
                        )
                    }
                }, label = {
                    Text(text = item.title)
                })

        }
    }
}