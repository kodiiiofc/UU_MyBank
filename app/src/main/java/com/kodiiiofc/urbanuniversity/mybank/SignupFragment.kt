package com.kodiiiofc.urbanuniversity.mybank

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class SignupFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_signup, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val usernameET = view.findViewById<EditText>(R.id.et_username_signup)
        val passwordET = view.findViewById<EditText>(R.id.et_password_signup)

        val submitBTN = view.findViewById<Button>(R.id.btn_submit_signup)

        submitBTN.setOnClickListener {
            registerUser(
                usernameET.text.toString().trim(),
                passwordET.text.toString().trim()
            )
        }

    }

    private fun registerUser(username: String, password: String) {
        val db = DBHelper(activity as Context)
        if (db.registerUser(username, password)) {
        Toast.makeText(activity, "Пользователь зарегистрирован", Toast.LENGTH_SHORT).show() }
        else { Toast.makeText(activity, "Пользователь уже зарегистрирован", Toast.LENGTH_SHORT).show() }

        val transaction = this.fragmentManager?.beginTransaction()
        transaction?.replace(R.id.cl_authorization, LoginFragment())
        transaction?.commit()
    }


}