package cu.my.practice.kmp.core.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.valentinilk.shimmer.shimmer

@Composable
fun ShimmerPictureAntTowText(
    modifier: Modifier = Modifier,
    quantity: Int = 7,
    imageSize: Int = 64
) {

    LazyColumn {

        items(quantity) {
            Spacer(modifier.height(16.dp))
            Row(
                modifier = modifier.fillMaxWidth().height(100.dp)
                    .clip(shape = RoundedCornerShape(20.dp)).shimmer(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center

            ) {

                Spacer(modifier.weight(0.05f))
                Box(
                    modifier = modifier.size(imageSize.dp).clip(
                        shape = RoundedCornerShape(imageSize.dp)
                    ).background(Color.Gray)
                )
                Spacer(modifier.weight(0.1f))

                Column(modifier.weight(0.8f)) {
                    Box(modifier.fillMaxWidth().height(24.dp).background(Color.Gray))
                    Spacer(modifier.height(12.dp))
                    Box(modifier.fillMaxWidth().height(24.dp).padding(end = 16.dp).background(Color.Gray))
                }

                Spacer(modifier.weight(0.05f))

            }
        }
    }

}