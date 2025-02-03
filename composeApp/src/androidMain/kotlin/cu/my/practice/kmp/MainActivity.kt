package cu.my.practice.kmp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import cu.my.practice.kmp.exercite.nowInAndroid.day1.Day1
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
fun AppAndroidPreview() {
    val num: List<String> = listOf("2 4", "1 4", "1 4", "5 9", "4 5")
    val d1 = Day1(num)
    Column {

        Text("The result Range is " + d1.getDistance())
        Text("The result Repetitions is" + d1.getRepetition())
    }
//    Text("The result Range "+ getRangeBetweenTwoList())
//    Text("The result Repetitions "+ getRepetitionsBetweenTwoList())

}