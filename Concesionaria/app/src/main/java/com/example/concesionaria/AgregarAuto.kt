package com.example.concesionaria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class AgregarAuto : AppCompatActivity() {
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_auto)
        this.setTitle("Agregar Auto")

        initEventAgregarAuto()
    }


    fun initEventAgregarAuto(){
        val botonFirestore= findViewById<Button>(R.id.btnAgregarAutoA)
        botonFirestore.setOnClickListener {
            val nameAut =findViewById<EditText>(R.id.tvNombreAuto)
            val nameConc =findViewById<EditText>(R.id.tvConceAuto)
            val anioAut =findViewById<EditText>(R.id.tvAnio)
            val motorAut =findViewById<EditText>(R.id.tvMotor)
            val idAut =findViewById<EditText>(R.id.txId)

            db.collection(nameConc.text.toString()).document(idAut.text.toString()).set(
                hashMapOf(
                    "Nombre" to nameAut.text.toString(),
                    "Concecionaria" to nameConc.text.toString(),
                    "Anio" to anioAut.text.toString(),
                    "Motor" to motorAut.text.toString()
                )
            )

        }
    }


}