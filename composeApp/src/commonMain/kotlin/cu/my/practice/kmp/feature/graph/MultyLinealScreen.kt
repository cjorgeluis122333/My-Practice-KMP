package cu.my.practice.kmp.feature.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.hd.charts.LineChartView
import com.hd.charts.common.model.MultiChartDataSet
import com.hd.charts.style.ChartViewDefaults
import com.hd.charts.style.LineChartDefaults

class MultyLinealScreen {
}

@Composable
fun AddDefaultMultiLineChart() {
    val items = listOf(
        "Cherry St." to listOf(26000.68f, 28000.34f, 32000.57f, 45000.57f),
        "Strawberry Mall" to listOf(15261.68f, 17810.34f, 40000.57f, 85000f),
        "Lime Av." to listOf(4000.87f, 5000.58f, 30245.81f, 135000.58f),
        "Apple Rd." to listOf(1000.87f, 9000.58f, 16544.81f, 100444.87f)
    )

    val dataSet = MultiChartDataSet(
        items = items,
        prefix = "$",
        categories = listOf("Jan", "Feb", "Mar", "Apr"),
        title = "Line Chart"
    )

    LineChartView(
        dataSet = dataSet, style = LineChartDefaults.style()
    )
}

@Composable
fun AddCustomMultiLineChart() {
    val lineColors = listOf(Color.Blue, Color.LightGray, Color.DarkGray, Color.Magenta)
    val style = LineChartDefaults.style(
        lineColors = lineColors,
        dragPointVisible = false,
        pointVisible = true,
        pointColor = Color.Magenta,
        dragPointColor = Color.Red,
        chartViewStyle = ChartViewDefaults.style()
    )

    val items = listOf(
        "Cherry St." to listOf(26000.68f, 28000.34f, 32000.57f, 45000.57f),
        "Strawberry Mall" to listOf(15261.68f, 17810.34f, 40000.57f, 85000f),
        "Lime Av." to listOf(4000.87f, 5000.58f, 30245.81f, 135000.58f),
        "Apple Rd." to listOf(1000.87f, 9000.58f, 16544.81f, 100444.87f)
    )

    val dataSet = MultiChartDataSet(
        items = items,
        prefix = "$",
        categories = listOf("Jan", "Feb", "Mar", "Apr"),
        title = "Line Chart"
    )

    LineChartView(dataSet = dataSet, style = style)
}