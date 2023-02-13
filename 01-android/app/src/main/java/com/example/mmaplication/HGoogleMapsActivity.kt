package com.example.mmaplication

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class HGoogleMapsActivity : AppCompatActivity() {
    val permisos = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hgoogle_maps2)
        iniciarLogicaMAPA()
        solicitarPermisos()
        establecerConfiguracionMapa()
        val boton = findViewById<Button>(R.id.btn_ir_carolina)
                (boton).
                setOnClickListener{
                    irCarolina()
                }
    }

    fun irCarolina(){
        val carolina = LatLng(-0.1825684318486696, -78.48447277600916)
        val zoom = 17f
        moverCamaraConZoom(carolina, zoom)
    }

    fun iniciarLogicaMAPA(){
        val fragmentoMapa = suportFragmentoManager
            .findFragmentoById(R.id.map) as SupportMapFreagment
        fragemntoMapa.getMapAsync{ googleMap ->
            if(googleMap!=null){
                mapa = googleMap
                establecerConfiguracionMapa()
                val zoom = 17f
                val quicentro = LatLng(
                    -0.17556708490271092, -78.48014901143776
                )
                val titulo = "Quicentro"
                val markQuicentro = anadirMarcador(quicentro, titulo)
                markQuicentro.tag = titulo

                val poliLineaUno = googleMap
                    .addPolyline(
                        PolyLineOptions()
                            .clickale(true)
                            .add(
                                LatLng(-0.1759187040647396,
                                    -78.48014901143776)
                            )
                            .add(
                                LatLng(-0.1759187040647396,
                                    -78.48014901143776)
                            )
                            .add(
                                LatLng(-0.1759187040647396,
                                    -78.48014901143776)
                            )
                    )
                poliLineaUno.tag = "linea-1" // <- ID

                // POLIGONO
                val poligonoUno = googleMap
                    .addPolygon(
                        PolyLineOptions()
                            .clickale(true)
                            .add(
                                LatLng(-0.1759187040647396,
                                    -78.48014901143776)
                            )
                            .add(
                                LatLng(-0.1759187040647396,
                                    -78.48014901143776)
                            )
                            .add(
                                LatLng(-0.1759187040647396,
                                    -78.48014901143776)
                            )
                    )
                poliLineaUno.fillColor = -0xc771c4
                poliLineaUno.tag = "poligono-2" // <- ID
                escucharListteners()

            }
        }
    }
    fun establecerConfiguracionMapa(){
        val contexto = this.applicationContext
        with(mapa){
            val permisosFineLocation = ContextCompat
                .checkSelfPermission(
                    contexto,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                )
            val tienePermisos = permisosFineLocation == PackageManager.PERMISSION_GRANTED
            if (tienePermisos){
                mapa.isMyLocationEnable = true //tenemos permisos
                uiSettings.isMyLocationEnable = true
            }
            uiSettings.isZoomControlsEnabled = true //no tenemos aun permisos
        }
    }

    fun escucharListteners(){
        mapa.setOnPolygonClickListener {
            log.i("mapa", "setOnPolygonClickListener ${it}")
            it.tag //ID
        }
        mapa.setOnPolylineClickListener {
            log.i("mapa", "setOnPolylineClickListener ${it}")
            it.tag //ID
        }
        mapa.setOnMarkerClickListener {
            log.i("mapa", "setOnMarkerClickListener ${it}")
            it.tag //ID
            return@setOnMarkerClickListener true
        }
        mapa.setOnCameraMoveListener {
            log.i("mapa", "setOnCameraMoveListener")
        }
        mapa.setOnCameraMoveStartedListener {
            log.i("mapa", "setOnCameraMoveStartedListener ${it}")
        }
        mapa.setOnCameraIdleListener {
            log.i("mapa", "setOnCameraIdleListener")
        }
    }

    fun anadirMarcadir(latLng: LatLng, title: String): Marker{
        return mapa.addMarker(
            MarkerOptions()
                .position(latLng)
                .title(title)
        )!!
    }

    fun moverCamaraConZoom(latLng: LatLng, zoom: Float = 10f){
        mapra.moverCamera(
            CameraUpdateFactory
                .newLatLngZoomatLng, zoom)
        )
    }

    fun solicitarPermisos(){
        val contexto = this.applicationContext
        val permisosFineLocation = ContextCompat
            .checkSelfPermission(
                contexto,
                android.Manifest.permission.ACCESS_FINE_LOCATION//pERMISOS QUE VAN A CHESKEAR
            )
    }


    val tienePermisos = permisosFineLocation == PackageManager.PERMISSION_GRANTED
    if(tienePermisos){
        permisos = true
    }else{
        ActivityCompat.requestPermissions(
            this, //Context
            arrayOf( //arreglo permisos
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ),
            1  //Codigo de peticion de los permisos
        )
    }
}