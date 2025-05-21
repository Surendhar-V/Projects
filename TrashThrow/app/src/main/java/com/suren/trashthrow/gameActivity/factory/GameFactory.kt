package com.suren.trashthrow.gameActivity.factory

import android.content.Context
import android.content.res.Resources
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.core.graphics.scale
import com.suren.trashthrow.gameActivity.entities.GameEntities

object GameFactory {

    private lateinit var resources: Resources

    fun init(context: Context) {
        resources = context.applicationContext.resources
    }

    fun getTrashCan(width : Int , height : Int) : Bitmap{
        return GameEntities.TRASHCAN.getBitmap().scale(width, height, false)
    }

    fun getHandWithTrash(width : Int , height : Int) : Bitmap{
        return GameEntities.HAND_WITH_TRASH.getBitmap().scale(width, height, false)
    }

    fun getTrash(width : Int , height : Int) : Bitmap{
        return GameEntities.TRASH.getBitmap().scale(width, height, false)
    }

    fun getHand(width : Int , height : Int) : Bitmap{
        return GameEntities.HAND_WITHOUT_TRASH.getBitmap().scale(width, height, false)
    }

    fun getBitmap(resId: Int): Bitmap {
        return BitmapFactory.decodeResource(resources, resId)
    }

}