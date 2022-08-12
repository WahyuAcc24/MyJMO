package com.wr15.myjmo.activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.wr15.myjmo.R
import com.wr15.myjmo.fragment.FragBerita
import com.wr15.myjmo.fragment.FragHome
import com.wr15.myjmo.fragment.FragKontak
import io.isfaaghyth.rak.Rak
import kotlinx.android.synthetic.main.lay_home.*
import java.util.prefs.Preferences

class HomeActivity : AppCompatActivity() {


    lateinit var sharedPreferences: SharedPreferences
    var PREFS_NAME = "PREFS"
    var LOGIN = "login"


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lay_home)



        bn_main.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        val fragment = FragHome.newInstance()
        addFragment(fragment)





    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->

        when (item.itemId) {
            R.id.beranda_menu -> {
//                findNavController(R.id.nav_host_fragment).navigate(R.id.nav_home)
                val fragment = FragHome()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true

            }
            R.id.berita_menu -> {
//                findNavController(R.id.nav_host_fragment).navigate(R.id.bantuan_bot)
                val fragmentberita = FragBerita()
                addFragment(fragmentberita)
                return@OnNavigationItemSelectedListener true

            }
            R.id.kontak_menu -> {
                val fragmentkontak = FragKontak()
                addFragment(fragmentkontak)
                return@OnNavigationItemSelectedListener true

            }
            R.id.profil_menu -> {
                val intent = Intent(this,ProfileActivity::class.java)
                startActivity(intent)

            }


        }
        false
    }

    private fun addFragment(fragment: Fragment) {


        supportFragmentManager
            .beginTransaction()
            .setCustomAnimations(
                R.anim.design_bottom_sheet_slide_in,
                R.anim.design_bottom_sheet_slide_out
            )
            .replace(R.id.f1_container, fragment,fragment.javaClass.simpleName)
            .commit()
    }

    private fun replaceFragment(){


        supportFragmentManager
            .popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)


    }



}