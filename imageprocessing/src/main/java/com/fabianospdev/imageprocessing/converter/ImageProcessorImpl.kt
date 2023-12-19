package com.fabianospdev.imageprocessing.converter

import android.content.Context
import android.graphics.Bitmap
import android.widget.ImageView
import com.fabianospdev.imageprocessing.core.ImageProcessor

class ImageProcessorImpl : ImageProcessor {
    override fun imageCompressor(context: Context, image: Any): Bitmap? {
        return super.imageCompressor(context = context, image = image)
    }

    override fun imageDownloadTask(context: Context, imageView: ImageView, uri: String) {
        return super.imageDownloadTask(context, imageView, uri)
    }
}