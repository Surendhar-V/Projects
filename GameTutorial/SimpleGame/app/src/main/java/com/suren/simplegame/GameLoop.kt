package com.suren.simplegame

import android.util.Log

class GameLoop(private val gamePanel: GamePanel) : Runnable {

    private var thread: Thread = Thread(this)

    override fun run() {
        var lastFPSCheck = System.currentTimeMillis()
        var fps = 0
        while (true) {
            gamePanel.render()
            gamePanel.update()
            fps++
            val now = System.currentTimeMillis()
            if (now - lastFPSCheck >= 1000) {
                Log.i(TAG, "FPS: $fps")
                fps = 0
                lastFPSCheck +=1000
            }
        }
    }

    fun startLoop() {
        thread.start()
    }


}