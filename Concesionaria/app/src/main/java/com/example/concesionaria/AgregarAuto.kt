package com.example.concesionaria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.ktx.firestore
import java.util.*
import com.google.firebase.ktx.Firebase

class AgregarAuto : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_auto)
        this.setTitle("Agregar auto")

        initEventAgregarAuto()
    }


    private fun initEventAgregarAuto(){
        val db = Firebase.firestore
        val botonFirestore= findViewById<Button>(R.id.btnAgregarAutoA)
        botonFirestore.setOnClickListener {
            val nameAut =findViewById<EditText>(R.id.tvNombreAuto)
            val nameConc =findViewById<EditText>(R.id.tvConceAuto)
            val anioAut =findViewById<EditText>(R.id.tvAnio)
            val motorAut =findViewById<EditText>(R.id.tvMotor)
            val idAut =findViewById<EditText>(R.id.txId)

            db.collection(nameConc.text.toString()).document(idAut.text.toString()).set(
                hashMapOf(
                    "name" to nameAut.text.toString(),
                    "concecionaria" to nameConc.text.toString(),
                    "anio" to anioAut.text.toString(),
                    "motor" to motorAut.text.toString()
                )
            )

        }
    }
    /*

    */

}