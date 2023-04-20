package com.example.complementariacomponents

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.Toast

class RegitreUser : AppCompatActivity() {
    var etNombre: EditText? = null
    var etApellido: EditText? = null
    var etEdad: EditText? = null
    var etTelefono: EditText? = null
    var etUserA: RadioButton? = null
    var etUserB: RadioButton? = null
    var etUserC: RadioButton? = null
    var etUserD: RadioButton? = null
    var btnComprar: Button? = null
    var btnLimpiar: Button? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regitre_user)
        etNombre =  findViewById(R.id.nameUser)
        etApellido = findViewById(R.id.lastUser)
        etEdad = findViewById(R.id.ageUser)
        etTelefono = findViewById(R.id.phoneUser)
        etUserA = findViewById(R.id.usuarioA)
        etUserB = findViewById(R.id.usuarioB)
        etUserC = findViewById(R.id.usuarioC)
        etUserD = findViewById(R.id.ninguno)
        btnComprar = findViewById(R.id.buttonSigiente)
        btnLimpiar = findViewById(R.id.limpiarRegistro)

        btnComprar?.setOnClickListener {
            capturarDatos()
        }

        btnLimpiar?.setOnClickListener {
            etNombre?.setText("")
            etApellido?.setText("")
            etEdad?.setText("")
            etTelefono?.setText("")
            etUserA?.isChecked = false
            etUserB?.isChecked = false
            etUserC?.isChecked = false
            etUserD?.isChecked = false

        }

    }

    private fun capturarDatos() {
        val nombre = etNombre?.text.toString()
        val apellido = etApellido?.text.toString()
        val edad = etEdad?.text.toString()
        val telefono = etTelefono?.text.toString()
        val usuario = when {
            etUserA?.isChecked == true -> "Usuario A"
            etUserB?.isChecked == true -> "Usuario B"
            etUserC?.isChecked == true -> "Usuario C"
            etUserD?.isChecked == true -> "Ninguno"
            else -> "Jajajajajajajjaaja"
        }

        if (nombre.isEmpty() || apellido.isEmpty() || edad.isEmpty() || telefono.isEmpty() || usuario.isEmpty()) {
            Toast.makeText(this, "Debe llenar todos los campos", Toast.LENGTH_SHORT).show()
        } else {

            var preferences: SharedPreferences =getSharedPreferences("credencialesUsuario", Context.MODE_PRIVATE)
            var editor: SharedPreferences.Editor = preferences.edit()
            editor.putString("nombreUser", nombre)
            editor.putString("apellidoUser", apellido)
            editor.putString("edadUser", edad)
            editor.putString("telefonoUser", telefono)
            editor.putString("usuarioUser", usuario)
            editor.commit()


            var intent = Intent(this, BuyProducto::class.java)
            intent.putExtra("nombreUser", nombre)

            startActivity(intent)
            finish()


        }
    }

}