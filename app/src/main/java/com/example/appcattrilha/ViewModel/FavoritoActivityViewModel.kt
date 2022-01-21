package com.example.appcattrilha.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.appcattrilha.Model.CatModel
import com.example.appcattrilha.Repositories.MainRepo

class FavoritoActivityViewModel: ViewModel(){
    private val mainRepo: MainRepo
    val getCatList: MutableLiveData<MutableList<CatModel>>
    get() = mainRepo.getCatModelLiveData

    init {
        mainRepo = MainRepo()
    }
}