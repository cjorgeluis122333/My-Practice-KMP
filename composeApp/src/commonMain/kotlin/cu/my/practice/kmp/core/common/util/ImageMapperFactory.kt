package cu.my.practice.kmp.core.common.util

    import androidx.compose.ui.graphics.ImageBitmap

    expect fun ImageBitmap.toByteArray(): ByteArray
    expect fun ByteArray.toImageBitmap(): ImageBitmap
