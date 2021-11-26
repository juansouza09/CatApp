package com.example.appcattrilha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.widget.Button
import com.example.appcattrilha.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(R.layout.tela_splash)

        supportActionBar?.hide()

        Handler().postDelayed({
            val intent =   Intent(this@MainActivity, LoginActivity::class.java)
            startActivity(intent)
        }, 2000)
    }
}