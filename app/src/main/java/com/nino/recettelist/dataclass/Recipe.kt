package com.nino.recettelist.dataclass

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Recipe(val title: String, val image: String, val imageType: String) : Parcelable {

}