import java.util.*
import java.io.File
import java.io.*
import java.io.FileWriter
import java.io.IOException

var ferrari: Concesionaria = Concesionaria()
var autos: Auto = Auto()

fun main(){

    var accion: Int = 1
    do {
        println()
        println("Escriba el número de la opción a realizar\n"+
                "1: Agregar auto\n" +
                "2: Actualizar o editar\n" +
                "3: Eliminar auto\n" +
                "4: Crear Concesionaria\n" +
                "5: Imprimir Concesionarias\n" +
                "0: Terminar y cerrar")

        val option= readLine()
        if (option != null) {
            when(option.toInt()){
                1 -> agregarAutosAConcesionaria()
                2 -> editarItems()
                3 -> eliminarAutos()
                4 -> crearNuevaConcesionaria()
                5 -> leerfichero()
                else -> {
                    print(option+"No es una opción")
                }
            }
        }

        println("Quieres volver a hacer otra acción:\n1: Si \n0: No")
        val accion1 = readLine()
        if (accion1 != null) {
            accion = accion1.toInt()
        }

    } while(accion != 0)
}

fun agregarAutosAConcesionaria(){   //1
    print("Ingresar nombre de la Concesionaria: ")
    val nombreConcesionaria = readLine()
    val nombreConcesionariaVar = "Concesionaria " + nombreConcesionaria.toString() + ":"
    autos.aumentarArtos(nombreConcesionariaVar)
}

fun editarItems(){   //2
    print("Ingresar Nombre del Auto a editar: ")
    val nombreAEditar = readLine()
    print("Ingresar el nuevo nombre del Auto: ")
    val nuevoNombre = readLine()
    ferrari.actualizar(nombreAEditar.toString(),nuevoNombre.toString())//Actualizar cualquier item
}

fun eliminarAutos(){   //3
    print("Ingresar el nombre de la Concesionaria: ")
    val nombreConcesionaria= readLine()//Eliminar cualquier auto
    autos.eliminarAuto("Concesionaria "+nombreConcesionaria.toString()+":")
}

fun crearNuevaConcesionaria(){   //4
    ferrari.crearConcesionaria()//Crea una nuve concesionaria con sus autos
}

fun leerfichero(){   //5
    ferrari.leer()// imprime contenido del fichero
}

