package com.example.siridhanyahub

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RecipeDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_detail)

        val image = findViewById<ImageView>(R.id.imgDetail)
        val name = findViewById<TextView>(R.id.txtDetailName)
        val steps = findViewById<TextView>(R.id.txtDetailSteps)

        // Receive data
        val recipeName = intent.getStringExtra("name")
        val recipeSteps = intent.getStringExtra("steps")
        val recipeImage = intent.getIntExtra("image", 0)

        // Set data
        name.text = recipeName
        steps.text = recipeSteps
        image.setImageResource(recipeImage)
    }
}