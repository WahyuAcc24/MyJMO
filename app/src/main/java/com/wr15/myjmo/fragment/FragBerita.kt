package com.wr15.myjmo.fragment

import android.content.ContentValues
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.bumptech.glide.Glide
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.wr15.myjmo.AppController
import com.wr15.myjmo.HttpsTrustManager
import com.wr15.myjmo.R
import com.wr15.myjmo.adapter.BeritaAdapter
import com.wr15.myjmo.model.Mberita
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject
import java.lang.Exception
import java.lang.reflect.Type

class FragBerita : Fragment() {

    private lateinit var rv_berita: RecyclerView
    private lateinit var pg_berita: ProgressBar
    private var adapter: BeritaAdapter? = null
    private var requesQueue: RequestQueue? = null


    private val url: String = "https://jsonplaceholder.typicode.com/posts"

    lateinit var swipeRefreshLayout: SwipeRefreshLayout

    var MBerita: List<Mberita>? = null



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.frag_berita, container, false)


    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        HttpsTrustManager.allowAllSSL()

        rv_berita = view.findViewById(R.id.rvListBerita)
        pg_berita = view.findViewById(R.id.pbBerita)
        swipeRefreshLayout = view.findViewById(R.id.swipeberita)

        requesQueue = Volley.newRequestQueue(context)

        rv_berita.setLayoutManager(LinearLayoutManager(context) as RecyclerView.LayoutManager?)

        MBerita = ArrayList()


        ListBerita()

        swipeRefreshLayout.setColorSchemeResources(R.color.hijau_tua, R.color.hijau, R.color.merah)


        swipeRefreshLayout.setOnRefreshListener(object : SwipeRefreshLayout.OnRefreshListener {
            override fun onRefresh() {
                // Handler untuk menjalankan jeda selama 5 detik
                Handler().postDelayed(object : Runnable {
                    override fun run() {
                        // Berhenti berputar/refreshing
                        swipeRefreshLayout.setRefreshing(false)
                        ListBerita()

                    }
                }, 3000)
            }
        })




    }
    companion object {
        fun newInstance(): FragBerita {
            val fragmentberita = FragBerita()
            val args = Bundle()
            fragmentberita.arguments = args

            return fragmentberita
        }
    }

    fun ListBerita() {

        pg_berita.setVisibility(View.GONE)


        val request =
            StringRequest(Request.Method.GET, url, onPostsLoaded, object : Response.ErrorListener {
                override fun onErrorResponse(error: VolleyError?) {

                    var inetErr: android.app.AlertDialog.Builder = android.app.AlertDialog.Builder(context)
                    inetErr.setTitle("Terjadi Kesalahan")
                    inetErr.setMessage("Periksa Kembali Koneksi Internet Anda")
                    inetErr.setNegativeButton("Muat Ulang",
                        object : DialogInterface.OnClickListener {
                            override fun onClick(dialog: DialogInterface?, which: Int) {
                                ListBerita()

                            }

                        })
                    inetErr.show()
                }
            })
//        AppController.getInstance().addToRequestQueue(request)
        requesQueue?.add(request)
    }

    val onPostsLoaded = object : Response.Listener<String> {
        override fun onResponse(response: String) {

            pg_berita.setVisibility(View.GONE)

            Log.e("TAG", response)


            try {
                pg_berita.setVisibility(View.GONE)

                var jsonArray = JSONArray(response)

                for (i in 0 until jsonArray.length()) {

                    var jsonObject = jsonArray.getJSONObject(i)

                    var data_berita = Mberita()

                    data_berita.setTitle(jsonObject.getString("title"))
                    data_berita.setBody(jsonObject.getString("body"))

                    (MBerita as ArrayList<Mberita>).add(data_berita)

                    adapter = BeritaAdapter(context, MBerita)

                    rv_berita.adapter = adapter




                }





            } catch (ignored: Exception) {
                Toast.makeText(context, "Tidak Ada Data", Toast.LENGTH_SHORT).show()

            }
        }

    }

}

