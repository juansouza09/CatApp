package com.example.appcattrilha

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcattrilha.Adapter.CatListAdapter
import com.example.appcattrilha.Adapter.CatListAdapterFavorito
import com.example.appcattrilha.R
import com.example.appcattrilha.ViewModel.FavoritoActivityViewModel
import com.example.appcattrilha.ViewModel.MainActivityViewModel
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.tela_home.*

class FavoritoActivity : AppCompatActivity(){
    var favoritoActivityViewModel: FavoritoActivityViewModel? =  null
    private var recyclerView: RecyclerView? =  null
    var adapter: CatListAdapterFavorito? =  null
    var layoutManager: LinearLayoutManager? =  null
    var dialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_favoritos)

        favoritoActivityViewModel = ViewModelProvider(this)[FavoritoActivityViewModel::class.java]

        recyclerView = findViewById(R.id.recyclerViewFavorito)
        recyclerView!!.setHasFixedSize(true)
        layoutManager = GridLayoutManager(this, 2)
        recyclerView!!.layoutManager = layoutManager

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()
        dialog!!.show()

        favoritoActivityViewModel!!.getCatList.observe(this){catModels ->
            Log.e("FavoritoActivity", "CatList: " + catModels.firstOrNull()?.name)

            if (catModels != null){
                adapter = CatListAdapterFavorito(this, catModels)
                adapter!!.notifyDataSetChanged()
                recyclerView!!.adapter = adapter
                dialog!!.dismiss()
            }
        }

        setSupportActionBar(topAppBar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
}