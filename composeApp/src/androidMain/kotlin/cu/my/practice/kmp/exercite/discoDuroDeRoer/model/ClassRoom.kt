package cu.my.practice.kmp.exercite.discoDuroDeRoer.model

import cu.my.practice.kmp.exercite.discoDuroDeRoer.type.Sex
import cu.my.practice.kmp.exercite.discoDuroDeRoer.type.Signature

data class ClassRoom(
    val number: Int,
    val maxStudent: Int,
    val destination: Signature,
    val students: List<Student>,
    val professor: Professor
) {
    private lateinit var studentInTheClass: MutableList<Student>


    init {
        students.filter { !it.missToday() }.sortedBy { it.sex }.onEach {
            studentInTheClass.add(it)
        }
        println("==============================Student in the class$studentInTheClass")
    }

        fun startClass(): Boolean {
            return (studentInTheClass.size >= (maxStudent / 2) && !professor.missToday())
        }

        fun showTheNote() {
            println("===========================================================WOMAN note")
            val woman = studentInTheClass.filter { it.sex == Sex.WOMAN }
                .forEach { println("Student ${it.name} note : ${it.lastNote}") }
            println("===========================================================MAN note")

            val man = studentInTheClass.filter { it.sex == Sex.MALE }
                .forEach { println("Student ${it.name} note : ${it.lastNote} ") }
        }

    }
