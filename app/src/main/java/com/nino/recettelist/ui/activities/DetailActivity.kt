package com.nino.recettelist.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.nino.recettelist.R
import com.nino.recettelist.dataclass.Recipe
import com.nino.recettelist.viewmodels.RecetteListViewModel

class DetailActivity : AppCompatActivity() {
    lateinit var recipeADetail : Recipe
    //lateinit var recetteListViewModel: RecetteListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Créée un nouveau viewmodel, devrait récuperer le viewmodel ListeRecette déjà instancié plutôt
        //recetteListViewModel = ViewModelProvider(this).get(RecetteListViewModel::class.java)
        //this.recipeADetail = recetteListViewModel.subjectRecipe
        recipeADetail = intent.getParcelableExtra("recipe_data")!!
        setContentView(R.layout.activity_detail)
    }
}