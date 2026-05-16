package com.example.siridhanyahub

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecipeAdapter(private var list: MutableList<RecipeModel>) :
    RecyclerView.Adapter<RecipeAdapter.ViewHolder>() {

    private var fullList: MutableList<RecipeModel> = ArrayList(list)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val image = itemView.findViewById<ImageView>(R.id.imgRecipe)
        val name = itemView.findViewById<TextView>(R.id.txtRecipeName)
        val steps = itemView.findViewById<TextView>(R.id.txtSteps)
        val button = itemView.findViewById<Button>(R.id.btnView)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_recipe, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]

        holder.name.text = item.name
        holder.steps.text = item.steps
        holder.image.setImageResource(item.image)

        // 🔥 OPEN DETAIL SCREEN
        holder.button.setOnClickListener {
            val context = holder.itemView.context

            val intent = Intent(context, RecipeDetailActivity::class.java)
            intent.putExtra("name", item.name)
            intent.putExtra("steps", item.steps)
            intent.putExtra("image", item.image)

            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = list.size

    // 🔍 FILTER FUNCTION
    fun filter(text: String) {
        val query = text.lowercase().trim()

        list.clear()

        if (query.isEmpty()) {
            list.addAll(fullList)
        } else {
            for (item in fullList) {
                if (item.name.lowercase().contains(query)) {
                    list.add(item)
                }
            }
        }

        notifyDataSetChanged()
    }
}