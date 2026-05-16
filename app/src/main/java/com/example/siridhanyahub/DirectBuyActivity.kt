package com.example.siridhanyahub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DirectBuyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_direct_buy)

        val recycler = findViewById<RecyclerView>(R.id.recyclerProducts)

        val list = listOf(
            ProductModel("Ragi", "₹40/kg", R.drawable.ragi),
            ProductModel("Jowar", "₹35/kg", R.drawable.jowar),
            ProductModel("Bajra", "₹30/kg", R.drawable.bajra),
            ProductModel("Navane", "₹50/kg", R.drawable.navane)
        )

        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = ProductAdapter(list)
    }
}