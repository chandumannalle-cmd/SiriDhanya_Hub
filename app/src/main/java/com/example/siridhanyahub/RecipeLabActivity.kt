package com.example.siridhanyahub

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class RecipeLabActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recipe_lab)

        val recycler = findViewById<RecyclerView>(R.id.recyclerRecipe)
        val searchBar = findViewById<EditText>(R.id.searchBar)

        val list = mutableListOf(
            RecipeModel("Ragi Mudde", "Boil water, add ragi flour...", R.drawable.ragi),
            RecipeModel("Jowar Roti", "Prepare dough and cook...", R.drawable.jowar),
            RecipeModel("Bajra Khichdi", "Cook bajra with dal...", R.drawable.bajra),
            RecipeModel("Navane Upma", "Cook navane with vegetables...", R.drawable.navane)
        )

        val adapter = RecipeAdapter(list)

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        // 🔍 SEARCH WORKING HERE
        searchBar.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                adapter.filter(s.toString())
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
        })
    }
}