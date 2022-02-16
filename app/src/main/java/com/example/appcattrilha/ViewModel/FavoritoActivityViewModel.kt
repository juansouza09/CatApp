package com.example.appcattrilha.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appcattrilha.Model.CatModel
import com.example.appcattrilha.Repositories.FavoRepo

class FavoritoActivityViewModel: ViewModel(){
    private val favoRepo: FavoRepo
    val getCatList: MutableLiveData<MutableList<CatModel>>
    get() = favoRepo.getCatModelLiveData

    init {
        favoRepo = FavoRepo()
    }
}