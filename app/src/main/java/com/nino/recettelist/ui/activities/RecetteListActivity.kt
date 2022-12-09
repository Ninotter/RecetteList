package com.nino.recettelist.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.nino.recettelist.R
import com.nino.recettelist.databinding.ActivityRecetteListBinding
import com.nino.recettelist.dataclass.Recipe
import com.nino.recettelist.viewmodels.RecetteListViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import okhttp3.*
import org.json.JSONArray
import java.io.IOException


class RecetteListActivity : AppCompatActivity() {
    lateinit var recetteListViewModel: RecetteListViewModel
    lateinit var dataRecipe : List<Recipe>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recette_list)
        recetteListViewModel = ViewModelProvider(this).get(RecetteListViewModel::class.java)
        val btnRecherche: Button = findViewById(R.id.btnRecherche)

        btnRecherche.setOnClickListener {
            GlobalScope.async {
                recetteListViewModel.search()
            }
        }
        val binding: ActivityRecetteListBinding = DataBindingUtil.setContentView(this, R.layout.activity_recette_list);
        binding.viewModel = recetteListViewModel
        binding.lifecycleOwner = this;
        GlobalScope.async{
            recetteListViewModel.search();
        }
    }
}