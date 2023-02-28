package com.nino.recettelist.model

import com.google.android.gms.common.api.internal.ApiKey
import com.google.gson.Gson
import com.nino.recettelist.dataclass.Recipe
import com.nino.recettelist.dataclass.SearchResult
import okhttp3.*

class ApiCaller(){
    private val baseRequest :String = "https://api.spoonacular.com/recipes/"
    private val client = OkHttpClient()
    private val apiKey : String = "apiKey=12b7989413044f96b945ee19f5e15dd2"
    public var search :String = "";

    fun searchByString(): List<Recipe> {
        //TODO Error handling
        val request: Request = Request.Builder().url(baseRequest + "complexSearch?"+ apiKey + "&number=30&query=" + search).build()
        val response: Response = client.newCall(request).execute()
        val responseString = response.body()?.string()
        if (responseString == null) {
            return emptyList()
        }

        var gson = Gson()
        var result = gson.fromJson(responseString, SearchResult::class.java)

        return result.results;
    }

    fun findById(id: Int): Recipe{
        val request: Request = Request.Builder().url(baseRequest + id.toString() + "/information?" + apiKey + "&includeNutrition=false").build()
        val response: Response = client.newCall(request).execute()
        val responseString = response.body()?.string()

        var gson = Gson()
        var result = gson.fromJson(responseString, Recipe::class.java)

        //var extendedIngredients = gson.fromJson(responseString, ArrayList::class.java)
        //result.ingredients = extendedIngredients

        return result;
    }
}