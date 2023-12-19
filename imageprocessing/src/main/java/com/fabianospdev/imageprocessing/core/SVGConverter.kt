package com.fabianospdev.imageprocessing.core

import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import com.caverock.androidsvg.SVG
import com.fabianodev.imageprocessing.R
import java.io.File
import java.io.FileInputStream

internal class SVGConverter {

    fun convertToBitmap(context: Context, image: Any): Bitmap? {
        return anyToBitmap(context = context, svgImage = image)
    }

    private fun anyToBitmap(context: Context, svgImage: Any): Bitmap? {
        return try {
            when (svgImage) {
                is String -> {
                    val svg = loadSVGFromFile(svgFilePath = svgImage)
                    return convertSVGToBitmap(svg = svg)
                }

                is SVG -> {
                    return convertSVGToBitmap(svg = svgImage)
                }

                else -> {
                    println("Type is not supported!")
                    null
                }
            }
        } catch (e: Exception) {
            val errorBitmap = BitmapFactory.decodeResource(context.resources, R.drawable.errorconvert)
            errorBitmap
        }
    }

    private fun loadSVGFromFile(svgFilePath: String): SVG? {
        val file = File(svgFilePath)
        val inputStream = FileInputStream(file)
        return SVG.getFromInputStream(inputStream)
    }

    private fun convertSVGToBitmap(svg: SVG?): Bitmap? {
        if (svg == null) return null

        val bitmapWidth = svg.documentWidth.toInt()
        val bitmapHeight = svg.documentHeight.toInt()

        val bitmap = Bitmap.createBitmap(bitmapWidth, bitmapHeight, Bitmap.Config.ARGB_8888)
        val canvas = android.graphics.Canvas(bitmap)
        svg.renderToCanvas(canvas)

        return bitmap
    }
}