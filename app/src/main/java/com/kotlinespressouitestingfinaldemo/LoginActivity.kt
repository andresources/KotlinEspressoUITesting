package com.kotlinespressouitestingfinaldemo

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.KeyEvent
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.EditText
import android.widget.TextView
import android.widget.TextView.OnEditorActionListener
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class LoginActivity : AppCompatActivity() {
    private lateinit var mEmailEditText: EditText
    private lateinit var mPasswordEditText: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        mEmailEditText = findViewById(R.id.tv_email)
        mPasswordEditText = findViewById(R.id.tv_password)
        mPasswordEditText.setOnEditorActionListener( object : OnEditorActionListener{
            override fun onEditorAction(v: TextView?, actionId: Int, event: KeyEvent?): Boolean {
                if (actionId == R.id.btn_login || actionId == EditorInfo.IME_NULL) {
                    login();
                    return true;
                }
                return false;
            }
        })
    }
    private fun login() {
        // Reset errors.
        mEmailEditText.error = null
        mPasswordEditText.error = null

        // Store values at the time of the login attempt.
        val email = mEmailEditText.text.toString()
        val password = mPasswordEditText.text.toString()
        var cancel = false
        var focusView: View? = null

        // Check for a valid password.
        if (TextUtils.isEmpty(password)) {
            mPasswordEditText.error = getString(R.string.error_field_required)
            focusView = mPasswordEditText
            cancel = true
        } else if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordEditText.error = getString(R.string.error_invalid_password)
            focusView = mPasswordEditText
            cancel = true
        }

        // Check for a valid email address.
        if (TextUtils.isEmpty(email)) {
            mEmailEditText.error = getString(R.string.error_field_required)
            focusView = mEmailEditText
            cancel = true
        } else if (!isEmailValid(email)) {
            mEmailEditText.error = getString(R.string.error_invalid_email)
            focusView = mEmailEditText
            cancel = true
        }
        if (cancel) {
            focusView?.requestFocus()
        } else {
            if (email.equals("user@email.com")  && password.equals( "123456")) {
                loginSuccessfully(email)
            } else {
                Toast.makeText(
                    applicationContext,
                    getString(R.string.error_login_failed),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    private fun isPasswordValid(password: String): Boolean {
        return password.length > 4
    }

    private fun loginSuccessfully(email: String) {
        val intent = Intent(this@LoginActivity, Ex1_ButtonClickActivity::class.java)
        intent.putExtra("email", email)
        startActivity(intent)
        finish()
        Toast.makeText(
            applicationContext,
            getString(R.string.login_successfully),
            Toast.LENGTH_SHORT
        ).show()
    }
}