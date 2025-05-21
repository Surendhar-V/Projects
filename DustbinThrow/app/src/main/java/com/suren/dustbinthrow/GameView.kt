package com.suren.dustbinthrow

import android.app.Activity
import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.os.Build
import android.util.DisplayMetrics
import android.view.MotionEvent
import android.view.View
import android.view.WindowManager
import java.util.logging.Handler
import kotlin.random.Random


class GameView(val context: Context):View(context) {

    var dWidth :Int =0
    var dHeight :Int = 0
    private lateinit var handler : Handler
    private lateinit var runnable: Runnable
    val UPDATE_MILLIS = 30
    var handX : Int =0
    var handY : Int =0
    var plasticX : Int =0
    var plasticY : Int =0
    private lateinit var random : Random
    var plasticAnimation = false
    val points =0
    val TEXT_SIZE =120
    private lateinit var  textPaint : Paint
    private lateinit var healthPaint : Paint
    val life : Int = 3
    val handSpeed : Int = 0
    val trashX : Int = 0
    val trashY : Int = 0


    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        val activity : Activity = context as Activity
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val metrics = activity.windowManager.currentWindowMetrics
            dWidth = metrics.bounds.width()
            dHeight = metrics.bounds.height()
        } else {
            val windowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager
            val displayMetrics = DisplayMetrics()
            @Suppress("DEPRECATION")
            windowManager.defaultDisplay.getMetrics(displayMetrics)
            dWidth = displayMetrics.widthPixels
            dHeight = displayMetrics.heightPixels
        }

    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        return true
    }


}