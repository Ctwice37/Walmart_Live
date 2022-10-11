package com.miu.walmart_live

import android.app.Activity
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_create_account.*
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent

class CreateAccountActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_create_account)





        createAccountButton.setOnClickListener{

            val first = firstName_input.text.toString()
            val last = lastName_input.text.toString()
            val email = email_input.text.toString()
            val password = password_input.text.toString()


            val user = User(first, last, email, password)
//          val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("user_intent", user)
            setResult(Activity.RESULT_OK, intent)

            finish()

            //Toast.makeText(this, "message", Toast.LENGTH_LONG).show()
        }

            }

        }

