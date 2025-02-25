package cu.my.practice.kmp.feature.graph

import androidx.compose.runtime.Composable
import com.hd.charts.StackedBarChartView
import com.hd.charts.common.model.MultiChartDataSet
import org.jetbrains.compose.resources.stringResource

class CakeBarScreen {
}

@Composable
private fun AddDefaultStackedBarChart() {
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
        title = "Bar"
    )

    StackedBarChartView(dataSet = dataSet)
}