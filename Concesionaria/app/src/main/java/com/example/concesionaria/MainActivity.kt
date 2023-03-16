package com.example.concesionaria

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initEventAgregarAuto()
        initEventActualizarAuto()
        initEventMostrar()
    }


    fun initEventAgregarAuto(){// Crear un nuevo auto
        val botonFirestore= findViewById<Button>(R.id.btnAgregarAuto)
        botonFirestore.setOnClickListener {
            val intent = Intent(this,AgregarAuto::class.java)
            startActivity(intent)
        }
    }

    fun initEventActualizarAuto(){// Editar un auto ya existente
        val botonFirestore= findViewById<Button>(R.id.btnActualizarAut)
        botonFirestore.setOnClickListener {
            val intent = Intent(this,ActualizarAuto::class.java)
            startActivity(intent)
        }
    }

    fun initEventMostrar(){// Ver todos los autos
        val botonFirestore= findViewById<Button>(R.id.btnMostrarConce)
        botonFirestore.setOnClickListener {
            val intent = Intent(this,MostrarConcesionarias::class.java)
            startActivity(intent)
        }
    }
}