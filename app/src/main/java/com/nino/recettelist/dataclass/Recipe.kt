package com.nino.recettelist.dataclass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(val id: Int,
                  val title: String,
                  val image: String,
                  val readyInMinutes: Int,
                  val sourceUrl: String,
                  var ingredients: List<String>,
                  val vegan: Boolean,
                  val vegetarian: Boolean,
                  var summary: String
) : Parcelable {

}