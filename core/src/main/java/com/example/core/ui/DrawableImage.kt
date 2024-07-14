package com.example.core.ui

import android.graphics.drawable.Drawable
import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import com.example.core.utils.drawableToBitmap


@Composable
fun DrawableImage(modifier: Modifier = Modifier, drawable: Drawable) {
    val bitmap = drawableToBitmap(drawable)
    val imageBitmap = bitmap.asImageBitmap()

    Image(
        bitmap = imageBitmap,
        contentDescription = null,
        modifier = modifier
    )
}
