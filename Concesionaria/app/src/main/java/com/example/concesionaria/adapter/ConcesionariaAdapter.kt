package com.example.concesionaria.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.concesionaria.R

class ConcesionariaAdapter (private val carrosList: List<DatosConcesionaria>) : RecyclerView.Adapter<ConcesionariaViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConcesionariaViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return ConcesionariaViewHolder(layoutInflater.inflate(R.layout.item_autos,parent,false))
    }

    override fun onBindViewHolder(holder: ConcesionariaViewHolder, position: Int) {
        val item = carrosList[position]
        holder.render(item)
    }

    override fun getItemCount(): Int = carrosList.size
}