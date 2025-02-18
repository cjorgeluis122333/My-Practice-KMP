package cu.my.practice.kmp.core.model.main

enum class DatePickerRule {
    StartOf, DayAt, ToDay, DateRange;

    val id: Int
        get() = when (this) {
            StartOf -> 1
            DayAt -> 2
            ToDay -> 3
            DateRange -> 4
        }

    companion object {
        fun get(id: Int) = entries[id - 1]
    }
}