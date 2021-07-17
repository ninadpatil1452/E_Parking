package com.example.e_parking

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class Signup_page : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        // Initialize Firebase Auth
        auth = Firebase.auth
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)

        val tvLogin = findViewById<TextView>(R.id.tv_login)

        tvLogin.setOnClickListener{
            //Launch the Login screen when user clicks on the text
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}

//    public override fun onStart() {
//        super.onStart()
//        // Check if user is signed in (non-null) and update UI accordingly.
//        val currentUser = auth.currentUser
//        if(currentUser != null){
//            reload();
//        }
//
//    }
