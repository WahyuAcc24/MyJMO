package com.wr15.myjmo.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import com.wr15.myjmo.R
import com.wr15.myjmo.model.Logo
import kotlinx.android.synthetic.main.gridview_menu.view.*

class MenuAdapter : BaseAdapter {
    var logoList = ArrayList<Logo>()
    var context: Context? = null

    constructor(logoList: ArrayList<Logo>, context: Context?) : super() {
        this.logoList = logoList
        this.context = context
    }

    override fun getCount(): Int {
        return logoList.size
    }

    override fun getItem(position: Int): Any {
        return logoList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val menu = this.logoList[position]

        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var logoView = inflator.inflate(R.layout.gridview_menu, null)

        logoView.imgLogo.setImageResource(menu.image!!)
        logoView.textViewLogo.text = menu.name!!


        return logoView
    }

}