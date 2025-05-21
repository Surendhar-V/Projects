package com.suren.trashthrow.gameActivity.entities

import android.content.res.Resources
import android.graphics.Bitmap
import com.suren.trashthrow.gameActivity.factory.GameFactory
import com.suren.trashthrow.R

enum class GameEntities(private val resId :Int) {

    TRASH(R.drawable.dustbin),
    HAND_WITH_TRASH(R.drawable.hand_with_bottle),
    HAND_WITHOUT_TRASH(R.drawable.hand),
    TRASHCAN(R.drawable.dustbin);

    fun getBitmap() : Bitmap{
        return GameFactory.getBitmap(this.resId)
    }

}