package com.example.e_parking

import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class ForgotPassword : AppCompatActivity() {
    private lateinit var text: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
//        viewInitializations()
//        val tvLogin = findViewById<TextView>(R.id.tv_login)
//
//        tvLogin.setOnClickListener{
//            //Launch the Login screen when user clicks on the text
//            val intent = Intent(this,MainActivity::class.java)
//            startActivity(intent)
//        }
    }
//    fun viewInitializations() {
//
//        text = findViewById(R.id.textView)
//
//        // To show back button in actionbar
//        supportActionBar?.setDisplayHomeAsUpEnabled(true)
//
//    }
//    fun validInput(): Boolean{
//        if (text.text.toString().equals("")) {
//            text.setError("Please Enter Email")
//            return false
//        }
//        // checking the proper email format
//        if (!isEmailValid(text.text.toString())) {
//            text.setError("Please Enter Valid Email")
//            return false
//        }
//        return true
//    }
//    fun isEmailValid(email: String): Boolean {
//        return true
//    }

}
