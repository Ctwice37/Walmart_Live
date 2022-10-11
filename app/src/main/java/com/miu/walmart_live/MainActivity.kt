package com.miu.walmart_live

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import kotlinx.android.synthetic.main.activity_create_account.*
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var users = ArrayList<User>()

        val p1 = User("Charles", "Carpenter","carpe359@gmail.com", "1111")
        val p2 = User("Sam", "Carpenter","aaaa@gmail.com", "1111")
        val p3 = User("Emmie", "Carpenter","vvvv@gmail.com", "1111")
        val p4 = User("Maggie", "Carpenter","bbbb@gmail.com", "1111")
        val p5 = User("Lisa", "Carpenter","ssss@gmail.com", "1111")
        val p6 = User("a", "a","a", "a")

        users.add(p1)
        users.add(p2)
        users.add(p3)
        users.add(p4)
        users.add(p5)
        users.add(p6)





        signIn.setOnClickListener {
            var email = editTextTextEmailAddress.text.toString()
            var pass = editTextTextPassword.text.toString()

            for(User in users){
                if(User.email == email && User.password == pass){
                    val intent = Intent(this, ShoppingCategoryActivity::class.java)
                    intent.putExtra("message",User.firstName)
                    startActivity(intent)
                }
            }
        }


        var resultContracts = 		//method name
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result->
                if(result.resultCode == Activity.RESULT_OK) {
                    var temp = result.data?.getSerializableExtra("user_intent") as User

                    users.add(temp)
                    Toast.makeText(this, "Added User ${temp.firstName}", Toast.LENGTH_LONG).show()


                }else
                    Toast.makeText(this, "Failed to Receive User", Toast.LENGTH_LONG).show()
            }


        createAccount.setOnClickListener{
            val intent = Intent(this, CreateAccountActivity::class.java)
            resultContracts.launch(intent)
        }

        
        forgotPassword.setOnClickListener{

            val email = editTextTextEmailAddress.text.toString()

            val intent = Intent(Intent.ACTION_SENDTO, Uri.parse( "mailto:$email"))
            intent.putExtra(Intent.EXTRA_SUBJECT, "Forgot Password")                            //doesn't Work
            startActivity(intent)


        }
    }

}




