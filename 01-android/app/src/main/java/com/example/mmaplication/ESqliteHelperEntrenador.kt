package com.example.mmaplication

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class ESqliteHelperEntrenador(
    context: Context?,
) : SQLiteOpenHelper(
    context,
    "moviles", //nombre BDD
    null,
    1
){
    override fun onCreate(db: SQLiteDatabase?) {
        val scriptSQLCrearTableEntrenador =
            """
                CREATE TALBE ENTRENADOR(
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                nombre VARCHAR(50),
                decripcion VARCAHR(50)
            )
            """.trimIdent()
        db?.execSQL(scriptSQLCrearTableEntrenador)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        fun crearEntrenador(
            nombre: String,
            description: String
        ): Boolean{
            val basedatosEscritura = writableDatabase
            val valoresAGuardar = ContentValues()
            valoresAGuardar.put("nombre", nobre)
            valoresAGuardar.put("description", description)
            val resultadoGuardar = basedatosEscritura
                .insert(
                    "ENTRENADOR",
                    null,
                    valoresAGuardar
                )
            basedatosEscritura.close()
            return if(resultadoGuardar.toInt() == -1) false else true
        }
    }

    fun eliminarEntrenadorFormulario(id: Int): Boolean{
        //       val conexionEscritura = this.writableDatabase
        val conexionEscritura = writableDatabase
        //"SELECT * FROM ENTRENADOR WHERE ID = ?"
        //arrayOf(
        //     id.toString()
        //)
        val resultadoEliminacion = conexionEscritura.delete(
            "Entrenador",//NOMBRE tabla
        "id",//Consulta where
            arrayOf(
                id.toString()
            )//Parametros
        )
        conexionEscritura.close()
        return if(resultadoEliminacion.toInt() == -1) false else true
    }

    fun actualizarEntrenadorFormulario(
        nombre: String,
        descripcion: String,
        idActualizar: Int
    ): Boolean {
        val cinexionEscritura = writableDatabase
        val valoresAActualizar = ContentValues()
        valoresAActualizar.put("nombre", nombre)
        valoresAActualizar.put("descripcion", descripcion)
        val resultadoActualizacion = conexionEscritura
            .update(
                "ENTRENADOR",//Nombre tabla
                valoresAActualizar,//valores a actualizar
                "id=?",//clausula wahre
                arrayOf(
                    idActualizar.toString()
                )//parametros claula where
            )
        conexionEscritura.close()
        return if(resultadoActualizacion == -1) false else true
    }

    fun consultarEntrenadorPorId(id: Int): BEntrenador {
        //val baseDatoLectura = this.readableDatabase
        val baseDatosLectura = readableDatabase
        val scriptConsultarUsuario = "SELECT * FROM ENTRENADOR WHERE ID = ?"
        val resultadoConsultaLectura = baseDatoaLectura.rawQuery(
            scriptConsultarUsuario, //Consulta
            arrayOf(
                id.toString()
            )// Parametros consulta
        )
        // Logica busqueda
        val existeUsuario = resultadoConsultaLectura.moveToFirst()
        val usuarioEncontrado = BEntrenador(0,"","")
        val arreglo = arrayListOf<BEntrenador>()
        if(existeUsuario){
            do{
                val id = resultadoConsultaLectura.getInt(0)
                val nombre = resultadoConsultaLectura.getString(1)
                val descripcion =
                    resultadoConsultaLectura.getString(2)
                if(id != null){
                    usuarioEncontrado = BEntrenador(0,"","")
                    usuarioEncontrado.id = id
                    usuarioEncontrado.nombre = nombre
                    usuarioEncontrado.descripcion = descripcion
                    arreglo.add(usuarioEncontrado)
                }
            }while (resultadoConsultaLectura.moveToNext())
        }

        resultadoConsultaLectura.close()
        baseDatosLectura.close()
        return usuarioEncontrado
    }
}