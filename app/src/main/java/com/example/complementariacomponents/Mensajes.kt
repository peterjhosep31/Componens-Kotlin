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
    var precioReal: Float? = null
    var toco: Double? = null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mensajes)

        var preferencesUser: SharedPreferences =
            getSharedPreferences("credencialesUsuario", MODE_PRIVATE)
        var preferencesProduct: SharedPreferences =
            getSharedPreferences("credencialesProduct", MODE_PRIVATE)

        textView1 = findViewById(R.id.textView2)
        textView2 = findViewById(R.id.textView3)
        textView3 = findViewById(R.id.textView4)
        textView4 = findViewById(R.id.textView5)
        textView5 = findViewById(R.id.textView6)
        textView6 = findViewById(R.id.textView7)
        btnSalir = findViewById(R.id.button)


        var nombrePreference = preferencesUser.getString("nombreUser", "No existe la informacion")
        var apellidoPreference =
            preferencesUser.getString("apellidoUser", "No existe la informacion")
        var edadPreference = preferencesUser.getString("edadUser", "No existe la informacion")
        var telefonoPreference =
            preferencesUser.getString("telefonoUser", "No existe la informacion")
        var usuarioPreference = preferencesUser.getString("usuarioUser", "No existe la informacion")

        nombreUser = nombrePreference
        apellidoUser = apellidoPreference
        edadUser = edadPreference
        telefonoUser = telefonoPreference
        usuarioUser = usuarioPreference


        var nombreProductPreference =
            preferencesProduct.getString("nombreProduct", "No existe la informacion")
        var valorUniProductPreference =
            preferencesProduct.getString("valorUniProduct", "No existe la informacion")
        var cantidadProductPreference =
            preferencesProduct.getString("cantidadProduct", "No existe la informacion")

        nombreProduct = nombreProductPreference
        valorUniProduct = valorUniProductPreference
        cantidadProduct = cantidadProductPreference


        if (usuarioUser == "Usuario A") {
            descuento = 0.1F
            mensaje = "Usuario A: 40% de descuento"

        } else if (usuarioUser == "Usuario B") {
            descuento = 0.2F
            mensaje = "Usuario B: 20% de descuento"

        } else if (usuarioUser == "Usuario C") {
            descuento = 0.3F
            mensaje = "Usuario C: 10% de descuento"

        } else {
            descuento = 0F
            mensaje = "No se le realiza descuento"
        }

        totalPagar = (valorUniProduct!!.toFloat() * cantidadProduct!!.toFloat())
        cantidadDescuento = (totalPagar!! * descuento!!)
        precioReal = (totalPagar!! - cantidadDescuento!!)


        textView1?.text = "Usuario: $nombreUser"+ " " + "$apellidoUser"
        textView2?.text = mensaje
        textView3?.text = "Producto: $nombreProduct"
        textView4?.text = "Total a compra: $totalPagar"
        textView5?.text = "Descuento: $cantidadDescuento"
        textView6?.text = "Precio real Compra: ${precioReal}"









        btnSalir?.setOnClickListener {
            finish()

        }

    }
}