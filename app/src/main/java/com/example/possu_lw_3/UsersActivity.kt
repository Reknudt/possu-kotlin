package com.example.possu_lw_3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.possu_lw_3.R

class ItemsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_users)

        val usersListView: RecyclerView = findViewById(R.id.usersList)
        val usersList = arrayListOf<User>()

        usersList.add(User("Alex", "alex@mail.com", "123456passP!", "+375291341341"))
        usersList.add(User("Bob", "bob@mail.com", "qwertyQ1#", "+375291111112"))
        usersList.add(User("John", "john@mail.com", "johnyPASS123*", "+375291111113"))

        usersListView.layoutManager = LinearLayoutManager(this)
//        val db = DbHelper(this, null)
//
//        usersList = db.getAllUsers()
        usersListView.adapter = UsersAdapter(usersList, this)
    }
}