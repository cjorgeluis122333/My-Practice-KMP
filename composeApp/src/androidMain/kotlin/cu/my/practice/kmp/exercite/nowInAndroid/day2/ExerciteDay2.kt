package cu.my.practice.kmp.exercite.nowInAndroid.day2

/*

7 6 4 2 1 SAFE because decreasing by 1 or 2
1 2 7 8 9 UNSAFE because [2 - 7] increase of 5
9 7 6 2 1 UNSAFE
1 3 2 4 5 UNSAFE because are increasing and decreasing the values
8 6 4 4 1 UNSAFE because [4 - 4] are equals
1 3 6 7 9 SAFE  because all level are increasing by 1,2 or 3

 */
val rowListString: List<String> = listOf(
    "7 6 4 2 1",
    "1 2 7 8 9",
    "9 7 6 2 1",
    "1 3 2 4 5",
    "8 6 4 4 1",
    "1 3 6 7 9"
)

fun getMatrix(): List<List<Int>> {
    return rowListString.map {
        it.split(" ").map { str -> str.toInt() }
    }

}

fun saySafeOreUnSafe() {
    val matrix = getMatrix()

    var cont = 0
    var first: Int
    var isAscend: Boolean? = null
    var isSafe = false
    matrix.onEach { i ->
        first = i[0]
        isAscend = null
        cont = 0
        if (isSafe) println("Is safe")
        isSafe = true

        i.onEach { j ->
            if (cont > 0 && j > first) { // first less than second
                if ((first + 3) < j) {
                    println("Unsafe the value $first is more big than 3 of $j")
                    isSafe = false
                }
                if (first == j) {
                    println("Unsafe the value $first == $j")
                    isSafe = false
                }
                if (isAscend == false) {
                    println("Unsafe the value because change the increasing flow with this value")
                    isSafe = false

                }
                isAscend = true
            } else if (cont > 0 && j < first) { // first bigger than second
                if ((first - 2) > j) {
                    println("Unsafe the value $first is more big than 2 of $j")
                    isSafe = false
                }
                if (first == j) {
                    println("Unsafe the value $first == $j")
                    isSafe = false

                }
                if (isAscend == true) {
                    println("Unsafe the value because change the decreasing flow with this value")
                    isSafe = false
                }
                isAscend = false
            } else if (cont > 0 && j == first) {
                println("Unsafe the value $first == $j")
                isSafe = false
            }

            cont++
            first = j
        }
    }
}
