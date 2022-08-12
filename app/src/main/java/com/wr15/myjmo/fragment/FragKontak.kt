package com.wr15.myjmo.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.wr15.myjmo.R

class FragKontak : Fragment (){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frag_kontak, container, false)


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)





    }
    companion object {
        fun newInstance(): FragKontak {
            val fragmentkontak = FragKontak()
            val args = Bundle()
            fragmentkontak.arguments = args

            return fragmentkontak
        }
    }

}