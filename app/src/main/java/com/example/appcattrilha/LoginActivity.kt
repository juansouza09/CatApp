package com.example.appcattrilha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_login)

        val button = findViewById<Button>(R.id.entrar_button)

        button.setOnClickListener {
            startActivity(Intent(this, ErroActivity::class.java))
        }

        val buttonCadastro = findViewById<Button>(R.id.criar_conta_button)
        buttonCadastro.setOnClickListener{
            startActivity(Intent(this, CadastroActivity::class.java))
        }
    }
}