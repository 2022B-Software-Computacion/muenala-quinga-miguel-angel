package model


class Book (
    val id: String,
    val nombreAuto: String,
    val nombreConces: String,
    val anioAuto: Int,
    val motor: Float
        ){
    constructor(): this("","","",0,0.0f)
}