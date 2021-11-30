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

class CatListAdapter(var context: Context, var catModelList: MutableList<CatModel>):
    RecyclerView.Adapter<CatListAdapter.MyViewModel> () {
   inner class MyViewModel(itemView: View) : RecyclerView.ViewHolder(itemView) {

       var imgCat: ImageView
       var txtCatName: TextView
       var txtDesc: TextView
       var txtTemperamento: TextView

       init {
            imgCat = itemView.findViewById(R.id.imgCat)
           txtCatName = itemView.findViewById(R.id.txtCatName)
           txtDesc = itemView.findViewById(R.id.txtDesc)
           txtTemperamento = itemView.findViewById(R.id.txtTemperamento)
       }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatListAdapter.MyViewModel {
        return MyViewModel(LayoutInflater.from(context).inflate(R.layout.item_view_home, parent, false))
    }

    override fun onBindViewHolder(holder: CatListAdapter.MyViewModel, position: Int) {
        Picasso.get().load(catModelList[position].imageurl).into(holder.imgCat)
        holder.txtCatName.text = catModelList[position].name
        holder.txtDesc.text = catModelList[position].desc
        holder.txtTemperamento.text = catModelList[position].temperamento
    }

    override fun getItemCount(): Int {
        return catModelList.size
    }
}