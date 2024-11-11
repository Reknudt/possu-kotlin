package com.kpavlov.possu_lw_3

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class UsersAdapter(var usersInfo: List<UserInfo>, var context: Context) :
    RecyclerView.Adapter<UsersAdapter.MyViewHolder>() {

    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val image: ImageView = view.findViewById(R.id.user_list_image)
        val login: TextView = view.findViewById(R.id.user_list_login)
        val description: TextView = view.findViewById(R.id.user_list_description)
        val email: TextView = view.findViewById(R.id.user_list_email)
        val pass: TextView = view.findViewById(R.id.user_list_pass)
        val phone: TextView = view.findViewById(R.id.user_list_phone)
        val btn: Button = view.findViewById(R.id.user_list_button)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_in_list, parent, false)
        return MyViewHolder(view)
    }


    override fun getItemCount(): Int {
        return usersInfo.count()
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.login.text = usersInfo[position].login
        holder.description.text = usersInfo[position].description
        holder.email.text = usersInfo[position].email
        holder.pass.text = usersInfo[position].pass
        holder.phone.text = usersInfo[position].phone

        val imageId = if (usersInfo[position].image.isNullOrEmpty()) {
            R.drawable.img
        } else {
            context.resources.getIdentifier(
                usersInfo[position].image,
                "drawable",
                context.packageName
            )
        }
        holder.image.setImageResource(imageId)

        holder.btn.setOnClickListener {
            val intent = Intent(context, UserActivity::class.java)

            intent.putExtra("userLogin", usersInfo[position].login)
            intent.putExtra("userDescription", usersInfo[position].description)
            intent.putExtra("userEmail", usersInfo[position].email)
            intent.putExtra("userPhone", usersInfo[position].phone)
            intent.putExtra("userPass", usersInfo[position].pass)

            context.startActivity(intent)
        }
    }
}
