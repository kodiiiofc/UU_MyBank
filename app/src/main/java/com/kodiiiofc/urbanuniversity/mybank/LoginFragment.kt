package com.kodiiiofc.urbanuniversity.mybank

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val usernameET = view.findViewById<EditText>(R.id.et_username_login)
        val passwordET = view.findViewById<EditText>(R.id.et_password_login)
        val submitBTN = view.findViewById<Button>(R.id.btn_submit_login)

        submitBTN.setOnClickListener {
            loginUser(
                usernameET.text.toString().trim(),
                passwordET.text.toString().trim()
            )
        }


    }

    private fun loginUser(username: String, password: String) {
        val db = DBHelper(activity as Context)
        val dbpass = db.getPassword(username)
        if (dbpass == null) {
            Toast.makeText(activity, "Пользователь не зарегистрирован", Toast.LENGTH_SHORT).show()
        }
        else {
            if (dbpass == password) {
                Toast.makeText(activity, "Вы вошли в аккаунт", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(activity, "Неверный пароль", Toast.LENGTH_SHORT).show()
            }
        }
    }
}