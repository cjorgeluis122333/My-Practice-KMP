package cu.my.practice.kmp.feature.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hd.charts.LineChartView
import com.hd.charts.common.model.ChartDataSet
import com.hd.charts.style.ChartViewDefaults
import com.hd.charts.style.LineChartDefaults

class LinealChartScreen {
}


@Composable
 fun AddDefaultLineChart() {
    val dataSet = ChartDataSet(
        items = listOf(
            8f, 23f, 54f, 32f, 12f, 37f, 7f, 23f, 43f
        ),
        title = "line_chart"
    )
    LineChartView(dataSet = dataSet)
}

@Composable
 fun AddCustomLineChart() {
    val style = LineChartDefaults.style(
        lineColor = Color.Blue,
        pointColor = Color.Magenta,
        pointSize = 9f,
        bezier = false,
        dragPointColor = Color.Yellow,
        dragPointVisible = false,
        dragPointSize = 8f,
        dragActivePointSize = 15f,
        chartViewStyle = ChartViewDefaults.style(width = 200.dp)
    )

    val dataSet = ChartDataSet(
        items = listOf(10f, 100f, 20f, 50f, 150f, 70f, 10f, 20f, 40f),
        title = "line_chart"
    )

    LineChartView(dataSet = dataSet, style = style)
}