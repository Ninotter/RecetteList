package com.nino.recettelist.model

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nino.recettelist.R
import com.nino.recettelist.databinding.RecipeBinding
import com.nino.recettelist.databinding.RecipeBindingImpl
import com.nino.recettelist.dataclass.Recipe
import com.nino.recettelist.viewmodels.RecetteListViewModel
import com.squareup.picasso.Picasso

class RecipeListAdapter(private val recipeList: List<Recipe>) : RecyclerView.Adapter<RecipeListAdapter.ViewHolder>()  {

    private lateinit var binding: RecipeBinding
    private var listRecipe : List<Recipe> = recipeList

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
        Picasso.get().load(recipe.image).resize(200,200).into(holder.imgRecipe)
    }



    class ViewHolder(private val binding: RecipeBinding) : RecyclerView.ViewHolder(binding.root) {
        lateinit var imgRecipe: ImageView
        fun bind(recipe: Recipe) {
            binding.recipe = recipe
            imgRecipe = binding.root.findViewById<View>(R.id.imageRecipeList) as ImageView
        }
    }
}