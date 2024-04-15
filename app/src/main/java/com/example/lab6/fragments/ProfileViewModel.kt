package com.example.lab6.fragments

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

enum class LoginStatus{
    LOGGED_IN,
    SIGN_OUT
}

class ProfileViewModel : ViewModel() {
    fun login(userName: CharSequence) {
        name.value = userName.toString()
        loginStatus.value = LoginStatus.LOGGED_IN

    }

    val name : MutableStateFlow<String> = MutableStateFlow("")
    val loginStatus: MutableStateFlow<LoginStatus> = MutableStateFlow(LoginStatus.SIGN_OUT)


}