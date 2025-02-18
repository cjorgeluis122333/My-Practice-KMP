package cu.my.practice.kmp.core.common.util

import androidx.compose.ui.graphics.ImageBitmap



actual fun ImageBitmap.toByteArray(): ByteArray {
    throw NotImplementedError("La conversión de ImageBitmap a ByteArray en iOS debe implementarse")
}

actual fun ByteArray.toImageBitmap(): ImageBitmap {
    throw NotImplementedError("La conversión de ByteArray a ImageBitmap en iOS debe implementarse")
}