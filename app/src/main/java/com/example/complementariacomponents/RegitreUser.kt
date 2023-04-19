package com.example.complementariacomponents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton

class RegitreUser : AppCompatActivity() {
    val etNombre: EditText = findViewById(R.id.nameUser)
    val etApellido: EditText = findViewById(R.id.lastUser)
    val etEdad: EditText = findViewById(R.id.ageUser)
    val etTelefono: EditText = findViewById(R.id.phoneUser)
    val etUserA: RadioButton = findViewById(R.id.usuarioA)
    val etUserB: RadioButton = findViewById(R.id.usuarioB)
    val etUserC: RadioButton = findViewById(R.id.usuarioC)
    val btnComprar: Button = findViewById(R.id.buttonSigiente)
    val btnLimpiar: Button = findViewById(R.id.limpiarRegistro)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regitre_user)

        btnComprar.setOnClickListener {
            capturarDatos();
        }

        btnLimpiar.setOnClickListener {
            etNombre.setText("")
            etApellido.setText("")
            etEdad.setText("")
            etTelefono.setText("")
            etUserA.isChecked = false
            etUserB.isChecked = false
            etUserC.isChecked = false
        }

    }

    private fun capturarDatos() {
        var nombre = etNombre.text.toString()
        var apellido = etApellido.text.toString()
        var edad = etEdad.text.toString()
        var telefono = etTelefono.text.toString()
        var usuario = ""
        if (etUserA.isChecked) {
            usuario = "A"
        } else if (etUserB.isChecked) {
            usuario = "B"
        } else if (etUserC.isChecked) {
            usuario = "C"
        }

        val intent = Intent(this, BuyProducto::class.java)
        var bundle = Bundle()
        bundle.putString("nombre", nombre)
        bundle.putString("apellido", apellido)
        bundle.putString("edad", edad)
        bundle.putString("telefono", telefono)
        bundle.putString("usuario", usuario)
        intent.putExtras(bundle)

        startActivity(intent)
    }




}