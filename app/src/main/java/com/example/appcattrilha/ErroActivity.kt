package com.example.appcattrilha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ErroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_erro)

        val btnVoltar = findViewById<Button>(R.id.button_voltar)
         btnVoltar.setOnClickListener {
             startActivity(Intent(this, LoginActivity::class.java))
         }

    }
}