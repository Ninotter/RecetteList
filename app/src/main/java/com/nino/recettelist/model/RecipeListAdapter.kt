package com.nino.recettelist.model

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.nino.recettelist.R
import com.nino.recettelist.databinding.RecipeBinding
import com.nino.recettelist.dataclass.Recipe
import com.squareup.picasso.Picasso

class RecipeListAdapter(private val recipeList: List<Recipe>, navDetail: (input: Recipe) -> Unit) : RecyclerView.Adapter<RecipeListAdapter.ViewHolder>()  {

    private lateinit var binding: RecipeBinding
    private var listRecipe : List<Recipe> = recipeList
    private var navigateToDetail: (input: Recipe) -> Unit = navDetail

    public fun updateList(recipes :List<Recipe>){
        listRecipe = recipes
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = RecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return listRecipe.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = listRecipe[position]
        holder.bind(recipe)
        //loads image from URL, gets resized, and placed into ImageView
        Picasso.get().load(recipe.image).resize(200,200).into(holder.imgRecipe)
        holder.btnDetail.setOnClickListener({
            navigateToDetail(recipe)
        })
    }



    class ViewHolder(private val binding: RecipeBinding) : RecyclerView.ViewHolder(binding.root) {
        lateinit var imgRecipe: ImageView
        lateinit var btnDetail : Button
        fun bind(recipe: Recipe) {
            binding.recipe = recipe
            imgRecipe = binding.root.findViewById<View>(R.id.imageRecipeList) as ImageView
            btnDetail = binding.root.findViewById<View>(R.id.btnRecipeListDetail) as Button
        }
    }
}