package com.nino.recettelist.viewmodels

import androidx.lifecycle.ViewModel
import com.nino.recettelist.model.repositories.LoginRepository

class RegisterViewModel: ViewModel() {
    var loginRepository: LoginRepository = LoginRepository();

    public lateinit var email: String
    public lateinit var password: String

    suspend fun register(): Boolean{
        return loginRepository.registerEmail(email,password);
    }
}