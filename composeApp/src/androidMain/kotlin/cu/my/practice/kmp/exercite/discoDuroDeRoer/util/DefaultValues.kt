package cu.my.practice.kmp.exercite.discoDuroDeRoer.util

import cu.my.practice.kmp.exercite.discoDuroDeRoer.model.Student
import cu.my.practice.kmp.exercite.discoDuroDeRoer.type.Sex

class Generate(){

    val names: List<String> = listOf(
        "Maria", "Pepe", "Jorge", "Albert", "Ana", "Miguel", "Raul", "Beatriz"
    )
    lateinit var student: MutableList<Student>

    fun generateStudent(): List<Student> {
        val totalStudent = (Math.random() * 100).toInt()
        for (i in 0..totalStudent) {
            student.add(
                Student(
                    name = names[((names.size - 1) * Math.random()).toInt()],
                    age = 23,
                    sex = Sex.WOMAN,
                    lastNote = 32
                )
            )

        }

        return student
    }
}

