package com.example.appcattrilha

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import com.example.appcattrilha.databinding.TelaFavoritosBinding
import com.example.appcattrilha.databinding.TelaLoginBinding
import kotlinx.android.synthetic.main.tela_home.*

class FavoritoActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.tela_favoritos)

        setSupportActionBar(topAppBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}