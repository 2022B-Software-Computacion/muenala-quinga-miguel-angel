package com.example.debernetflix.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.debernetflix.SuperHero
import com.example.debernetflix.R

class SuperHeroViewHolder(view: View):RecyclerView.ViewHolder(view){

    val seperHero = view.findViewById<TextView>(R.id.tvSuperHeroName)
    val photo: ImageView = view.findViewById<ImageView>(R.id.ivSuperHero)

    fun render(superHeroModel: SuperHero) {
        seperHero.text = superHeroModel.superhero
        Glide.with(photo.context).load(superHeroModel.photo).into(photo)
    }
}