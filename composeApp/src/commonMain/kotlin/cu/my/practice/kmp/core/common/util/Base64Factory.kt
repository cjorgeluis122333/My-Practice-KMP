package cu.my.practice.kmp.core.common.util

object Base64Factory {
    fun encode(input: ByteArray): String = encodeBase64(input)
    fun decode(input: String): ByteArray = decodeBase64(input)

}


expect fun encodeBase64(input: ByteArray): String
expect fun decodeBase64(input: String): ByteArray