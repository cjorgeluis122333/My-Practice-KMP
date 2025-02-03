package cu.my.practice.kmp.exercite.nowInAndroid.day4

val list = listOf(//Result 18
    "M M M S X X M A S M",
    "M S A M X M S M S A",
    "A M X S X M A A M M",
    "M S A M A S M S M X",
    "X M A S A M X A M M",
    "X X A M M X X A M A",
    "S M S M S A S X S S",
    "S A X A M A S A A A",
    "M A M M M X M M M M",
    "M X M X A X M A S X"
).map { it.split(" ") }

fun countMatchesXMAS(): Int {
    val maxRow: Int = list.size
    val maxColumn: Int = if (list.isNotEmpty()) list[0].size else 0
    var count = 0
    println("======================== MAX COLUMN $maxColumn")
    println("======================== MAX COLUMN $maxRow")

    for (i in 0..<maxRow) {

        for (j in 0..<maxColumn) {

            if (list[i][j] == "X") {//Up
                if ((i - 3) >= 0) {
                    if (list[i - 1][j] == "M")
                        if (list[i - 2][j] == "A")
                            if (list[i - 3][j] == "S")
                                count++
                }
                if ((i + 3) < maxRow) { //Down
                    if (list[i + 1][j] == "M")
                        if (list[i + 2][j] == "A")
                            if (list[i + 3][j] == "S")
                                count++

                }

                if ((j - 3) >= 0) { //left
                    if (list[i][j - 1] == "M")
                        if (list[i][j - 2] == "A")
                            if (list[i][j - 3] == "S")
                                count++

                }

                if ((j + 3) < maxColumn) { //right
                    if (list[i][j + 1] == "M")
                        if (list[i][j + 2] == "A")
                            if (list[i][j + 3] == "S")
                                count++

                }
                if ((i-3)>=0 && (j+3)<maxColumn){ // up - right

                    if (list[i-1][j + 1] == "M")
                        if (list[i-2][j + 2] == "A")
                            if (list[i-3][j + 3] == "S")
                                count++
                }
                if ((i-3)>=0 && (j-3)>=0){ // up - left

                    if (list[i-1][j - 1] == "M")
                        if (list[i-2][j - 2] == "A")
                            if (list[i-3][j - 3] == "S")
                                count++

                }
                if ((i+3)<maxRow && (j+3)<maxColumn){//down - right

                    if (list[i+1][j + 1] == "M")
                        if (list[i+2][j + 2] == "A")
                            if (list[i+3][j + 3] == "S")
                                count++

                }
                if ((i+3)<maxRow && (j-3)>=0){//down - left
                    if (list[i+1][j - 1] == "M")
                        if (list[i+2][j - 2] == "A")
                            if (list[i+3][j - 3] == "S")
                                count++

                }


            }//End if


        }//End for

    }//End for
    return count;
}



