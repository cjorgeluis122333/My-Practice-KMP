package cu.my.practice.kmp.exercite.discoDuroDeRoer.model

import cu.my.practice.kmp.exercite.discoDuroDeRoer.type.Sex

abstract class Person(
    open val name: String,
    open val sex: Sex,
    open val age: Int
) {
    abstract fun missToday(): Boolean

}