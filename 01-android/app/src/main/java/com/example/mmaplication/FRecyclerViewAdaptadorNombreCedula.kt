package com.example.mmaplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.ViewParent
import android.widget.Button
import android.widget.TextView
import java.util.*
import androidx.recyclerview.widget.RecyclerView
import java.lang.reflect.Type
import java.text.FieldPosition

class FRecyclerViewAdaptadorNombreCedula (
    private val contexto: GRecyclerView,
    private val lista: ArrayList<BEntrenador>,
    private val recyclerView: RecyclerView
    ): RecyclerView.Adapter<FRecyclerViewAdaptadorNombreCedula.MyviewHolder>(){
        inner class  MyViewHolder(view: View): RecyclerView.ViewHolder(view){
            val nombreTextView: TextView
            val cedukaTextView: TextView
            val likesTextView: TextView
            val accionButton: Button
            var numeroLikes = 0
            init {
                nombreTextView = view.findViewById(R.id.tv_nombre)
                cedukaTextView = view.findViewById(R.id.tv_cedula)
                likesTextView = view.findViewById(R.id.tv_likes)
                accionButton = view.findViewById<Button>(R.id.btn_dar_likes)
                accionButton = setOnClickListener{anadirLike()}
            }
            fun anadirLike(){
                numeroLikes = numeroLikes + 1
                likesTextView.text = numeroLikes.toString()
            }
        }

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): MyViewHolder {
        val itemView = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.recycler_view_vista,
                parent,
                false
            )
        return MyViewHolder(itemView)
    }

    //Setear los datos para la iteracion
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val entrenadorActual = this.lista[position]
        holder.nombreTextView.text = entrenadorActual.nombre
        holder.cedukaTextView.text = entrenadorActual.descripcion
        holder.accionButton.text = "Like ${entrenadorActual.nombre}"
        holder.likesTextView.text = "0"
    }

    //tomano del arreglo
    override fun getItemCount(): Int {
    }
}