package cu.my.practice.kmp.exercite.nowInAndroid.day1

import kotlin.math.abs

class Day1(private val myList: List<String>) {

    private var customList: Pair<List<Int>, List<Int>> = myList.map { it.split(" ") }.map {
        val a = it[0].toInt()
        val b = it[1].toInt()
        a to b //two list
    }.unzip()  //Permitted return a container fore two List

    fun getDistance():Int {
        val right: List<Int> = customList.first //Take  the first list of the container
        val left: List<Int> = customList.second //Take  the second list of the container

      return  right.zip(left).sumOf { (l,f)-> abs(l-f) }

    }

    fun getRepetition():Int{
        val right: List<Int> = customList.first //Take  the first list of the container
        val left: List<Int> = customList.second //Take  the second list of the container

        return right.sumOf {r->  r *left.count{it == r } }

    }
}