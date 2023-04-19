package com.example.complementariacomponents

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Mensajes : AppCompatActivity() {
    var textView1: TextView? = null
    var textView2: TextView? = null
    var textView3: TextView? = null
    var textView4: TextView? = null
    var textView5: TextView? = null
    var textView6: TextView? = null
    var btnSalir: Button? = null


    var nombreUser: String? = null
    var apellidoUser: String? = null
    var edadUser: String? = null
    var telefonoUser: String? = null
    var usuarioUser: String? = null

    var nombreProduct: String? = null
    var valorUniProduct: String? = null
    var cantidadProduct: String? = null


    var totalPagar: Float? = null
    var descuento: Float? = null
    var mensaje: String? = null
    var cantidadDescuento: Float? = null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mensajes)

        var preferences: SharedPreferences =getSharedPreferences("credenciales", MODE_PRIVATE)

        textView1 = findViewById(R.id.textView2)
        textView2 = findViewById(R.id.textView3)
        textView3 = findViewById(R.id.textView4)
        textView4 = findViewById(R.id.textView5)
        textView5 = findViewById(R.id.textView6)
        textView6 = findViewById(R.id.textView7)
        btnSalir = findViewById(R.id.button)


        var nombrePreference = preferences.getString("nombreUser", "No existe la informacion")
        var apellidoPreference = preferences.getString("apellidoUser", "No existe la informacion")
        var edadPreference = preferences.getString("edadUser", "No existe la informacion")
        var telefonoPreference = preferences.getString("telefonoUser", "No existe la informacion")
        var usuarioPreference = preferences.getString("usuarioUser", "No existe la informacion")

        nombreUser = nombrePreference
        apellidoUser = apellidoPreference
        edadUser = edadPreference
        telefonoUser = telefonoPreference
        usuarioUser = usuarioPreference


        var nombreProductPreference = preferences.getString("nombreProduct", "No existe la informacion")
        var valorUniProductPreference = preferences.getString("valorUniProduct", "No existe la informacion")
        var cantidadProductPreference = preferences.getString("cantidadProduct", "No existe la informacion")

        nombreProduct = nombreProductPreference
        valorUniProduct = valorUniProductPreference
        cantidadProduct = cantidadProductPreference


        if(usuarioUser == "Usuario A"){
            descuento = 0.4f
            totalPagar = (valorUniProduct!!.toFloat() * cantidadProduct!!.toFloat()) - (valorUniProduct!!.toFloat() * cantidadProduct!!.toFloat() * descuento!!)
            cantidadDescuento = (valorUniProduct!!.toFloat() * cantidadProduct!!.toFloat() * descuento!!)
            mensaje =  "Tiene un descuento del 40%"

        }else if(usuarioUser == "Usuario B"){
            descuento = 0.2f
            totalPagar = (valorUniProduct!!.toFloat() * cantidadProduct!!.toFloat()) - (valorUniProduct!!.toFloat() * cantidadProduct!!.toFloat() * descuento!!)
            cantidadDescuento = (valorUniProduct!!.toFloat() * cantidadProduct!!.toFloat() * descuento!!)
            mensaje =  "Tiene un descuento del 20%"

        }else if(usuarioUser == "Usuario C"){
            descuento = 0.1f
            totalPagar = (valorUniProduct!!.toFloat() * cantidadProduct!!.toFloat()) - (valorUniProduct!!.toFloat() * cantidadProduct!!.toFloat() * descuento!!)
            cantidadDescuento = (valorUniProduct!!.toFloat() * cantidadProduct!!.toFloat() * descuento!!)
            mensaje =  "Tiene un descuento del 10%"

        }else if(usuarioUser == "Usuario D"){
            descuento = 0.0f
            totalPagar = (valorUniProduct!!.toFloat() * cantidadProduct!!.toFloat()) - (valorUniProduct!!.toFloat() * cantidadProduct!!.toFloat() * descuento!!)
            mensaje =  "No tiene descuento"

        }

        textView1?.text = "Usuario: $nombreUser  ' ' $apellidoUser"
        textView2?.text = if (usuarioUser == "Usuario D") "No se le realiza descuento" else "Usuario: $usuarioUser"
        textView3?.text = mensaje
        textView4?.text = "Total a pagar: $totalPagar"
        textView5?.text = "Descuento: $cantidadDescuento"
        textView6?.text = "Precio real Compra: ($totalPagar + $descuento)"









        btnSalir?.setOnClickListener {
            finish()

        }

    }
}