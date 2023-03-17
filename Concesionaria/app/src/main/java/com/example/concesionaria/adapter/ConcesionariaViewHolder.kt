package com.example.concesionaria.adapter

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.concesionaria.R

class ConcesionariaViewHolder (view: View): RecyclerView.ViewHolder(view){

    val nombreA = view.findViewById<TextView>(R.id.itemNombre)
    val concecionariaA = view.findViewById<TextView>(R.id.itemConcesionaria)
    val anioA = view.findViewById<TextView>(R.id.itemAnio)
    val motorA = view.findViewById<TextView>(R.id.itemMotor)

    fun render(concecionariaModel: DatosConcesionaria) {
        nombreA.text = concecionariaModel.name
        concecionariaA.text = concecionariaModel.concecionaria
        anioA.text = concecionariaModel.anio
        motorA.text = concecionariaModel.motor
    }
}