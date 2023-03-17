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
            val nameAut =findViewById<EditText>(R.id.tvActNombeAut)//A RECUPERAR
            val anioAut =findViewById<EditText>(R.id.tvActAnioAut)//A RECUPERAR
            val motorAut =findViewById<EditText>(R.id.tvActMotorAut)//A RECUPERAR

            db.collection(nameConc.text.toString()).document(idAut.text.toString()).get().addOnSuccessListener {
                nameAut.setText(it.get("name")as String?)
                anioAut.setText(it.get("anio")as String?)
                motorAut.setText(it.get("motor")as String?)
            }

        }
    }

    fun initEventActualizarAuto(){
        val botonFirestore= findViewById<Button>(R.id.btnActualizarAuto)
        botonFirestore.setOnClickListener {
            val nameConc =findViewById<EditText>(R.id.tvActConcAut)
            val idAut =findViewById<EditText>(R.id.tvActIdAut)
            val nameAut =findViewById<EditText>(R.id.tvActNombeAut)//A RECUPERAR
            val anioAut =findViewById<EditText>(R.id.tvActAnioAut)//A RECUPERAR
            val motorAut =findViewById<EditText>(R.id.tvActMotorAut)//A RECUPERAR

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

    fun initEliminarAuto(){
        val botonFirestore= findViewById<Button>(R.id.btnEliminarAuto)
        botonFirestore.setOnClickListener {
            val nameConc =findViewById<EditText>(R.id.tvActConcAut)
            val idAut =findViewById<EditText>(R.id.tvActIdAut)

            db.collection(nameConc.text.toString()).document(idAut.text.toString()).delete()

        }
    }






}