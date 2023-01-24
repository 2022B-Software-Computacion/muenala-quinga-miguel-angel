import java.util.*
import java.io.File
import java.io.*
import java.io.FileWriter
import java.io.IOException

class Auto {
    var ruta: String= "C:/Users/escritorio.virtual14/Documents/Miguelgit/muenala-quinga-miguel-angel/00-kotlin/examen/archivo/fichero.txt"
    var concesionaria: Concesionaria=Concesionaria()

    fun aumentarArtos(nombreConc: String){
        try {
            var archivo1: File = File(ruta)
            var cadena: FileReader = FileReader(archivo1)
            var br: BufferedReader= BufferedReader(cadena)

            //
            print("Ingrese el nombre del auto: ")
            val nombreAauto = readLine()//Pedir Año
            print("Ingrese el Año del auto: ")
            val anioAuto = readLine()//Pedir Año
            print("Ingrese la potencia/revoluciones del motor del auto: ")
            val motorAuto = readLine()//Pedir Motor

            var contenido=br.readLine()// copia del fichero
            var copiaFichero: String =""
            val todo = StringBuilder()
            while((contenido)!=null){
                if(nombreConc==contenido){
                    copiaFichero=copiaFichero+"\n"+contenido+"\n"+nombreAauto +"\tAño:"+anioAuto.toString()+"\tMotor:"+ motorAuto.toString()
                }else{
                    copiaFichero=copiaFichero+"\n"+contenido
                }
                todo.append(contenido+"\n")
                contenido = br.readLine()
            }//
            val pw:PrintWriter = PrintWriter(ruta) //elimino contenido del fichero actual
            pw.close();
            concesionaria.escribir(copiaFichero) // reescribo la copia del fichero sin el elemento escogido
        }catch (e: IOException){ //FileNotFoundException: Error para no encuentra
            println("No se ha encontrado el archivo")
        }
    }

    fun eliminarAuto(item: String){ //Eliminar un auto dado el nombre del parámetro
        try {
            var archivo1: File = File(ruta)
            var cadena: FileReader = FileReader(archivo1)
            var br: BufferedReader= BufferedReader(cadena)

            var contenido=br.readLine()// copia del fichero
            val todo = StringBuilder()

            while((contenido)!=null){
                if(contenido.toString()==item) {
                    while((contenido)!="#"){
                        println(contenido)
                        todo.append(contenido + "\n")
                        contenido = br.readLine()
                    }
                }
                todo.append(contenido + "\n")
                contenido = br.readLine()
            }
            var archivo11: File = File(ruta)
            var cadena1: FileReader = FileReader(archivo11)
            var br1: BufferedReader= BufferedReader(cadena1)

            print("Escribe el nombre del auto que quiere eliminar: ")
            val eliminarAuto= readLine()
            var contenido1=br1.readLine()// copia del fichero
            var copiaFichero: String =""
            val todo1 = StringBuilder()
            while(contenido1!=null){
                val chars: Array<Char> = contenido1.toCharArray().toTypedArray()
                val eliminString: Array<Char> = eliminarAuto.toString().toCharArray().toTypedArray()
                val n: Int = eliminString.size
                if(chars.size>eliminString.size && eliminString[n-1]==chars[n-1]){

                }else{
                    copiaFichero=copiaFichero+"\n"+contenido1
                }
                todo1.append(contenido1+"\n")
                contenido1 = br1.readLine()
                /*if(eliminarAuto!=contenido1){
                    copiaFichero=copiaFichero+"\n"+contenido1
                }
                todo1.append(contenido1+"\n")
                contenido1 = br1.readLine()*/
            }
            val pw:PrintWriter = PrintWriter(ruta) //elimino contenido del fichero actual
            pw.close();
            concesionaria.escribir(copiaFichero) // reescribo la copia del fichero sin el elemento escogido
        }catch (e: IOException){ //FileNotFoundException: Error para no encuentra
            println("No se ha encontrado el archivo")
        }
    }
    /*fun eliminarAuto(item: String){ //Eliminar un auto dado el nombre del parámetro
        try {
            var archivo1: File = File(ruta)
            var cadena: FileReader = FileReader(archivo1)
            var br: BufferedReader= BufferedReader(cadena)

            var contenido=br.readLine()// copia del fichero
            var copiaFichero: String =""
            val todo = StringBuilder()
            while(contenido!=null){
                if(item!=contenido){
                    copiaFichero=copiaFichero+"\n"+contenido
                }
                todo.append(contenido+"\n")
                contenido = br.readLine()
            }
            val pw:PrintWriter = PrintWriter(ruta) //elimino contenido del fichero actual
            pw.close();
            concesionaria.escribir(copiaFichero) // reescribo la copia del fichero sin el elemento escogido
        }catch (e: IOException){ //FileNotFoundException: Error para no encuentra
            println("No se ha encontrado el archivo")
        }
    }*/
}