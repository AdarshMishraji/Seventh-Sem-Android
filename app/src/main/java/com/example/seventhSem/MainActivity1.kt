package com.example.seventhSem

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity


class MainActivity1 : AppCompatActivity() {
    private val preDefPassword = "asdfghjkl!@#1234567890";
    private val emailRegex = Regex("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}\$");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main1)
        title = "Seventh Semester"

        val sharedPreferences = getSharedPreferences("LoginSharedPrefs", MODE_PRIVATE)
        val userPrevLogin = sharedPreferences.getString("user", null);

        if (userPrevLogin != null){
            AlertDialog.Builder(this)
                .setTitle("Login")
                .setMessage("You already have been logged in")
                .setCancelable(true).setOnCancelListener {
                    finish();
                }.show();
        }

        val emailField = findViewById<EditText>(R.id.email);
        val passwordField = findViewById<EditText>(R.id.password);
        val loginBtn = findViewById<Button>(R.id.loginBtn);

        loginBtn.setOnClickListener{
            val email = emailField.text;
            val password = passwordField.text;

            Log.d("button login", "$email $password");

            if (email.isNotEmpty() && password.toString() == preDefPassword) {
                val sharedPrefEdit = sharedPreferences.edit()
                sharedPrefEdit.putString("user", "${email.toString()}::${password.toString()}");
                sharedPrefEdit.commit();
                AlertDialog.Builder(this)
                    .setTitle("Login Successful")
                    .setMessage("LoggedIn Successfully")
                    .setCancelable(true).setOnCancelListener {
                        finish();
                    }.show();
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Login Error")
                    .setMessage("Error while login")
                    .setCancelable(true)
                    .show();
            }
        }
    }
}