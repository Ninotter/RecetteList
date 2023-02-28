package com.nino.recettelist.viewmodels

import androidx.lifecycle.ViewModel
import com.nino.recettelist.dataclass.Recipe
import com.nino.recettelist.model.ApiCaller


class RecetteListViewModel: ViewModel(){
    val apiCaller = ApiCaller();


    suspend fun search(input: String): List<Recipe>{
        apiCaller.search = input
        return apiCaller.searchByString()
    }
}