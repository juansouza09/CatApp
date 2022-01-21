package com.example.appcattrilha.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appcattrilha.Model.CatModel
import com.example.appcattrilha.R
import com.squareup.picasso.Picasso

class CatListAdapterFavorito(var context: Context, var catModelList: MutableList<CatModel>):
    RecyclerView.Adapter<CatListAdapterFavorito.MyViewModel> () {
   inner class MyViewModel(itemView: View) : RecyclerView.ViewHolder(itemView) {

       var imgCat: ImageView
       var txtCatName: TextView

       init {
            imgCat = itemView.findViewById(R.id.imgCatFavo)
           txtCatName = itemView.findViewById(R.id.txtCatNameFavo)
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatListAdapterFavorito.MyViewModel {
        return MyViewModel(LayoutInflater.from(context).inflate(R.layout.item_view_favorite, parent, false))
    }

    override fun onBindViewHolder(holder: CatListAdapterFavorito.MyViewModel, position: Int) {
        Picasso.get().load(catModelList[position].image?.url).into(holder.imgCat)
        holder.txtCatName.text = catModelList[position].name
    }

    override fun getItemCount(): Int {
        return catModelList.size
    }
}