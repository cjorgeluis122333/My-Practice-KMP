package cu.my.practice.kmp.exercite.nowInAndroid.day1

import kotlin.math.abs

val num: List<String> = listOf("2 4", "1 4", "1 4", "5 9", "4 5")
//Example:
//result  2 + 3 + 3 + 4 + 1 = 13
fun getRangeBetweenTwoList(): Int {
    val list = num.map { it.split(" ") }
    val (left, right) = list.map {
        val l = it[0].toInt()
        val r = it[1].toInt()
        l to r //You uses the to when you want return the value of the two list
    }
        .unzip() //When you work whit two list they are a Pair. UNZIP() quite the pair and let in her type

    val result = left.zip(right).sumOf { (l, r) ->
        abs(l - r)  //The distance between the values of the list
    }
    return result
}
/*Cantidad de veses que aparece cada numero de la primera lista en la segunda  y sumar el valor de
 el total de coinicdencias en las  dos listas
 Ejemplo: "1 3", "2 5", "1 4", "5 9", "4 5"
result = 2*0 + 1*0 + 1*0 + 5*1 + 4*3 = 12 + 5 = 17
*/

fun getRepetitionsBetweenTwoList(): Int {
    val list = num.map { it.split(" ") }
    val (left, right) = list.map {
        val l = it[0].toInt()
        val r = it[1].toInt()
        l to r //You uses the to when you want return the value of the two list
    }
        .unzip() //When you work whit two list they are a Pair. UNZIP() quite the pair and let in her type

    val result = left.sumOf { l ->
        l * right.count { it == l }
    }

    return result
}