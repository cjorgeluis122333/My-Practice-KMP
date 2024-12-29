package cu.my.practice.kmp.core.common.util

/**
 * Encodes a string to Base64.
 * @param toEncode String to encode.
 */
fun base64Encode(toEncode: String): String =
    Base64Factory.encode(toEncode.encodeToByteArray())

/**
 * Encodes a byte array to Base64.
 * @param toEncode ByteArray to encode.
 */
fun base64Encode(toEncode: ByteArray): String =
    Base64Factory.encode(toEncode)

/**
 * Decodes a Base64 string to its original representation with UTF-8.
 * @param encodedString Encoded UTF-8 string to decode.
 */
fun base64DecodeUTF8(encodedString: String): String =
    base64Decode(encodedString).decodeToString()

/**
 * Encodes a byte array to a Base64 URL-safe format.
 * @param url ByteArray to encode.
 */
fun base64UrlEncode(url: ByteArray): String =
    Base64Factory.encode(url)
        .replace("+", "-")
        .replace("/", "_")
        .trimEnd('=')

/**
 * Encodes a string to Base64 with UTF-8 charset.
 * @param toEncode String to encode.
 */
fun base64EncodeUTF8(toEncode: String): String =
    Base64Factory.encode(toEncode.encodeToByteArray())

/**
 * Decodes a Base64 string to a raw string.
 * @param encodedString Encoded string to decode.
 */
fun base64Decode(encodedString: String): ByteArray =
    Base64Factory.decode(encodedString)





/**
 * Decodes a Base64 string to a Bitmap (Android only).
 * @param avatarBase64 Base64 encoded string representing an image.
 */
/*
fun base64ToBitmap(avatarBase64: String?): Bitmap? = if (avatarBase64 != null) try {
    val decodedBytes = Base64Factory.decode(avatarBase64)
    BitmapFactory.decodeByteArray(decodedBytes, 0, decodedBytes.size)
} catch (e: Exception) {
    null
} else null
*/

