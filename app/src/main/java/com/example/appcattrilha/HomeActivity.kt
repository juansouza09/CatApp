package com.example.appcattrilha

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.appcattrilha.Adapter.CatListAdapter
import com.example.appcattrilha.ViewModel.MainActivityViewModel
import dmax.dialog.SpotsDialog
import kotlinx.android.synthetic.main.tela_home.*


class HomeActivity : AppCompatActivity() {

    var mainActivityViewModel: MainActivityViewModel? =  null
    var recyclerView: RecyclerView? =  null
    var adapter: CatListAdapter? =  null
    var layoutManager: LinearLayoutManager? =  null
    var dialog: AlertDialog? =  null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tela_home)

        mainActivityViewModel = ViewModelProvider(this)[MainActivityViewModel::class.java]

        dialog = SpotsDialog.Builder().setCancelable(false).setContext(this).build()
        dialog!!.show()

        recyclerView = findViewById(R.id.recyclerview_cats)
        recyclerView!!.setHasFixedSize(true)
        layoutManager = LinearLayoutManager(this)
        recyclerView!!.layoutManager = layoutManager

        mainActivityViewModel!!.getCatList.observe(this){catModels ->
            Log.e("MainActivity", "CatList: " + catModels.firstOrNull()?.name)

            if (catModels != null){
                adapter = CatListAdapter(this, catModels){
                    mainActivityViewModel?.saveFavoriteCat(it)
                    Toast.makeText(this, it, Toast.LENGTH_SHORT).show()
                }
                adapter!!.notifyDataSetChanged()
                recyclerView!!.adapter = adapter
                dialog!!.dismiss()
            }
        }



        topAppBar.setNavigationOnClickListener {
            // Handle navigation icon press
        openBottomSheet() // abre o Bottom sheet quando clica no menu

        }
            topAppBar.setOnMenuItemClickListener { menuItem ->
                when (menuItem.itemId) {
                    R.id.search -> {
                        // Handle search icon press
                        true
                    }
                    else -> false
                }
            }
        }

    fun openBottomSheet(){
        val addBottomSheetFragment = ActionBottom.newInstance()
        addBottomSheetFragment.show(
            supportFragmentManager, ActionBottom.TAG
        )
    }
    }