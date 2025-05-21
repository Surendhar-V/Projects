package com.suren.trashthrow.startGameActivity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.suren.trashthrow.R
import com.suren.trashthrow.databinding.ActivityMainBinding
import com.suren.trashthrow.gameActivity.GameActivity

class StartGameActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpUI()
        setUpListeners()
    }

    private fun setUpListeners() {
        binding.uiIvplayButton.setOnClickListener {
            val intent = Intent(this@StartGameActivity , GameActivity::class.java)
            startActivity(intent)
            finish()
        }
    }

    private fun setUpUI() {
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(0, systemBars.top,0, systemBars.bottom)
            insets
        }
    }


}