package cu.my.practice.kmp.feature.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hd.charts.BarChartView
import com.hd.charts.common.model.ChartDataSet
import com.hd.charts.style.BarChartDefaults
import com.hd.charts.style.ChartViewDefaults

@Composable
fun BarGraphScreen() {
}


@Composable
 fun AddDefaultBarChart() {
    BarChartView(
        dataSet = ChartDataSet(
            items = listOf(100f, 50f, 5f, 60f, -50f, 50f, 60f),
            title = "Bar chart"
        )
    )
}


@Composable
fun AddCustomBarChart() {

    val style = BarChartDefaults.style(
        barColor = Color.Blue,
        space = 12.dp,
        chartViewStyle = ChartViewDefaults.style(width = 200.dp)
    )

    BarChartView(
        dataSet = ChartDataSet(
            items = listOf(100f, 50f, 5f, 60f, 1f, 30f, 50f, 35f, 50f, -100f),
            title = "Bar char"
        ),
        style = style
    )
}