package com.nino.recettelist.model

import okhttp3.*
import org.json.JSONArray
import java.io.IOException

class ApiCaller(){
    private val baseRequest :String = "https://api.spoonacular.com/recipes/complexSearch?apiKey=12b7989413044f96b945ee19f5e15dd2&number=30&query="
    private val client = OkHttpClient()
    private var search :String = "";

    private lateinit var queryResult: JSONArray

    fun run():String? {
        val request: Request = Request.Builder().url(baseRequest + search).build()
        try {
            val response: Response = client.newCall(request).execute()
            val responseString = response.body()?.string()
            return responseString;
        }catch (e : Exception){
            return ""
        }
    }
}