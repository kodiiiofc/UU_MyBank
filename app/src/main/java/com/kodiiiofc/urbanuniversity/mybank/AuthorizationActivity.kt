package com.kodiiiofc.urbanuniversity.mybank

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class AuthorizationActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_authorization)

        val code = intent.getIntExtra("code", Utils.SIGNUP_CODE)
        Log.d("code", code.toString())
        val fragment = if (code == Utils.LOGIN_CODE) LoginFragment() else SignupFragment()
        supportFragmentManager.beginTransaction()
            .add(R.id.cl_authorization, fragment)
            .commit()



    }
}