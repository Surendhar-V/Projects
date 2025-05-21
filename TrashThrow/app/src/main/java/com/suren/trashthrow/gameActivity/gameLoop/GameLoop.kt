package com.suren.trashthrow.gameActivity.gameLoop

import android.util.Log
import com.suren.trashthrow.gameActivity.view.GameView
import com.suren.trashthrow.utils.Constants.TAG

class GameLoop(private val gameView: GameView) : Runnable {

    private var thread: Thread = Thread(this)

    override fun run() {
        var lastFPSCheck = System.currentTimeMillis()
        var fps = 0
        while (true) {
            gameView.render()
            gameView.update()
            fps++
            val now = System.currentTimeMillis()
            if (now - lastFPSCheck >= 1000) {
                Log.d(TAG, "FPS: $fps")
                fps = 0
                lastFPSCheck +=1000
            }
        }
    }

    fun startLoop() {
        thread.start()
    }


}