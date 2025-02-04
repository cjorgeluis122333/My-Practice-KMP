package cu.my.practice.kmp.feature.admin

import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import org.koin.compose.viewmodel.koinViewModel

@Composable
fun AdminScreen(
     viewModel: AdminViewModel = koinViewModel()
) {
    Scaffold {
        Text("Admin Screen")
    }
}