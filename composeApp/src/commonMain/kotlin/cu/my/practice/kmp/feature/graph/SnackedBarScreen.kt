package cu.my.practice.kmp.feature.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hd.charts.StackedBarChartView
import com.hd.charts.common.model.MultiChartDataSet
import com.hd.charts.style.ChartViewDefaults
import com.hd.charts.style.StackedBarChartDefaults

class SnackedBarScreen {
}

@Composable
fun AddDefaultStackedBarChart() {
    val items = listOf(
        "Cherry St." to listOf(8261.68f, 8810.34f, 30000.57f),
        "Strawberry Mall" to listOf(8261.68f, 8810.34f, 30000.57f),
        "Lime Av." to listOf(1500.87f, 2765.58f, 33245.81f),
        "Apple Rd." to listOf(5444.87f, 233.58f, 67544.81f)
    )

    val dataSet = MultiChartDataSet(
        items = items,
        prefix = "$",
        categories = listOf("Jan", "Feb", "Mar"),
        title = "Snacked Char"
    )

    StackedBarChartView(dataSet = dataSet)
}

@Composable
 fun AddCustomStackedBarChart() {
    val colors = listOf(
        Color.Blue, Color.DarkGray, Color.Red
    )
    val style = StackedBarChartDefaults.style(
        barColors = colors,
        chartViewStyle = ChartViewDefaults.style(width = 240.dp)
    )
    val items = listOf(
        "Cherry St." to listOf(8261.68f, 8810.34f, 30000.57f),
        "Strawberry Mall" to listOf(8261.68f, 8810.34f, 30000.57f),
        "Lime Av." to listOf(1500.87f, 2765.58f, 33245.81f),
        "Apple Rd." to listOf(5444.87f, 233.58f, 67544.81f)
    )

    val dataSet = MultiChartDataSet(
        items = items,
        prefix = "$",
        categories = listOf("Jan", "Feb", "Mar"),
        title = "Bar Stacked Chart"
    )

    StackedBarChartView(dataSet = dataSet, style = style)
}