package com.kpavlov.possu_lw_3

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DbHelper(val context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_NAME = "my_database.db"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "users"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val createTableSQL  = "CREATE TABLE users (id INT PRIMARY KEY AUTOINCREMENT, login TEXT, email TEXT, pass TEXT, phone TEXT)"
        db!!.execSQL(createTableSQL)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS users")
        onCreate(db)
    }

}