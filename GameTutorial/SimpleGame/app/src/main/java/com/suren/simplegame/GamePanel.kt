package com.suren.simplegame

import android.content.Context
import android.graphics.Color
import android.graphics.Paint
import android.graphics.PointF
import android.view.MotionEvent
import android.view.SurfaceHolder
import android.view.SurfaceView
import kotlin.random.Random

class GamePanel(context: Context?) : SurfaceView(context), SurfaceHolder.Callback {

    private val squares: MutableList<Square> = mutableListOf()
    private var screenHeight: Int = 0
    private var screenWidth: Int = 0
    private val gameLoop: GameLoop

    init {
        holder.addCallback(this)
        gameLoop = GameLoop(this)
    }


    override fun surfaceCreated(surfaceHolder: SurfaceHolder) {
        val size = getRandomSize()
        val paint = getRandomPaint()
        squares.add(Square(PointF(100f, 100f), paint, size))
        gameLoop.startLoop()
    }

    private fun getRandomSize(): Int {
        return Random.nextInt(50, 100)
    }

    private fun getRandomPaint(): Paint {
        val r = (Random.nextFloat() * 255).toInt()
        val g = (Random.nextFloat() * 255).toInt()
        val b = (Random.nextFloat() * 255).toInt()
        val a = 255
        val paint = Paint()
        paint.color = Color.argb(a, r, g, b)
        paint.style = Paint.Style.FILL
        return paint
    }

    fun render() {
        val canvas = holder.lockCanvas()
        canvas.drawColor(Color.BLACK)
        synchronized(squares) {
            squares.forEach {
                canvas.drawRect(
                    it.pointF.x,
                    it.pointF.y,
                    it.pointF.x + it.size,
                    it.pointF.y + it.size,
                    it.paint
                )
            }
        }
        holder.unlockCanvasAndPost(canvas)
    }

    override fun surfaceChanged(surfaceHolder: SurfaceHolder, i: Int, i1: Int, i2: Int) {
        val surfaceRect = holder.surfaceFrame
        screenWidth = surfaceRect.width()
        screenHeight = surfaceRect.height()
    }

    override fun surfaceDestroyed(surfaceHolder: SurfaceHolder) {}

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        val x = event?.x
        val y = event?.y
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                synchronized(squares) {
                    squares.add(Square(PointF(x ?: 0F, y ?: 0F), getRandomPaint(), getRandomSize()))
                }
            }
        }
        return true
    }

    fun update() {
        synchronized(squares) {
            squares.forEach { it.move(screenHeight, screenWidth) }
        }
    }


}