package com.example.complementariacomponents

import android.annotation.SuppressLint
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class dataUser : AppCompatActivity() {

    var tvNombre: TextView? = null
    var tvApellido: TextView? = null
    var tvEdad: TextView? = null
    var tvTelefono: TextView? = null
    var tvUsuario: TextView? = null
    var btnBorrar: Button? = null
    var btnSalir: Button? = null

    var nombre: String? = null
    var apellido: String? = null
    var edad: String? = null
    var telefono: String? = null
    var usuario: String? = null


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_user)

        var preferences: SharedPreferences = getSharedPreferences("credencialesUsuario", MODE_PRIVATE)
        var preferencesInfo = preferences.contains("nombreUser")


        tvNombre = findViewById(R.id.textView1)
        tvApellido = findViewById(R.id.textView2)
        tvEdad = findViewById(R.id.textView3)
        tvTelefono = findViewById(R.id.textView4)
        tvUsuario = findViewById(R.id.textView5)

        var nombrePreference = preferences.getString("nombreUser", "No existe la informacion")
        var apellidoPreference = preferences.getString("apellidoUser", "No existe la informacion")
        var edadPreference = preferences.getString("edadUser", "No existe la informacion")
        var telefonoPreference = preferences.getString("telefonoUser", "No existe la informacion")
        var usuarioPreference = preferences.getString("usuarioUser", "No existe la informacion")

        tvNombre?.text = "Nombre: "+nombrePreference
        tvApellido?.text = "Apellido: "+apellidoPreference
        tvEdad?.text = "Edad: "+edadPreference
        tvTelefono?.text = "Telefono: "+telefonoPreference
        tvUsuario?.text = "Tipo de usuario: "+usuarioPreference

        btnBorrar = findViewById(R.id.borrar)
        btnSalir = findViewById(R.id.volver)

        if (preferencesInfo) {
            btnBorrar?.setOnClickListener {
                var editor = preferences.edit()
                editor.clear()
                editor.apply()
                finish()
            }
        } else {
            btnBorrar?.setOnClickListener{
                Toast.makeText(this, "No hay datos para borrar", Toast.LENGTH_SHORT).show()
            }
        }

        btnSalir?.setOnClickListener {
            finish()
        }

    }
}