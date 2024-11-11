package com.kpavlov.possu_lw_3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class UsersActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_users)

        val usersListView: RecyclerView = findViewById(R.id.usersList)
        val usersList = arrayListOf<UserInfo>()

        usersList.add(UserInfo(1, "sofa", "Alex", "Height, weight, wealth, married/not married", "alexsamrydir@gmail.com", "+375291341341", "123456passP!"))
        usersList.add(UserInfo(2, "light", "Bob", "Height, weight, wealth, married/not married", "bob@mail.com", "+375291111112", "qwertyQ1#"))
        usersList.add(UserInfo(3, "kitchen", "John", "Height, weight, wealth, married/not married", "john@mail.com", "+375291111113", "johnyPASS123*"))

        usersListView.layoutManager = LinearLayoutManager(this)
        usersListView.adapter = UsersAdapter(usersList, this)
    }
}