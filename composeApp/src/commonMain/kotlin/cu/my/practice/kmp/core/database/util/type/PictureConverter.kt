package cu.my.practice.kmp.core.database.util.type

import androidx.room.TypeConverter
import cu.my.practice.kmp.core.common.util.base64Decode
import cu.my.practice.kmp.core.common.util.base64Encode

object PictureConverter {

    @TypeConverter
    fun fromByteArray(value: ByteArray?): String? {
        return value?.let { base64Encode(value) }
    }

    @TypeConverter
    fun toByteArray(value: String?): ByteArray? {
        return value?.let { base64Decode(value) }
    }

}