package com.nino.recettelist.viewmodels

import androidx.lifecycle.ViewModel
import com.nino.recettelist.model.ApiCaller


class RecetteListViewModel: ViewModel(){
    val apiCaller = ApiCaller();


    suspend fun search(){
        val test:String? = apiCaller.run();
    }
}