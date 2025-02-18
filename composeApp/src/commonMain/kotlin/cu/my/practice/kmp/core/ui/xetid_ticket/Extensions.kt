package cu.my.practice.kmp.core.ui.xetid_ticket

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.Modifier
import androidx.paging.LoadState
import app.cash.paging.compose.LazyPagingItems
import com.valentinilk.shimmer.shimmer
import cu.my.practice.kmp.core.ui.xetid_ticket.Dimen
import cu.my.practice.kmp.core.ui.xetid_ticket.LocalDimen

val MaterialTheme.dimen: Dimen
    @Composable
    @ReadOnlyComposable
    get() = LocalDimen.current

val LazyPagingItems<*>.isRefreshing
    get() = loadState.refresh == LoadState.Loading
val LazyPagingItems<*>.isEmpty
    get() = itemCount == 0

@Composable
fun Modifier.shimmerIf(condition: () -> Boolean) = if (condition()) shimmer() else this
