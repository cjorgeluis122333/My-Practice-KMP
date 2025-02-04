package cu.my.practice.kmp.core.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ContactEntity(
    @ColumnInfo("first_name") val firstName: String,
    @ColumnInfo("last_name") val lastName: String,
    @PrimaryKey @ColumnInfo("font_number") val fontNumber: String,
    val city: String
)