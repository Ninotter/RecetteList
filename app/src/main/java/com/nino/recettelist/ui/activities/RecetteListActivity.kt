package com.nino.recettelist.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import com.nino.recettelist.R
import com.nino.recettelist.viewmodels.RecetteListViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import okhttp3.*
import org.json.JSONArray
import java.io.IOException


class RecetteListActivity : AppCompatActivity() {
    lateinit var recetteListViewModel: RecetteListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recette_list)
        val btnRecherche: Button = findViewById(R.id.btnRecherche)

        btnRecherche.setOnClickListener {
            GlobalScope.async { search() }
        }

        recetteListViewModel = ViewModelProvider(this).get(RecetteListViewModel::class.java)

    }

    suspend fun search(){
        recetteListViewModel.search()
    }

    fun show(data:Array<JSONArray>){
        val recetteListContainer :LinearLayout = findViewById(R.id.RecyclerViewRecettes)

    }

}