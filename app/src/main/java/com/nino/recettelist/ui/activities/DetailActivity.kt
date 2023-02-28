package com.nino.recettelist.ui.activities

import android.content.Intent
import android.media.Image
import android.net.Uri
import android.os.Bundle
import android.text.style.UpdateAppearance
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.nino.recettelist.R
import com.nino.recettelist.databinding.ActivityDetailBinding
import com.nino.recettelist.dataclass.Recipe
import com.nino.recettelist.viewmodels.DetailViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async


class DetailActivity : AppCompatActivity() {
    lateinit var detailViewModel : DetailViewModel
    lateinit var recipeADetail : Recipe
    private lateinit var binding: ActivityDetailBinding
    private lateinit var imgRecipe : ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        imgRecipe = findViewById(R.id.imageViewDetailMain)
        detailViewModel = ViewModelProvider(this).get(DetailViewModel::class.java)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail)

        val id : Int = intent.getIntExtra("recipe_id", -1)
        if (id == -1){
            Toast.makeText(this, "this recipe is not available.", Toast.LENGTH_SHORT).show()
            //throw java.lang.Exception
        }
        GlobalScope.async {
            recipeADetail = detailViewModel.getSubjectRecipe(id)
            //Removes HTML tags from the summary
            recipeADetail.summary = recipeADetail.summary.replace(Regex("<[^>]*>"), " ")
            binding.recipe = recipeADetail
            //Could not load image with this func
            Picasso.get().load(recipeADetail.image).into(imgRecipe)
        }


        val btnUrl: Button = findViewById(R.id.btnDetailSourceUrl)
        btnUrl.setOnClickListener {
            goToOriginalUrl()
        }
    }

    private fun goToOriginalUrl(){
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(recipeADetail.sourceUrl))
        startActivity(browserIntent)
    }
}