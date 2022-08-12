package com.wr15.myjmo.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.wr15.myjmo.R;
import com.wr15.myjmo.model.Mberita;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

public class BeritaAdapter extends RecyclerView.Adapter<BeritaAdapter.Holder> {

    private List<Mberita> historiberita;

    private String TAG = BeritaAdapter.class.getSimpleName();

    private Context mcontext;



    public BeritaAdapter(Context context ,List<Mberita> historiberita) {
        this.historiberita = historiberita;
        this.mcontext = context;
    }



    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new Holder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_berita, parent, false));
    }



    @Override
    public void onBindViewHolder(final Holder holder, final int position) {

        holder.judul_berita.setText("Judul berita :" + historiberita.get(position).getTitle());
        holder.isi_berita.setText("Berita :" + historiberita.get(position).getBody());



    }

    @Override
    public int getItemCount() {
        return historiberita.size();
    }

    class Holder extends RecyclerView.ViewHolder {

        private TextView judul_berita, isi_berita;


        public Holder(View itemView) {
            super(itemView);
            judul_berita = itemView.findViewById(R.id.txtjdlberita);
            isi_berita = itemView.findViewById(R.id.txtberita);

        }

    }
    private void ambilGambar(){






    }



}
