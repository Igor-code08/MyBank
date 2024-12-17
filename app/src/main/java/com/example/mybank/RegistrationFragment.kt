package com.example.mybank

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class RegistrationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_registration, container, false)

        val loginEditText = view.findViewById<EditText>(R.id.loginEditText)
        val passwordEditText = view.findViewById<EditText>(R.id.passwordEditText)
        val registerButton = view.findViewById<Button>(R.id.registerButton)

        registerButton.setOnClickListener {
            val login = loginEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Сохраняем данные пользователя (например, в SharedPreferences)
            val sharedPreferences = requireActivity().getSharedPreferences("MyBankPrefs", 0)
            with(sharedPreferences.edit()) {
                putString("USER_LOGIN", login)
                putString("USER_PASSWORD", password)
                apply()
            }

            // Переход на экран входа
            findNavController().navigate(R.id.action_registration_to_login)
        }

        return view
    }
}