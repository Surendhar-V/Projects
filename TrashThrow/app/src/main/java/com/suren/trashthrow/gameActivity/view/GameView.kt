package com.suren.trashthrow.gameActivity.view

import android.content.Context
import android.content.res.Resources
import android.graphics.PointF
import android.util.Log
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat
import com.suren.trashthrow.R
import com.suren.trashthrow.gameActivity.entities.GameState
import com.suren.trashthrow.gameActivity.entities.model.Hand
import com.suren.trashthrow.gameActivity.entities.model.Trash
import com.suren.trashthrow.gameActivity.entities.model.TrashCan
import com.suren.trashthrow.gameActivity.factory.GameFactory
import com.suren.trashthrow.gameActivity.gameLoop.GameLoop
import javax.xml.xpath.XPath

class GameView(context: Context) : SurfaceView(context), SurfaceHolder.Callback {

    private var screenWidth: Float = 0f
    private var screenHeight: Float = 0f

    private lateinit var hand: Hand
    private lateinit var gameState: GameState
    private var topMargin = 100f
    private var gameLoop: GameLoop  = GameLoop(this)
    private var handWidth = 0
    private var handHeight = 0

    init {
        holder.addCallback(this)
    }

    override fun surfaceCreated(holder: SurfaceHolder) {}

    override fun surfaceChanged(holder: SurfaceHolder, format: Int, width: Int, height: Int) {

        val displayMetrics = Resources.getSystem().displayMetrics
        screenWidth = displayMetrics.widthPixels.toFloat()
        screenHeight = displayMetrics.heightPixels.toFloat()

        gameState = GameState.HOLDING_TRASH
        handWidth = (0.20 * screenWidth).toInt()
        handHeight = (0.06 * screenHeight).toInt()

        hand = Hand(pointF = PointF(screenWidth-(0.20*screenWidth).toInt() , topMargin) , width = (0.20*screenWidth).toInt() , height = (0.06 * screenHeight).toInt() )
        gameLoop.startLoop()

    }

    fun update() {
        hand.moveLeft()
    }

    fun render() {
        val canvas = holder.lockCanvas()
        if(canvas != null) {
            canvas.drawColor(ContextCompat.getColor(context, R.color.black))

            when (gameState) {

                GameState.HOLDING_TRASH -> {
                    canvas.drawBitmap(hand.bitmap, hand.pointF.x, hand.pointF.y, null)
                }

                GameState.FALLING_TRASH -> {
                    hand.bitmap = GameFactory.getHand(handWidth , handHeight)
                }

                GameState.TRASH_MISSED -> {}

                GameState.TRASH_DROPPED -> {}

            }
            holder.unlockCanvasAndPost(canvas)
        }

    }

    override fun surfaceDestroyed(holder: SurfaceHolder) {}

    override fun onTouchEvent(event: MotionEvent?): Boolean {

        if(event != null) {

            val x = event.x
            val y = event.y
            val handX = hand.pointF.x
            val handY = hand.pointF.y

            when (event.action) {

                MotionEvent.ACTION_DOWN -> {
                    if(withinBoundary(handX , handY , hand.bitmap.width , hand.bitmap.height , x , y)) {
                        gameState = GameState.FALLING_TRASH
                    }
                }


            }

        }

        return true

    }

    private fun withinBoundary(
        newX: Float,
        newY: Float,
        width: Int,
        height: Int,
        touchX: Float,
        touchY: Float
    ): Boolean {
        return newX < touchX && newX+width > touchX && newY < touchY && newY+height > touchX
    }

}
