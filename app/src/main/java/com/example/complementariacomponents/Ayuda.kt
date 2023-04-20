package com.example.complementariacomponents

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Ayuda : AppCompatActivity() {

    var volver: Button? = null

        @SuppressLint("MissingInflatedId")
        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ayuda)

            volver = findViewById(R.id.volver)

        volver?.setOnClickListener {
            finish()
        }

    }
}