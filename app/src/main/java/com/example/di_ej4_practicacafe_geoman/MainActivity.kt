package com.example.di_ej4_practicacafe_geoman

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: AdaptCoffee

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerViewCoffee)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val coffeeList = mutableListOf(
            CoffeeShop("Antico Caffe Greco", "St. Italy, Rome",R.drawable.images),
            CoffeeShop("Coffee Room","St. Germany, Berlin", R.drawable.images1),
            CoffeeShop("Coffee Ibiza", "St. Colon, Madrid",R.drawable.images2),
            CoffeeShop("Pudding Coffee Shop","St. Diagonal, Barcelona", R.drawable.images3),
            CoffeeShop("L'Express", "St. Picadilly Circus, London",R.drawable.images4),
            CoffeeShop("CoffeeCorner", "St. Angel Guimera, Valencia",R.drawable.images5),
            CoffeeShop("Sweet Cup", "St. Kinkerstraat, Amsterdan",R.drawable.images6)

        )

        adapter = AdaptCoffee(coffeeList)
        recyclerView.adapter = adapter
    }
}
