package com.kpavlov.possu_lw_3

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(val context: Context, val factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, "lw3", factory, 1) {

    override fun onCreate(db: SQLiteDatabase?) {
        val query = "CREATE TABLE users (id INT PRIMARY KEY, login TEXT, email TEXT, pass TEXT, phone TEXT)"
        db!!.execSQL(query)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

    fun addUser(user: User) {
        val values = ContentValues()
        values.put("login", user.login)
        values.put("email", user.email)
        values.put("phone", user.phone)
        values.put("pass", user.pass)

        val db = this.writableDatabase
        db.insert("users", null, values)

        db.close()
    }

    fun getUser(login: String, pass: String): Boolean {
        val db = this.readableDatabase

        val res = db.rawQuery("SELECT * FROM users WHERE login = '$login' AND pass = '$pass'", null)

        return res.moveToFirst()
    }
//
//    fun getAllUsers(): ArrayList<User>() {
//        val db = this.readableDatabase
//
//        val res = arrayListOf<User>()
//        res = db.rawQuery("SELECT * FROM users", null)
//
//        return res
//    }
}