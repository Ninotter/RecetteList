package com.nino.recettelist.viewmodels

import android.content.Intent
import androidx.lifecycle.ViewModel
import com.nino.recettelist.dataclass.Recipe
import com.nino.recettelist.model.ApiCaller
import com.nino.recettelist.ui.activities.RecetteListActivity


class RecetteListViewModel: ViewModel(){
    val apiCaller = ApiCaller();
    lateinit var subjectRecipe : Recipe


    suspend fun search(input: String): List<Recipe>{
        apiCaller.search = input
        return apiCaller.run()
    }
}