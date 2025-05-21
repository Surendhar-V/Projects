package com.suren.trashthrow.gameActivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.suren.trashthrow.R
import com.suren.trashthrow.gameActivity.factory.GameFactory
import com.suren.trashthrow.gameActivity.view.GameView

class GameActivity : AppCompatActivity() {

    private lateinit var view: GameView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = GameView(this)
        setContentView(view)
        GameFactory.init(this)
    }

}