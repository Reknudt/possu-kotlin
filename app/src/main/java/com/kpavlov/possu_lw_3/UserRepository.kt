package com.kpavlov.possu_lw_3;

import android.content.ContentValues
import android.content.Context

class UserRepository(context: Context) {
    private val dbHelper = DbHelper(context)

    fun addUser(user: User) {
        val db = dbHelper.writableDatabase

        val values = ContentValues().apply {
            put("login", user.login)
            put("email", user.email)
            put("phone", user.phone)
            put("pass", user.pass)
        }

        db.insert(DbHelper.TABLE_NAME, null, values)

        db.close()
    }

    fun getUser(login: String, pass: String): Boolean {
        val db = dbHelper.readableDatabase

        val res = db.rawQuery("SELECT * FROM '$dbHelper.TABLE_NAME' WHERE login = '$login' AND pass = '$pass'", null)

        return res.moveToFirst()
    }
}