package com.kpavlov.possu_lw_3

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_auth)

        val util = Util()
        val userLogin: EditText = findViewById(R.id.user_login_auth)
        val userPass: EditText = findViewById(R.id.user_pass_auth)
        val button: Button = findViewById(R.id.button_auth)
        val linkToReg: TextView = findViewById(R.id.link_to_reg)

        linkToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener {
            val login = userLogin.text.toString().trim()
            val pass = userPass.text.toString().trim()

            if (!pass.matches(util.passPattern)) {
                Toast.makeText(this, "Invalid password format.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }
            if (!login.matches(util.loginPattern)) {
                Toast.makeText(this, "Invalid login format.", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            if (login == "" || pass == "")
                Toast.makeText(this, "You have empty fields.", Toast.LENGTH_LONG).show()
            else {
                val db = DbHelper(this, null)
                val isAuth = db.getUser(login, util.hashValue(pass))

                if (isAuth) {
                    Toast.makeText(this, "User $login is authorized", Toast.LENGTH_LONG).show()

                    userLogin.text.clear()
                    userPass.text.clear()

                    val intent = Intent(this, ItemsActivity::class.java)
                    startActivity(intent)
                } else
                    Toast.makeText(this, "User $login is not authorized", Toast.LENGTH_LONG).show()
            }
        }
    }
}