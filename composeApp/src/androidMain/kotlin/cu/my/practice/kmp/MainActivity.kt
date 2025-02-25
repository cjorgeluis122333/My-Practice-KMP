package cu.my.practice.kmp

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cu.my.practice.kmp.core.ui.component.ShimmerPictureAntTowText
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

@Preview
@Composable
fun ShowShimmer() {

}
