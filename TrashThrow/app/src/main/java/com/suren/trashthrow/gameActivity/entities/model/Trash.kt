package com.suren.trashthrow.gameActivity.entities.model

import android.graphics.Bitmap
import android.graphics.PointF
import com.suren.trashthrow.gameActivity.factory.GameFactory

class Trash(val pointF: PointF,  width: Int,  height: Int ) {

    var bitmap: Bitmap
        private set

    init {
        bitmap = GameFactory.getTrash(width , height)
    }

}