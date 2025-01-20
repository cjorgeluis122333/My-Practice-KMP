package cu.my.practice.kmp.exercite.discoDuroDeRoer.model

import cu.my.practice.kmp.exercite.discoDuroDeRoer.type.Sex
import cu.my.practice.kmp.exercite.discoDuroDeRoer.type.Signature
import kotlin.math.abs

data class Professor(
    override val name:String,
    override val sex: Sex,
    override val age:Int,
    val signature: Signature
):Person(name, sex, age){

    override fun missToday(): Boolean {
        val random: Int = abs(Math.random()*100).toInt()
        println("==============================Random Professor $random")
        return random<20
    }


}