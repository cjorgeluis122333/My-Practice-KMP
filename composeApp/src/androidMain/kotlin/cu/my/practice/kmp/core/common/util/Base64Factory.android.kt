package cu.my.practice.kmp.core.common.util

import android.util.Base64

actual fun encodeBase64(input: ByteArray): String =
    Base64.encodeToString(input, Base64.NO_WRAP)

actual fun decodeBase64(input: String): ByteArray =
    Base64.decode(input, Base64.DEFAULT)
