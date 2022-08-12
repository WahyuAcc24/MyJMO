package com.wr15.myjmo.activity

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import com.wr15.myjmo.R
import kotlinx.android.synthetic.main.lay_profil.*

class ProfileActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lay_profil)

        imgBackProfil.setOnClickListener {
            finish()
        }

        imgLogout.setOnClickListener {
            finish()
        }



    }

}