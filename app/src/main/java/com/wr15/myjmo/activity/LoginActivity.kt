package com.wr15.myjmo.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.wr15.myjmo.R
import java.util.prefs.Preferences

class LoginActivity : AppCompatActivity() {

    lateinit var edt_email: EditText
    lateinit var edt_password: EditText
    lateinit var btn_login: Button
    lateinit var sharedPreferences: SharedPreferences
    var PREFS_NAME = "PREFS"
    var LOGIN = "login"

    var KEY_EMAIL = "KEY_EMAIL"
    var KEY_PASSWORD = "KEY_PASSWORD"






    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lay_login)

        edt_email = findViewById(R.id.edtemail)
        edt_password = findViewById(R.id.edtPassword)
        btn_login = findViewById(R.id.btnLogin)

        sharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)




        btn_login.setOnClickListener {

            var email : String = edt_email.text.toString()
            var password : String = edt_password.text.toString()

            var editor : SharedPreferences.Editor = sharedPreferences.edit()



            if (edt_email.getText().toString().equals("admin") && edt_password.getText().toString()
                    .equals("admin")
            ) {

                editor.putString(KEY_EMAIL,email)
                editor.putString(KEY_PASSWORD,password)
                editor.putBoolean(LOGIN,true)
                editor.apply()

                val intent = Intent(this, HomeActivity::class.java)
                startActivity(intent)


                finish()

            } else {
                Toast.makeText(
                    applicationContext,
                    "Nama Dan Password salah",
                    Toast.LENGTH_SHORT
                ).show()

            }
        }




    }


}
