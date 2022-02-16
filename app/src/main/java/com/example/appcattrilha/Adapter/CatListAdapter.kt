package com.example.appcattrilha.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.appcattrilha.Model.CatModel
import com.example.appcattrilha.Model.Favorite
import com.example.appcattrilha.R
import com.squareup.picasso.Picasso

class CatListAdapter(
    var context: Context,
    var catModelList: MutableList<CatModel>,
    val favoriteClickListener : (String) -> Unit
) :
    RecyclerView.Adapter<CatListAdapter.CatViewHolder>() {
    inner class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var imgCat: ImageView
        var txtCatName: TextView
        var txtDesc: TextView
        var txtTemperamento: TextView
        var ibFavorite : ImageButton

        init {
            imgCat = itemView.findViewById(R.id.imgCat)
            txtCatName = itemView.findViewById(R.id.txtCatData)
            txtDesc = itemView.findViewById(R.id.txtDesc)
            txtTemperamento = itemView.findViewById(R.id.txtTemperamento)
            ibFavorite = itemView.findViewById(R.id.ibFavorite)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatListAdapter.CatViewHolder {
        return CatViewHolder(
            LayoutInflater.from(context).inflate(R.layout.item_view_home, parent, false)
        )
    }

    override fun onBindViewHolder(holder: CatListAdapter.CatViewHolder, position: Int) {
        Picasso.get().load(catModelList[position].image?.url).into(holder.imgCat)
        holder.txtCatName.text = catModelList[position].name
        holder.txtDesc.text = catModelList[position].desc
        holder.txtTemperamento.text = catModelList[position].temperamento
        holder.ibFavorite.setOnClickListener {
            val img_id = catModelList[position].image?.id
            if (img_id != null){
            favoriteClickListener(img_id)
            }
        }
    }

    override fun getItemCount(): Int {
        return catModelList.size
    }
}