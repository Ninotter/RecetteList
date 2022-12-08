package com.nino.recettelist.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import com.nino.recettelist.R
import com.nino.recettelist.viewmodels.RecetteListViewModel
import okhttp3.*
import org.json.JSONArray
import java.io.IOException


class RecetteListActivity : AppCompatActivity() {
    private val client = OkHttpClient()
    lateinit var recetteListViewModel: RecetteListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recette_list)
        recetteListViewModel = ViewModelProvider(this).get(RecetteListViewModel::class.java)
    }

    fun run(url: String) {
        val request = Request.Builder()
            .url(url)
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) = println(response.body()?.string())
        })
    }

    fun show(data:Array<JSONArray>){
        val recetteList:LinearLayout = findViewById(R.id.LinearLayoutListRecettes)
    }

}