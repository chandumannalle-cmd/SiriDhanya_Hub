package com.example.siridhanyahub

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class HomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_home)

        val btnMandi = findViewById<Button>(R.id.btnMandi)
        val btnRecipe = findViewById<Button>(R.id.btnRecipe)
        val btnHealth = findViewById<Button>(R.id.btnHealth)
        val btnBuy = findViewById<Button>(R.id.btnBuy)

        btnMandi.setOnClickListener {
            startActivity(Intent(this, MandiWatchActivity::class.java))
        }

        btnRecipe.setOnClickListener {
            startActivity(Intent(this, RecipeLabActivity::class.java))
        }

        btnHealth.setOnClickListener {
            startActivity(Intent(this, HealthBenefitsActivity::class.java))
        }

        btnBuy.setOnClickListener {
            startActivity(Intent(this, DirectBuyActivity::class.java))
        }
    }
}