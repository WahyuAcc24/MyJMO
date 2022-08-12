package com.wr15.myjmo.fragment

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.wr15.myjmo.R
import com.wr15.myjmo.adapter.MenuAdapter
import com.wr15.myjmo.model.Logo
import kotlinx.android.synthetic.main.frag_home.*

class FragHome : Fragment() {


    lateinit var txt_email : TextView
    lateinit var txt_pass : TextView
    var adapter: MenuAdapter? = null
    var logoList= ArrayList<Logo>()

    var PREFS_NAME = "PREFS"
    var LOGIN = "login"


    var KEY_EMAIL = "KEY_EMAIL"
    var KEY_PASSWORD = "KEY_PASSWORD"

    lateinit var sharedPreferences: SharedPreferences




    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frag_home, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        sharedPreferences =activity?.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE) as SharedPreferences


        sharedPreferences.getBoolean(LOGIN,true)


        logoList.add(Logo("Pembayaran Iuran", R.drawable.pembayaran))
        logoList.add(Logo("Promo", R.drawable.dikson))
        logoList.add(Logo("Pengkinian Data", R.drawable.data))
        logoList.add(Logo("Mitra Layanan", R.drawable.toko))
        logoList.add(Logo("Info Program", R.drawable.kartu))
        logoList.add(Logo("Pelaporan", R.drawable.laporan))
        logoList.add(Logo("Kantor Cabang", R.drawable.gedung))
        logoList.add(Logo("Pengaduan", R.drawable.speaker))
        logoList.add(Logo("Bantuan",R.drawable.bantuan))


        adapter = MenuAdapter(logoList,getActivity()?.applicationContext)
        menu_layanan.adapter = adapter


//        txt_email = getView()?.findViewById(R.id.txtEmail) as TextView
//        txt_pass = getView()?.findViewById(R.id.txtPass) as TextView
//
//
//        txt_email.setText(sharedPreferences.getString(KEY_EMAIL,null))
//        txt_pass.setText(sharedPreferences.getString(KEY_PASSWORD,null))
//


    }

    companion object {
        fun newInstance(): FragHome {
            val fragment = FragHome()
            val args = Bundle()
            fragment.arguments = args

            return fragment
        }
    }



}