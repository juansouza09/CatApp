package com.example.appcattrilha

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.appcattrilha.R
import kotlinx.android.synthetic.main.tela_home.*

class FavoritoActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.tela_favoritos)

        setSupportActionBar(topAppBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}