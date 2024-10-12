package com.kodiiiofc.urbanuniversity.mybank

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class IntroFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_intro, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val textTV = view.findViewById<TextView>(R.id.tv_text)
        val imageIV = view.findViewById<ImageView>(R.id.iv_image)
        val loginBTN = view.findViewById<Button>(R.id.btn_login)
        val signupBTN = view.findViewById<Button>(R.id.btn_signup)

        loginBTN.setOnClickListener { toLoginFragment() }
        signupBTN.setOnClickListener { toSignupFragment() }

        val intro = arguments?.getSerializable("intro") as Intro

        textTV.text = intro.text
        imageIV.setImageResource(intro.imageResources)

        if (intro.isLoginPage) {
            loginBTN.visibility = View.VISIBLE
            signupBTN.visibility = View.VISIBLE
        } else {
            loginBTN.visibility = View.GONE
            signupBTN.visibility = View.GONE
        }

    }

    private fun toLoginFragment() {
        val intent = Intent(activity, AuthorizationActivity::class.java)
        intent.putExtra("code", Utils.LOGIN_CODE)
        startActivity(intent)
    }

    private fun toSignupFragment() {
        val intent = Intent(activity, AuthorizationActivity::class.java)
        intent.putExtra("code", Utils.SIGNUP_CODE)
        startActivity(intent)
    }

}