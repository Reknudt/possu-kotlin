package com.kpavlov.possu_lw_3

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        val login: TextView = findViewById(R.id.user_list_login)
        val email: TextView = findViewById(R.id.user_list_email)
        val phone: TextView = findViewById(R.id.user_list_phone)

        login.text = intent.getStringExtra("userLogin")
        email.text = intent.getStringExtra("userEmail")
        phone.text = intent.getStringExtra("userPhone")
    }
}