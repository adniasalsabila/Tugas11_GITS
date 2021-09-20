package com.gits.authapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.gits.authapp.ui.activity.MainActivity

class LoginActivity : AppCompatActivity() {
    private lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        button = findViewById(R.id.buttonLogin)
        button.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}