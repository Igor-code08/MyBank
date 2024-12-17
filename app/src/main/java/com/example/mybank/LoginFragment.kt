package com.example.mybank

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_login, container, false)

        val loginEditText = view.findViewById<EditText>(R.id.loginEditText)
        val passwordEditText = view.findViewById<EditText>(R.id.passwordEditText)
        val loginButton = view.findViewById<Button>(R.id.loginButton)

        loginButton.setOnClickListener {
            val login = loginEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Проверяем данные пользователя из SharedPreferences
            val sharedPreferences = requireActivity().getSharedPreferences("MyBankPrefs", 0)
            val savedLogin = sharedPreferences.getString("USER_LOGIN", null)
            val savedPassword = sharedPreferences.getString("USER_PASSWORD", null)

            if (login == savedLogin && password == savedPassword) {
                // Переход на основной экран банка
                findNavController().navigate(R.id.action_login_to_bankMain)
            } else {
                Toast.makeText(requireContext(), "Неверные данные", Toast.LENGTH_SHORT).show()
            }
        }

        return view
    }
}