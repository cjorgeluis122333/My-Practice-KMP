package cu.my.practice.kmp.feature.graph.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import cu.my.practice.kmp.feature.graph.AddCustomBarChart
import cu.my.practice.kmp.feature.graph.AddCustomLineChart
import cu.my.practice.kmp.feature.graph.AddCustomMultiLineChart
import cu.my.practice.kmp.feature.graph.AddCustomPieChart
import cu.my.practice.kmp.feature.graph.AddCustomStackedBarChart
import cu.my.practice.kmp.feature.graph.AddDefaultBarChart
import cu.my.practice.kmp.feature.graph.AddDefaultLineChart
import cu.my.practice.kmp.feature.graph.AddDefaultMultiLineChart
import cu.my.practice.kmp.feature.graph.AddDefaultPieChart
import cu.my.practice.kmp.feature.graph.AddDefaultStackedBarChart

@Composable
fun ChartsScreen() {

    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
//Line
        item { AddDefaultLineChart() }
        item { AddCustomLineChart() }
//Bar
        item { AddDefaultBarChart() }
        item { AddCustomBarChart() }
//Snacked bar
        item { AddDefaultStackedBarChart() }
        item { AddCustomStackedBarChart() }
//Pie
        item { AddDefaultPieChart() }
        item { AddCustomPieChart() }

//Multi Lineal
        item { AddDefaultMultiLineChart() }
        item { AddCustomMultiLineChart() }
    }
}


