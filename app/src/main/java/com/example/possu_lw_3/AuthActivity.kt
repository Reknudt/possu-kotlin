package com.example.possu_lw_3

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
        val buttonSwitch: Button = findViewById(R.id.button_auth)
        val linkToReg: TextView = findViewById(R.id.link_to_reg)
        val buttonDelete: Button = findViewById(R.id.button_del)

        linkToReg.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        buttonSwitch.setOnClickListener {
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
                } else
                    Toast.makeText(this, "User $login is not authorized", Toast.LENGTH_LONG).show()


                userLogin.text.clear()
                userPass.text.clear()
            }
        }

        buttonDelete.setOnClickListener {
            val login = userLogin.text.toString().trim()

            if (login.isEmpty()) {
                Toast.makeText(this, "Введите логин", Toast.LENGTH_LONG).show()
            } else {
                val db = DbHelper(this, null)
                val isDeleted = db.deleteUser(login)

                if (isDeleted) {
                    Toast.makeText(this, "Пользователь $login удален", Toast.LENGTH_LONG).show()
                    userLogin.text.clear()
                } else {
                    Toast.makeText(this, "Пользователь $login не найден", Toast.LENGTH_LONG).show()
                }
            }
        }
    }
}