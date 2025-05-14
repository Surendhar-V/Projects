package com.suren.simplegame

import android.graphics.Paint
import android.graphics.PointF

data class Square(
    var pointF: PointF,
    val paint: Paint,
    val size: Int,
    private var xDir: Int = 1,
    private var yDir: Int = 1,
    private val step: Int = 10
) {

    fun move(screenHeight: Int, screenWidth: Int) {
        if (pointF.x + size >= screenWidth || pointF.x <= 0) {
            xDir *= -1
        }
        if (pointF.y + size >= screenHeight || pointF.y <= 0) {
            yDir *= -1
        }
        this.pointF.x += xDir * step
        this.pointF.y += yDir * step
    }

}