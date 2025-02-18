package cu.my.practice.kmp.core.ui.xetid_ticket.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import cu.my.practice.kmp.core.ui.xetid_ticket.dimen

@Composable
fun SpacerHeight(
    height: Dp = MaterialTheme.dimen.medium
) {
    Spacer(modifier = Modifier.height(height))
}

@Composable
fun SpacerWidth(
    width: Dp = MaterialTheme.dimen.medium
) {
    Spacer(modifier = Modifier.width(width))
}
