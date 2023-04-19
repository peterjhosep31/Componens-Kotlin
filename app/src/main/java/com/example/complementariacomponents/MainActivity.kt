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

        btnComprar.setOnClickListener {
            var intent = Intent(this, RegitreUser::class.java)
            startActivity(intent)
        }


    }
}