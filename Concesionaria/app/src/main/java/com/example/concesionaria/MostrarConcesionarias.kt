package com.example.concesionaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.concesionaria.adapter.ConcesionariaAdapter
import com.example.concesionaria.adapter.DatosConcesionaria
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.firestore.ktx.toObject
import com.google.firebase.ktx.Firebase

class MostrarConcesionarias : AppCompatActivity() {
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_concesionarias)
        this.setTitle("Mostrar Autos por Concesionarias")

        ObtenerAutos()
    }


    fun ObtenerAutos(){
        val botonFirestore= findViewById<Button>(R.id.btnBuscarAutos)
        botonFirestore.setOnClickListener{
            val nameConc =findViewById<EditText>(R.id.tvMostConcecionaria)
            val listaAutos = mutableListOf<DatosConcesionaria>()//Lista de documentos de la base de datos
            db.collection(nameConc.text.toString())
                .get()
                .addOnSuccessListener { result ->
                    for (document in result) {
                        val auto :DatosConcesionaria = document.toObject(DatosConcesionaria::class.java)
                        listaAutos.add(auto)
                    }
                    Log.d( "Datos de Autos: ", "$listaAutos")
                }
            // recyclerView RecyclerView de autos
            val recyclerView = findViewById<RecyclerView>(R.id.recyclerViewAutos)
            recyclerView.layoutManager = LinearLayoutManager(this)//this
            recyclerView.adapter = ConcesionariaAdapter(listaAutos)
            recyclerView.setHasFixedSize(true)

        }

    }
}