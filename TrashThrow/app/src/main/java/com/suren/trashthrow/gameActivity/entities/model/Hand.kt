package com.suren.trashthrow.gameActivity.entities.model

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.PointF
import com.suren.trashthrow.gameActivity.factory.GameFactory

open class Hand(val pointF: PointF,  width: Int, height: Int) {

    fun moveLeft() {
        val newX = pointF.x-10
        if(newX < 0){
            val displayMetrics = Resources.getSystem().displayMetrics
            val screenWidth = displayMetrics.widthPixels.toFloat()
            pointF.x = screenWidth - bitmap.width.toInt()
        }else{
            pointF.x = newX
        }
    }

    var bitmap: Bitmap = GameFactory.getHandWithTrash(width, height)


}