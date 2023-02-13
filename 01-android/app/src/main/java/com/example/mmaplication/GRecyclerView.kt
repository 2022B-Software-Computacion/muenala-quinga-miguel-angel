package com.example.mmaplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import java.util.ArrayList

class GRecyclerView : AppCompatActivity() {
    var totalLikes = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grecycler_view)
        //Definir lista
        val listaEntrenador = arrayListOf<BEntrenador>()
        listaEntrenador
            .add(BEntrenador(1,"Adrian","Eguez"))
        listaEntrenador
            .add(BEntrenador(2,"Vicente","Sarzosa"))
        //Inicializar Recycler View
        val recyclerView = findViewById<RecyclerView>(R.id.rv_entrenador)
        inicializarRecyclerView(listaEntrenador,recyclerView)
    }

    fun inicializarRecyclerView(
        lista:ArrayList<BEntrenador>,
        recyclerView: GRecyclerView
    ){
        val adaptor = FRecyclerViewAdaptadorNombreCedula(
            this, //Context
             lista, //arreglo datos
             recyclerView
        )
        recyclerView.adapter = adaptor
        recyclerView.iemAnimator = androidx.recyclerview.widget.DefaultItemAnimator()
    }

}