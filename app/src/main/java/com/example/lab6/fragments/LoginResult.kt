package com.example.lab6.fragments

/**
 * Authentication result : success (user details) or error message.
 */
data class LoginResult (
    val success: LoggedInUserView? = null,
    val error:Int? = null
)