package cu.my.practice.kmp.core.ui.xetid_ticket.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun VerticalDivider(height: Int = 40) {
    Box(
        Modifier
            .size(1.dp, height.dp)
            .background(Color.LightGray)
    )
}