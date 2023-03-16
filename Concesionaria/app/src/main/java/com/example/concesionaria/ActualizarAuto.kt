package com.example.concesionaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class ActualizarAuto : AppCompatActivity() {
    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_actualizar_auto)
        this.setTitle("Actualizar Auto")

        initEventrECUPERARAuto()
        initEventActualizarAuto()
        initEliminarAuto()
    }

    fun initEventrECUPERARAuto(){
        val botonFirestore= findViewById<Button>(R.id.btnRecuperarAuto)
        botonFirestore.setOnClickListener {

            val nameConc =findViewById<EditText>(R.id.tvActConcAut)
            val idAut =findViewById<EditText>(R.id.tvActIdAut)
            val nameAut =findViewById<EditText>(R.id.tvNombreAuto)//A RECUPERAR
            val anioAut =findViewById<EditText>(R.id.tvActAnioAut)//A RECUPERAR
            val motorAut =findViewById<EditText>(R.id.tvActMotorAut)//A RECUPERAR

            db.collection(nameConc.text.toString()).document(idAut.text.toString()).get().addOnSuccessListener {
                nameAut.setText(it.get("Nombre")as String?)
                anioAut.setText(it.get("Anio")as String?)
                motorAut.setText(it.get("Motor")as String?)
            }

        }
    }

    fun initEventActualizarAuto(){
        val botonFirestore= findViewById<Button>(R.id.btnActualizarAuto)
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

    fun initEliminarAuto(){
        val botonFirestore= findViewById<Button>(R.id.btnActualizarAuto)
        botonFirestore.setOnClickListener {
            val nameConc =findViewById<EditText>(R.id.tvConceAuto)
            val idAut =findViewById<EditText>(R.id.txId)

            db.collection(nameConc.text.toString()).document(idAut.text.toString()).delete()

        }
    }






}