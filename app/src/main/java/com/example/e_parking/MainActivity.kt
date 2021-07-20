package com.example.e_parking

import android.content.ContentValues
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tvRegister = findViewById<TextView>(R.id.tv_register)
        val tvForgotPassword = findViewById<TextView>(R.id.tv_Forgot)
        val etEmail = findViewById<EditText>(R.id.email_text)
        val etPassword = findViewById<EditText>(R.id.password_text)
        val bSignIn = findViewById<Button>(R.id.sign_in_button)

        tvRegister.setOnClickListener{
            //Launch the registration screen when user clicks on the text
            val intent = Intent(this,Signup_page::class.java)
            startActivity(intent)
        }
        tvForgotPassword.setOnClickListener {
            val intent = Intent(this,ForgotPassword::class.java)
            startActivity(intent)
        }

        bSignIn.setOnClickListener {

            val email = etEmail.text.toString()
            val password = etPassword.text.toString()
            FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Login is success, update UI with the login user's information
                        Log.d(ContentValues.TAG, "Login Success")

                        val intent = Intent(this,home_page::class.java)
                        startActivity(intent)

//                        updateUI(user)
                    } else {
                        // If login fails, display a message to the user.
                        Log.w(ContentValues.TAG, "Login Fail", task.exception)
                        Toast.makeText(baseContext, "Login Failed!",
                            Toast.LENGTH_SHORT).show()
//                        updateUI(null)
                    }
                }
        }
    }


}