package com.nino.recettelist.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.nino.recettelist.R
import com.nino.recettelist.viewmodels.LoginViewModel
import kotlinx.coroutines.*
import org.w3c.dom.Text

class LoginActivity : AppCompatActivity() {

    lateinit var loginViewModel : LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        val btnLogin: Button = findViewById(R.id.btnLogin)
        btnLogin.setOnClickListener {
            GlobalScope.async { loginUser() }
        }
        val btnRegister: Button = findViewById(R.id.btnRegister)
        btnRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
    }


    public suspend fun loginUser() {
        loginViewModel.email = findViewById<EditText>(R.id.editTxtLogin).text.toString()
        loginViewModel.password = findViewById<EditText>(R.id.editTxtPassword).text.toString()

        if(TextUtils.isEmpty(loginViewModel.email) || TextUtils.isEmpty(loginViewModel.password)){
            Toast.makeText(this@LoginActivity, "No fields must be empty.", Toast.LENGTH_SHORT).show()
            return
        }

        withContext(Dispatchers.IO) {
            if (loginViewModel.login()){
                startActivity(Intent(this@LoginActivity, RecetteListActivity::class.java))
            }else{
                Toast.makeText(
                    this@LoginActivity,
                    "false",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


    }
}