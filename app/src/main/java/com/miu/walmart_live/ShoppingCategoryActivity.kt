package com.miu.walmart_live

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_shopping_category.*

class ShoppingCategoryActivity : AppCompatActivity() {
    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping_category)


        var validUser =  intent.getStringExtra("message")

        textView2.text = "Welcome $validUser"


        imageView2.setOnClickListener{
            Toast.makeText(this, "You have chosen the Electronics category of shopping", Toast.LENGTH_LONG).show()
        }
        imageView4.setOnClickListener{
            Toast.makeText(this, "You have chosen the Clothing category of shopping", Toast.LENGTH_LONG).show()
        }
        imageView5.setOnClickListener{
            Toast.makeText(this, "You have chosen the Beauty category of shopping", Toast.LENGTH_LONG).show()
        }
        imageView6.setOnClickListener{
            Toast.makeText(this, "You have chosen the Food category of shopping", Toast.LENGTH_LONG).show()
        }



    }
}
