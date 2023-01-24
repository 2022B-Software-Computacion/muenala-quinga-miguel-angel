package com.example.mmaplication

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.util.Log
import android.widget.Button

class MainActivity : AppCompatActivity() {

    val contenidoIntentExplicito = registerForActivityResult(ActivityResultContracts.StarActivityForResult()){ result ->
        if(result.resultCode == Activity.RESULT_OK){
            if(result.data != null){
                val data = result.data
                Log.i("intent-epn", "${data?.getStringExtra("nombreModificado")}")
            }
        }
    }


    val contenidoIntentImplicito = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){
        result ->
        if (result.resultCode == RESULT_OK){
            if (result.data!!.data != null){
                val uri: Uri = result.data!!.data!!
                val cursor = contentResolver.query(
                    uri,
                    null,
                    null,
                    null,
                    null,
                    null
                )
                cursor?.moveToFirst()
                val indiceTelefono = cursor?.getColumnIndex(
                    ContactsContract.CommonDataKinds.Phone.NUMBER
                )
                val telefono = cursor?.getString(
                    indiceTelefono!!
                )
                cursor?.close()
                Log.i("intent-epn", "Telefono ${telefono}")
            }
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Base de datos sqlite
        EBaseDeDatos.tablaEntrenador = ESqliteHelperEntrenador(this)

        val botonCiloVida = findViewById<Button>(R.id.btn_ciclo_vida)
        botonCiloVida
            .irActividad(ACicloVida::class.java)

        val botonListView = findViewById<Button>(R.id.btn_ir_list_view)
        botonListView
            .setOnClickListener{
                irActividad(BListView::class.java)
            }

        val botonIntentImplicito = findViewById<Button>(R.id.btn_ir_intent_implicito)
        botonIntentImplicito
            .setOnClickListener{
                val intetnConRespuesta = Intent(
                    Intent.ACTION_PICK,
                    ContactsContract.CommonDataKinds.Phone.CONTENT_URI
                )
                contenidoIntentImplicito.launch(intetnConRespuesta)
            }

        val botonIntent = findViewById<R.btn_intent>
        botonIntent
            .setOnClickListener {
                abrirActividadConParametros(CIntentExplicitoParametros::class.java)
            }
        val botonSqlite = findViewById<Button>(R.id.btn_sqlite)
        botonSqlite
            .setOnClickListener{
                irActividad(ECrudEntrenador::class.java)
            }

    }
    fun abrirActividadConParametros(
        clase: Class<*>
    ){
        val intentExplicito = Intent(this, clase)
        //Enviar parametros (solamente variables primitivas)
        intentExplicito.putExtra("nombre", "Adrian")
        intentExplicito.putExtra("apellido", "Eguez")
        intentExplicito.putExtra("edad", 33)
        intentExplicito.putExtra(
            "EntrenadorPrinciapl",
            BEntrenador(1, "Adrian", "Paleta")
        )
        contenidoIntentExplicito.launch(intentExplicito)
    }


    fun irActividad(
        clase: Class<*>
    ){
        val intent = Intent(this, clase)
        starActivity(intent)
    }

}