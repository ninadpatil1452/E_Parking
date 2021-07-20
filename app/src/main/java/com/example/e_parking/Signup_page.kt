package com.example.e_parking

import android.content.ContentValues.TAG
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase

class Signup_page : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup_page)

        // Initialize Firebase Auth
        auth = Firebase.auth

        val tvLogin = findViewById<TextView>(R.id.tv_login)
        val bRegister = findViewById<Button>(R.id.b_register)
        val etEmail = findViewById<TextView>(R.id.et_email)
        val etNumber = findViewById<TextView>(R.id.et_number)
        val etName = findViewById<TextView>(R.id.et_name)
        val etPassword = findViewById<TextView>(R.id.et_password)

        bRegister.setOnClickListener {
            val email = etEmail.text.toString()
            val number = etNumber.text.toString()
            val name = etName.text.toString()
            val password = etPassword.text.toString()

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                etEmail.error = "Please provide a valid Email!"
                etEmail.requestFocus()
                return@setOnClickListener
            }
            if (number.isEmpty()){
                etNumber.error = "Number Required!"
                etNumber.requestFocus()
                return@setOnClickListener
            }
            if(name.isEmpty()){
                etName.error ="Name Required!"
                etName.requestFocus()
                return@setOnClickListener
            }
            if (password.isEmpty()){
                etPassword.error ="password Required!"
                etPassword.requestFocus()
                return@setOnClickListener
            }
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        // Sign in success, update UI with the signed-in user's information
                        Log.d(TAG, "createUserWithEmail:success")
                        val uid = FirebaseAuth.getInstance().uid?: ""
                        val ref = FirebaseDatabase.getInstance().getReference("/user/$uid")
                        val user = User(uid,email,number,name)
                        ref.setValue(user)
                            .addOnSuccessListener {
                                Toast.makeText(baseContext,"data saved!",Toast.LENGTH_SHORT).show()
                            }
//                        updateUI(user)
                            val intent = Intent(this,home_page::class.java)
                            startActivity(intent)
                    } else {
                        // If sign in fails, display a message to the user.
                        Log.w(TAG, "createUserWithEmail:failure", task.exception)
                        Toast.makeText(baseContext, "Authentication failed.",
                            Toast.LENGTH_SHORT).show()
//                        updateUI(null)
                    }
                }
        }
        tvLogin.setOnClickListener{
            //Launch the Login screen when user clicks on the text
            val intent = Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}




