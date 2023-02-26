package com.nino.recettelist.model

import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.nino.recettelist.R
import com.nino.recettelist.databinding.RecipeBinding
import com.nino.recettelist.databinding.RecipeBindingImpl
import com.nino.recettelist.dataclass.Recipe
import com.nino.recettelist.viewmodels.RecetteListViewModel

class RecipeListAdapter(private val recipeList: List<Recipe>) : RecyclerView.Adapter<RecipeListAdapter.ViewHolder>()  {

    private lateinit var binding: RecipeBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = RecipeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return recipeList.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val recipe = recipeList[position]
        holder.bind(recipe)
    }



    class ViewHolder(private val binding: RecipeBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(recipe: Recipe) {
            binding.recipe = recipe
        }
    }
}