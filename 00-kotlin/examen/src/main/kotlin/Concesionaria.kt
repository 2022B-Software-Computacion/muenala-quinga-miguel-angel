import java.util.*
import java.io.File
import java.io.*
import java.io.FileWriter
import java.io.IOException

class Concesionaria{
    var ruta: String= "C:/Users/escritorio.virtual14/Documents/Miguelgit/muenala-quinga-miguel-angel/00-kotlin/examen/archivo/fichero.txt"

    fun actualizar(item: String,editado: String){
        try {
            var archivo1: File = File(ruta)
            var cadena: FileReader = FileReader(archivo1)
            var br: BufferedReader= BufferedReader(cadena)

            var contenido=br.readLine()// copia del fichero
            var copiaFichero: String =""
            val todo = StringBuilder()
            while((contenido)!=null){
                if(item!=contenido){
                    copiaFichero=copiaFichero+"\n"+contenido
                }else{
                    copiaFichero=copiaFichero+"\n"+editado
                }
                todo.append(contenido+"\n")
                contenido = br.readLine()
            }
            val pw:PrintWriter = PrintWriter(ruta) //elimino contenido del fichero actual
            pw.close();
            escribir(copiaFichero) // reescribo la copia del fichero sin el elemento escogido
        }catch (e: IOException){ //FileNotFoundException: Error para no encuentra
            println("No se ha encontrado el archivo")
        }
    }

    fun crearConcesionaria(){
        var nuevaConcesionaria: String=""
        print("Escribe en nombre de la Concesionaria:\n Concesionaria... ")
        val nombreConcesionaria = readLine()
        nuevaConcesionaria = "Concesionaria " +nombreConcesionaria+":\n" //Agregar Concesionaria

        var num: Int=1                          //Agregar Autos a Concesionaria
        do {
            print("Escribe el nombre del auto: ")
            val nombreauto= readLine()
            print("Ingrese el Año del auto: ")
            val anioAuto = readLine()//Pedir Año
            print("Ingrese la potencia/revoluciones del motor del auto: ")
            val motorAuto = readLine()//Pedir Motor

            nuevaConcesionaria = nuevaConcesionaria + nombreauto +"\tAño:"+anioAuto.toString()+"\tMotor:"+ motorAuto.toString()+"\n"
            print("Quieres ingresar mas autos?\n1: Si\n0: No\n")
            val num1 = readLine()

            if (num1 != null) {
                num = num1.toInt()
                if(num!=1){
                    nuevaConcesionaria = nuevaConcesionaria +"#"
                }
            }
        }while (num!=0)
        escribir(nuevaConcesionaria)
    }

    fun escribir(cadena:String){
        try{
            var archivo2: FileWriter = FileWriter(ruta,true)
            archivo2.write(cadena+"\n")//"\n\n"
            archivo2.close()
        }catch (e: IOException){ //FileNotFoundException: Error para no encuentra
            println("No se ha encontrado el archivo")
        }
    }

    fun leer(){
        try {
            var archivo1: File = File(ruta)
            var cadena: FileReader = FileReader(archivo1)
            var br: BufferedReader= BufferedReader(cadena)

            var contenido = br.readLine()
            val todo = StringBuilder()
            while((contenido)!=null){
                if(contenido.toString()!="#"){
                    println(contenido)
                }
                todo.append(contenido+"\n")
                contenido=br.readLine()
            }
            //println(archivo1.absolutePath)  //imprimir la ruta del archivo mostrado
            //println(archivo1.exists()  // verificar si un archivo existe
        }catch (e: IOException){ //FileNotFoundException: Error para no encuentra
            println("No se ha encontrado el archivo")
        }
    }
}