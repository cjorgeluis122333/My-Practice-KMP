package cu.my.practice.kmp.feature.contact_database

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun ContactScreen(viewModel: ContactViewModel = koinViewModel()) {

    Column(
        modifier = Modifier.fillMaxWidth().size(300.dp).shimmer(),
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(modifier = Modifier.fillMaxWidth().height(100.dp).background(color = Color.Yellow))
        Box(modifier = Modifier.fillMaxWidth().height(100.dp).background(color = Color.Gray))

    }

}