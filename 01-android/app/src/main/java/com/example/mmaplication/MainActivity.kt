package com.example.mmaplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val botonCiloVida = findViewById<Button>(R.id.btn_ciclo_vida)
        botonCiloVida
            .irActividad(ACicloVida::class.java)

        val botonListView = findViewById<Button>(R.id.btn_ir_list_view)
        botonListView
            .setOnClickListener{
                irActividad(BListView::class.java)
            }


    }
    fun irActividad(
        clase: Class<*>
    ){
        val intent = Intent(this, clase)
        starActivity(intent)
    }

}