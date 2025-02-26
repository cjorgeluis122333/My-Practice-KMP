package cu.my.practice.kmp.feature.graph

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.hd.charts.PieChartView
import com.hd.charts.common.model.ChartDataSet
import com.hd.charts.style.ChartViewDefaults
import com.hd.charts.style.PieChartDefaults
import cu.my.practice.kmp.core.ui.theme.BlueTheme
import cu.my.practice.kmp.core.ui.theme.SecondBlueTheme
import cu.my.practice.kmp.core.ui.theme.ThirdBlueTheme

class CakeBarScreen

@Composable
 fun AddDefaultPieChart() {
    val dataSet = ChartDataSet(
        items = listOf(8.0f, 23.0f, 54.0f, 32.0f, 12.0f, 37.0f, 7.0f, 23.0f, 43.0f),
        title = "pie chart",
        postfix = " °C"
    )

    PieChartView(dataSet = dataSet)
}

@Composable
 fun AddCustomPieChart() {
    val pieColors = listOf(
        BlueTheme,
        SecondBlueTheme,
        ThirdBlueTheme,
        Color.Magenta,
        Color.LightGray,
        Color.Gray,
        Color.DarkGray,
        Color.Yellow
    )

    val style = PieChartDefaults.style(
        borderColor = Color.White,
        donutPercentage = 40f,
        borderWidth = 6f,
        pieColors = pieColors,
        chartViewStyle = ChartViewDefaults.style(width = 200.dp)
    )

    val dataSet = ChartDataSet(
        items = listOf(60.0f, 25f, 15f, 14f, 30f, 30f, 20f, 30f),
        title = "Pie Chart",
        postfix = " °C"
    )

    PieChartView(dataSet = dataSet, style = style)
}