package com.example.debernetflix

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.debernetflix.adapter.SuperHeroAdapter

public class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initRecyclerView()
    }

    private fun initRecyclerView(){
        // recyclerView RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerNetflix)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)//this
        recyclerView.adapter = SuperHeroAdapter(NetflixProvider.superheroList)
        recyclerView.setHasFixedSize(true)

        // offer RecyclerView
        val offerRecyclerView = findViewById<RecyclerView>(R.id.offerRecyclerview)
        offerRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)//this
        offerRecyclerView.adapter = SuperHeroAdapter(NetflixProvider.peliculasList)
        offerRecyclerView.setHasFixedSize(true)

        // clothing RecyclerView
        val clothingRecyclerView = findViewById<RecyclerView>(R.id.clothingRecyclerView)
        clothingRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)//this
        clothingRecyclerView.adapter = SuperHeroAdapter(NetflixProvider.seriesList)
        clothingRecyclerView.setHasFixedSize(true)

        // bestSeller RecyclerView
        val bestSellerRecyclerView = findViewById<RecyclerView>(R.id.bestSellerRecyclerview)
        bestSellerRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)//this
        bestSellerRecyclerView.adapter = SuperHeroAdapter(NetflixProvider.animeList)
        bestSellerRecyclerView.setHasFixedSize(true)
    }

    // offer RecyclerView
    //val offerRecyclerView = findViewById<RecyclerView>(R.id.offerRecyclerview);
    //offerRecyclerView.layoutManager = LinearLlayaoutManager()

    // offer RecyclerView
    //val clothingRecyclerView = findViewById<RecyclerView>(R.id.offerRecyclerview)

    // offer RecyclerView
    //val bestSellerRecyclerView = findViewById<RecyclerView>(R.id.bestSellerRecyclerview)
}