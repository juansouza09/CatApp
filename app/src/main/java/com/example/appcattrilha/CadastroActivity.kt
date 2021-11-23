package com.example.appcattrilha

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_cadastro)

        val btnCadastro = findViewById<Button>(R.id.cadastro_button)
        btnCadastro.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }

        val btnCancelar = findViewById<Button>(R.id.cancelar_button)
        btnCancelar.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}