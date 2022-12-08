package com.nino.recettelist.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.nino.recettelist.R
import com.nino.recettelist.viewmodels.LoginViewModel
import com.nino.recettelist.viewmodels.RegisterViewModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async

class RegisterActivity : AppCompatActivity() {
    lateinit var registerViewModel: RegisterViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
        val btnRegister: Button = findViewById(R.id.btnRegister)
        btnRegister.setOnClickListener {
            GlobalScope.async{registerUser()};
        }
        val btnBack: Button = findViewById(R.id.btnBack)
        btnBack.setOnClickListener {
            finish()
        }
        registerViewModel = ViewModelProvider(this).get(RegisterViewModel::class.java)
    }

    suspend public fun registerUser() {
        val confirmPassword: String = findViewById<EditText>(R.id.editTxtConfirmPassword).text.toString()
        registerViewModel.email = findViewById<EditText>(R.id.editTxtLogin).text.toString()
        registerViewModel.password = findViewById<EditText>(R.id.editTxtPassword).text.toString()

        if (registerViewModel.password != confirmPassword){
            Toast.makeText(this, "Passwords must be identical", Toast.LENGTH_SHORT).show()
            return;
        }
        if (registerViewModel.register()){
            startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
        }
    }
}