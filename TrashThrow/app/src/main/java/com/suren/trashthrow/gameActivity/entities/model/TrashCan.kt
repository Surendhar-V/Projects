package com.suren.trashthrow.gameActivity.entities.model

import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.PointF
import com.suren.trashthrow.gameActivity.factory.GameFactory

class TrashCan(val pointF: PointF,  width: Int,  height: Int) {

    var bitmap: Bitmap = GameFactory.getTrashCan( width , height)

}