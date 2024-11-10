package com.kpavlov.possu_lw_3

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val util = Util()
        val userLogin: EditText = findViewById(R.id.user_login)
        val userEmail: EditText = findViewById(R.id.user_email)
        val userPass: EditText = findViewById(R.id.user_pass)
        val userPhone: EditText = findViewById(R.id.user_phone)
        val button: Button = findViewById(R.id.button_reg)
        val linkToAuth: TextView = findViewById(R.id.link_to_auth)

        linkToAuth.setOnClickListener {
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val email = userEmail.text.toString().trim()
            val pass = userPass.text.toString().trim()
            val phone = userPhone.text.toString().trim()

            if(login == "" || email == "" || pass == "" || phone == "")
                Toast.makeText(this, "You have empty fields.", Toast.LENGTH_LONG).show()
            else {

            if (!email.matches(util.emailPattern)) {
                Toast.makeText(this, "Invalid email format.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (!pass.matches(util.passPattern)) {
                Toast.makeText(this, "Invalid password format.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (!login.matches(util.loginPattern)) {
                Toast.makeText(this, "Invalid login format.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (!phone.matches(util.phonePattern)) {
            Toast.makeText(this, "Invalid phone format.", Toast.LENGTH_LONG).show()
            return@setOnClickListener
            }

                val hashedPassword = util.hashValue(pass)

                val user = User(login, email, hashedPassword, phone)

                val db = DbHelper(this, null)
                db.addUser(user)
                Toast.makeText(this, "User $login added", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userEmail.text.clear()
                userPass.text.clear()
                userPhone.text.clear()
            }
        }
    }

}