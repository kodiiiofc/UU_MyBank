package com.kodiiiofc.urbanuniversity.mybank

import java.io.Serializable

data class Intro(val text: String, val imageResources: Int, var isLoginPage: Boolean = false) : Serializable
