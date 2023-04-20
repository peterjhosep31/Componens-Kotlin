package com.example.complementariacomponents

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class BuyProducto : AppCompatActivity() {
    var btnLimpiar: Button? = null
    var btnComprar: Button? = null
    var etNombre: EditText? = null
    var etValorUni: EditText? = null
    var etCantidad: EditText? = null
    var vtNombre: TextView? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buy_producto)

        var nombreUser = intent.getStringExtra("nombreUser")

        vtNombre = findViewById(R.id.usuario)
        btnLimpiar = findViewById(R.id.button2)
        btnComprar = findViewById(R.id.button)
        etNombre = findViewById(R.id.nameProduct)
        etValorUni = findViewById(R.id.valorUnitario)
        etCantidad = findViewById(R.id.cantidadProduct)

        vtNombre?.text = nombreUser

        btnLimpiar?.setOnClickListener {
            etNombre?.setText("")
            etValorUni?.setText("")
            etCantidad?.setText("")
        }




        btnComprar?.setOnClickListener {
            capturarDatos()
        }

    }

    private fun capturarDatos() {
        var nombre = etNombre?.text.toString()
        var valorUni = etValorUni?.text.toString()
        var cantidad = etCantidad?.text.toString()

        if (nombre.isEmpty() || valorUni.isEmpty() || cantidad.isEmpty()) {
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show()
            return
        }

        var miIntent = Intent(this, Mensajes::class.java)

        var preferences: SharedPreferences = getSharedPreferences("credencialesProduct", Context.MODE_PRIVATE)
        var editor: SharedPreferences.Editor = preferences.edit()
        editor.putString("nombreProduct", nombre)
        editor.putString("valorUniProduct", valorUni)
        editor.putString("cantidadProduct", cantidad)

        editor.commit()


        startActivity(miIntent)
        finish()


    }
}