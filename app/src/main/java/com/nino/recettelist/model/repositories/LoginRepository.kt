package com.nino.recettelist.model.repositories

import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.tasks.await

class LoginRepository {
    private lateinit var auth: FirebaseAuth

    suspend fun loginEmail(email: String, password: String) : Boolean
    {
        auth = Firebase.auth
        val result = auth.signInWithEmailAndPassword(email, password).await()
        return result.user != null;
    }

    suspend fun registerEmail(email: String, password: String) : Boolean{
        auth = Firebase.auth

        val result = auth.createUserWithEmailAndPassword(email, password).await()
        return result.user != null;
    }
}