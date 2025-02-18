package cu.my.practice.kmp.core.common.util

import platform.Foundation.NSData
import platform.Foundation.create
import platform.Foundation.base64EncodedStringWithOptions
import platform.Foundation.base64DecodedDataUsingEncoding

actual fun encodeBase64(input: ByteArray): String {
    val data = NSData.create(bytes = input, length = input.size.toULong())
    return data?.base64EncodedStringWithOptions(0) ?: ""
}

actual fun decodeBase64(input: String): ByteArray {
    val data = NSData.create(base64EncodedString = input, options = 0)
    return data?.let {
        ByteArray(it.length.toInt()).apply { it.getBytes(this) }
    } ?: ByteArray(0)
}
