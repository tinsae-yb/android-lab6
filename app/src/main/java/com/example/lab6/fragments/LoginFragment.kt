package com.example.lab6.fragments

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import android.widget.ProgressBar
import android.widget.Toast
import com.example.lab6.databinding.FragmentLoginBinding

import com.example.lab6.R

class LoginFragment(val onLoggedIn : (CharSequence)->Unit) : Fragment() {



    private lateinit var loginViewModel: LoginViewModel
private var _binding: FragmentLoginBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

      _binding = FragmentLoginBinding.inflate(inflater, container, false)
      return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loginViewModel = ViewModelProvider(this, LoginViewModelFactory())
            .get(LoginViewModel::class.java)

        val usernameEditText = binding.username
        val passwordEditText = binding.password
        val loginButton = binding.login

        loginViewModel.loginFormState.observe(viewLifecycleOwner,
            Observer { loginFormState ->
                if (loginFormState == null) {
                    return@Observer
                }


                loginButton.isEnabled = loginFormState.isDataValid

                if(loginFormState.usernameError == null){
                    usernameEditText.error = ""
                }
                if(loginFormState.passwordError == null){
                    passwordEditText.error = ""
                }

                loginFormState.usernameError?.let {

                    usernameEditText.error = getString(it)
                }
                loginFormState.passwordError?.let {
                    passwordEditText.error = getString(it)
                }
            })

        loginViewModel.loginResult.observe(viewLifecycleOwner,
            Observer { loginResult ->
                loginResult ?: return@Observer

                loginResult.error?.let {
                    showLoginFailed(it)
                }
                loginResult.success?.let {
                    updateUiWithUser(it)
                }
            })

        val afterTextChangedListener = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
                // ignore
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
                loginViewModel.loginDataChanged(
                    usernameEditText.editText?.text.toString(),
                    passwordEditText.editText?.text.toString()
                )
            }

            override fun afterTextChanged(s: Editable) {

                loginViewModel.loginDataChanged(
                    usernameEditText.editText?.text.toString(),
                    passwordEditText.editText?.text.toString()
                )
            }
        }
        usernameEditText.editText?.addTextChangedListener(afterTextChangedListener)
        passwordEditText.editText?.addTextChangedListener(afterTextChangedListener)
        passwordEditText.editText?.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                usernameEditText.editText?.text?.trim()?.let { onLoggedIn(it) }
            }
            false
        }

        loginButton.setOnClickListener {

            usernameEditText.editText?.text?.trim()?.let { it1 -> onLoggedIn(it1) }
        }
    }

    private fun updateUiWithUser(model: LoggedInUserView) {

        onLoggedIn(model.displayName)
    }

    private fun showLoginFailed(@StringRes errorString: Int) {
        val appContext = context?.applicationContext ?: return
        Toast.makeText(appContext, errorString, Toast.LENGTH_LONG).show()
    }

override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}