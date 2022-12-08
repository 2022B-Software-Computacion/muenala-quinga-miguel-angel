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

    //arreglo estatico
    val arregloEstatico: Array<Int> = arrayOf<Int>(1,2,3)
    println(arregloEstatico)

    //arreglo dinámico
    val arregloDinamico: ArrayList<Int> = arrayListOf<Int>(1,2,3,4,5,6,7,8,9,10)
    println(arregloDinamico)
    arregloDinamico.add(11)
    arregloDinamico.add(12)
    println(arregloDinamico)
    //OPERADORES -> sIRVEN PARA LOS ARREGLOS ESTÁTICOS Y DINÁMICOS

    //For each -> Unit
    //Iterar un arreglo
    val respuestaForEach: Unit = arregloDinamico
        .forEach {
            valorActual: Int ->
            println("Valor actual: ${valorActual}")
        }
    arregloEstatico
        .forEachIndexed {indice: Int, valorActual: Int ->
            print("Valor ${valorActual} Indice: ${indice}")
        }
    println(respuestaForEach)

    //Operador MAP: transforma arreglos
    //MAP -> Muta el arreglo(Cambia el arreglo)
    //1) Enviemos el nuevo valor de la iteración
    //2) Nos devuelve es un NUEVO ARREGLO con los valores modificados

    val respuestaMap: List<Double> = arregloDinamico
        .map { valorActual: Int ->
            return@map valorActual.toDouble() + 100.00
        }
    println(respuestaMap)
     val resouestaMapDos = arregloDinamico.map {it + 15}
         //.map { valorActual: Int ->
         //   return@map valorActual + 15
         //}
    println(resouestaMapDos)
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

abstract class NumerosJava{
    protected val numeroUno: Int
    private val numeroDos: Int

    constructor(
        uno:Int,
        dos: Int
    ){ // Bloque codigo contructor
        this.numeroUno = uno
        this.numeroDos = dos
        println("Inicializacion")
    }
}

abstract class Numeros(//constructor primario
    //uno: Int, //parametro
//public var uno: Int,//propiedad de la clase publica
    protected val numeroUno: Int,
    protected val numeroDos: Int
){
    init{//bloque de codigo del constructor primario
      //  this.numeroUno = uno
        this.numeroUno
        numeroUno
        this.numeroDos
        numeroDos
        println("Inicializacion")
    }
}

class Suma( //Constructor primario
    uno: Int, //parametro
    dos: Int//parametro
): Numeros(uno,dos){
    init{ //Bloque constructor primario
        this.numeroUno
        this.numeroDos
    }
    constructor(// Segundo constructor
        uno: Int?, //parametro
        dos: Int//parametro
    ):this(
        if(uno == null) 0 else uno,
        dos
    ){}
    constructor(// tercer constructor
        uno: Int, //parametro
        dos: Int?//parametro
    ):this(
        uno,
        if(dos == null) 0 else uno

    ){}
    constructor(// Cuarto constructor
        uno: Int?, //parametro
        dos: Int?//parametro
    ):this(
        if(uno == null) 0 else uno,
        if(dos == null) 0 else uno
    ){}
    public fun sumar(): Int {
        return numeroUno + numeroDos
    }
}


