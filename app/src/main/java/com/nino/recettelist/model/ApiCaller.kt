package com.nino.recettelist.model

import com.google.gson.Gson
import com.nino.recettelist.dataclass.Recipe
import com.nino.recettelist.dataclass.SearchResult
import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class ApiCaller(){
    private val baseRequest :String = "https://api.spoonacular.com/recipes/complexSearch?apiKey=12b7989413044f96b945ee19f5e15dd2&number=30&query="
    private val client = OkHttpClient()
    private var search :String = "";

    fun run(): List<Recipe> {
        //TODO Error handling
        val request: Request = Request.Builder().url(baseRequest + search).build()
        val response: Response = client.newCall(request).execute()
        val responseString = response.body()?.string()
        if (responseString == null) {
            return emptyList()
        }

        var gson = Gson()
        var result = gson.fromJson(responseString, SearchResult::class.java)

        return result.results;
    }
}