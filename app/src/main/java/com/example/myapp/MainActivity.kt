package com.example.myapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val userLogin: EditText = findViewById(R.id.user_login)
        val userPassword: EditText = findViewById(R.id.user_password)
        val userMail: EditText = findViewById(R.id.user_email)
        val button: Button = findViewById(R.id.button)
        val linkToAuth: TextView = findViewById(R.id.link_to_auth)

        linkToAuth.setOnClickListener{
            val intent = Intent(this, AuthActivity::class.java)
            startActivity(intent)
        }

        button.setOnClickListener{
            val login = userLogin.text.toString().trim()
            val email = userMail.text.toString().trim()
            val pass = userPassword.text.toString().trim()

            if (login == "" || email == "" || pass =="")
                Toast.makeText(this,"Не все поля заполнены", Toast.LENGTH_LONG).show()
            else{
                val user = User(login, email, pass)

                val db = Dbhelper(this, null)
                db.addUser(user)
                Toast.makeText(this,"Пользователь $login добавлен", Toast.LENGTH_LONG).show()

                userLogin.text.clear()
                userMail.text.clear()
                userPassword.text.clear()
            }
        }
    }
}