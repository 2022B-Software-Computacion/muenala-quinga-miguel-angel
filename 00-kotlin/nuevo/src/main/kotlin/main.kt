import java.util.*

// Main.kt
fun main(){
    println("Hola mundo")
    //Tipos de variables

    //INMUTABLES (NO Re Asignar) =
    val inmutable: String = "Miguel"
    //inmutable = "Miguel"; // No se puede re asignar

    //MUTABLES (Re Asignar) =
    var mutable: String = "Angel"
    mutable = "Miguel"

    //val > var

    //Sintaxis duck typing
    val ejemploVariable = "Ejemplo"
    val edadEjemplo: Int =12
    ejemploVariable.trim()

    //Variables primitivas
    val nombreProfesor: String = "Adran Eguez"
    val sueldo: Double = 1.2
    val estadoCivil: Char = 'S'
    var mayorEdad: Boolean = true
    //Clases JAVA
    val fechaNacimiento: Date = Date()

    //sentencias-bucles
    if (true) {

    }else{}

    // switch no existe
    val estadoCivilWhen = "S"
    when (estadoCivilWhen){
        ("S") ->{
            println("acercarse")
        }
        "C" -> {
            println("alejarse")
        }
        "UN" -> println("hablar")
        else -> println("No reconocido")
    }
    val coqueteo = if(estadoCivilWhen == "S") "SI" else "NO"
}

fun imprimirNombre(nombre: String): Unit {
    println("Nombre: ${nombre}")
}

fun calcularSueldo(
    sueldo: Double, //Requerido
    tasa: Double = 12.00, //Opcional (Defecto)
    bonoEspecial: Double? = null, //Opcioal (Null) -> nullable
): Double{
    //String -> String?
    //Int -> Int?
    //Date -> Date?
    if(bonoEspecial == null){
        return sueldo * (100 / tasa)
    } else {
        return sueldo * (100 / tasa) + bonoEspecial
    }
}