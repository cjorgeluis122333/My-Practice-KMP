package cu.my.practice.kmp.exercite.discoDuroDeRoer.model

import cu.my.practice.kmp.exercite.discoDuroDeRoer.type.Sex
import kotlin.math.abs
import kotlin.random.Random

data class Student(
    override val name: String,
    override val age: Int,
    override val sex: Sex,
    val lastNote:Int
) : Person(name, sex, age) {


    override fun missToday(): Boolean {
        val random: Int = abs(Math.random()*100).toInt()
        println("==============================Random Student $random")
        return random< 50
    }

}