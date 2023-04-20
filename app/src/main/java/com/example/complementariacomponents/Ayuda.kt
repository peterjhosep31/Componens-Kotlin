package com.example.complementariacomponents

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Ayuda : AppCompatActivity() {

    var btnVolver: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda)

        btnVolver = findViewById(R.id.volver)

        btnVolver?.setOnClickListener {
            finish()
        }

    }
}