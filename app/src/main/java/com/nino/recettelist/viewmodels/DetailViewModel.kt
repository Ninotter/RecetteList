package com.nino.recettelist.viewmodels

import androidx.lifecycle.ViewModel
import com.nino.recettelist.dataclass.Recipe
import com.nino.recettelist.model.ApiCaller

class DetailViewModel : ViewModel() {
    private val apiCaller = ApiCaller();


    suspend fun getSubjectRecipe(idInput: Int): Recipe{
        return apiCaller.findById(idInput)
    }
}