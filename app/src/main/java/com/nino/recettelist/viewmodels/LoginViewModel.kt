package com.nino.recettelist.viewmodels

import androidx.lifecycle.ViewModel
import com.nino.recettelist.model.repositories.LoginRepository

class LoginViewModel: ViewModel() {
    var loginRepository: LoginRepository = LoginRepository();

    public lateinit var email: String
    public lateinit var password: String

    suspend fun login(): Boolean{
        return loginRepository.loginEmail(email,password);
    }
}