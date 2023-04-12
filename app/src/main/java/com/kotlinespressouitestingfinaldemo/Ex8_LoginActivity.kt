package com.kotlinespressouitestingfinaldemo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class Ex8_LoginActivity : AppCompatActivity() {
    private lateinit var etUserName : EditText
    private lateinit var etPwd : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ex8_login)
        etUserName = findViewById(R.id.etUserName)
        etPwd = findViewById(R.id.etPwd)
    }

    fun checkLogin(view: View) {
        if(etUserName.text.toString().equals("abc")&&etPwd.text.toString().equals("123")){
            startActivity(Intent(applicationContext,WelcomeActivity::class.java))
        }else{
            Toast.makeText(this@Ex8_LoginActivity,"Failure",Toast.LENGTH_LONG).show()
        }
    }
}