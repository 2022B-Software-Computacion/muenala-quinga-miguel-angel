package com.example.concesionaria

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MostrarConcesionarias : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_concesionarias)
        this.setTitle("Mostrar Concesionarias")
    }
}