package com.example.e_parking

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvRegister = findViewById<TextView>(R.id.tv_register)
        tvRegister.setOnClickListener{
            //Launch the registration screen when user clicks on the text
            val intent = Intent(this,Signup_page::class.java)
            startActivity(intent)
        }
    }


}