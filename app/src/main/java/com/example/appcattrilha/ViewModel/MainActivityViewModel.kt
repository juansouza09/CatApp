package com.example.appcattrilha.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appcattrilha.Model.CatModel
import com.example.appcattrilha.Repositories.FavoRepo
import com.example.appcattrilha.Repositories.MainRepo

class MainActivityViewModel: ViewModel(){
    private val mainRepo: MainRepo
    private val favoRepo: FavoRepo
    val getCatList: MutableLiveData<MutableList<CatModel>>
    get() = mainRepo.getCatModelLiveData

    init {
        mainRepo = MainRepo()
        favoRepo = FavoRepo()
    }

    fun saveFavoriteCat(id: String){
        favoRepo.saveFavorite(id)
    }
}