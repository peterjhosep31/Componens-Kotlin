package com.example.complementariacomponents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnComprar: Button = findViewById(R.id.comprar)
        val btnMostar: Button = findViewById(R.id.mostrarData)
        val btnAyuda: Button = findViewById(R.id.ayuda)

        btnComprar.setOnClickListener {
            var intent = Intent(this, RegitreUser::class.java)
            startActivity(intent)
        }

        btnMostar.setOnClickListener {
            var intent = Intent(this, dataUser::class.java)
            startActivity(intent)
        }

        btnAyuda.setOnClickListener {
            var intent = Intent(this, Ayuda::class.java)
            startActivity(intent)
        }

    }
}