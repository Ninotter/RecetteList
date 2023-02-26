package com.nino.recettelist.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.nino.recettelist.R
import com.nino.recettelist.databinding.ActivityRecetteListBinding
import com.nino.recettelist.dataclass.Recipe
import com.nino.recettelist.model.RecipeListAdapter
import com.nino.recettelist.viewmodels.RecetteListViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.android.awaitFrame
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import okhttp3.*


class RecetteListActivity : AppCompatActivity() {
    lateinit var recetteListViewModel: RecetteListViewModel
    var dataRecipe : List<Recipe> = listOf()
    private lateinit var binding: ActivityRecetteListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_recette_list)
        recetteListViewModel = ViewModelProvider(this).get(RecetteListViewModel::class.java)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_recette_list)

        val recyclerViewRecipe = binding.RecyclerViewRecettes
        val recipeAdapter = RecipeListAdapter(dataRecipe)
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerViewRecipe.adapter = recipeAdapter
        recyclerViewRecipe.layoutManager = layoutManager
        recyclerViewRecipe.setHasFixedSize(true)
        recyclerViewRecipe.addItemDecoration(
            DividerItemDecoration(
                this,
                layoutManager.orientation
            )
        )

        GlobalScope.async{
            dataRecipe = recetteListViewModel.search();
            InvokeRefreshBinding()
        }
        val btnRecherche: Button = findViewById(R.id.btnRecherche)
        btnRecherche.setOnClickListener {
            GlobalScope.async {
                dataRecipe = recetteListViewModel.search()
                InvokeRefreshBinding()
            }
        }
    }

    public fun InvokeRefreshBinding(){
        val recyclerViewRecipe = binding.RecyclerViewRecettes
        val adapter = recyclerViewRecipe.adapter
        adapter!!.notifyDataSetChanged()
    }
}