package com.example.mmaplication

class BBaseDatosMemoria {
    val arregloBEntrenador = arrayListOf<BEntrenador>()
    init{
        arregloBEntrenador
        .add(
            BEntrenador(1, "Adrian", "a@a.com")
        )
        arregloBEntrenador
            .add(
                BEntrenador(2, "Vicente", "b@b.com")
            )
        arregloBEntrenador
            .add(
                BEntrenador(3,"Carolina", "c@c.com")
            )
    }
}