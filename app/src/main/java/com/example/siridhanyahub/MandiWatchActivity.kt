package com.example.siridhanyahub

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MandiWatchActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mandi_watch)

        // Back button
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        // RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerMandi)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Dummy Mandi Data
        val mandiList = listOf(
            MandiModel("Bajra", "₹30/kg", R.drawable.bajra),
            MandiModel("Jowar", "₹28/kg", R.drawable.jowar),
            MandiModel("Ragi", "₹35/kg", R.drawable.ragi),
            MandiModel("Navane", "₹50/kg", R.drawable.navane)
        )

        // Adapter
        val adapter = MandiAdapter(mandiList)
        recyclerView.adapter = adapter
    }

    // Back button click
    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}