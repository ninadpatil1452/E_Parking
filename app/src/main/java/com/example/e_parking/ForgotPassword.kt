package com.example.e_parking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.EditText

class ForgotPassword : AppCompatActivity() {
    private lateinit var text: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)
        viewInitializations()
    }
    fun viewInitializations() {

        text = findViewById(R.id.textView)

        // To show back button in actionbar
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

    }
    fun validInput(): Boolean{
        if (text.text.toString().equals("")) {
            text.setError("Please Enter Email")
            return false
        }
        // checking the proper email format
        if (!isEmailValid(text.text.toString())) {
            text.setError("Please Enter Valid Email")
            return false
        }
        return true
    }
    fun isEmailValid(email: String): Boolean {
        return true
    }

}
