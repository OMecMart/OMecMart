package com.example.lenovo.omecmart;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.HashMap;


/**
 * Created by user on 29/05/2017.
 */

public class AdapterList extends RecyclerView.Adapter<AdapterList.ViewHolder>{

    Context context;
    ArrayList<HashMap<String, String>> list_data;

    public AdapterList(ListBengkel mainActivity, ArrayList<HashMap<String, String>> list_data) {
        this.context = mainActivity;
        this.list_data = list_data;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_list, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent (view.getContext(), MainActivity.class);
                view.getContext().startActivity(i);
            }
        });
        Glide.with(context)
                .load("http://192.168.43.192/Omecmart/v1/img/" + list_data.get(position).get("gambar"))
                .crossFade()
                .placeholder(R.mipmap.ic_launcher)
                .into(holder.imghape);
        holder.txthp.setText(list_data.get(position).get("nama_bengkel"));
        holder.txthape.setText(list_data.get(position).get("alamat_bengkel"));

    }

    @Override
    public int getItemCount() {
        return list_data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txthp;
        TextView txthape;
        ImageView imghape;

        public ViewHolder(View itemView) {
            super(itemView);
            txthp = (TextView) itemView.findViewById(R.id.txthp);
            txthape = (TextView) itemView.findViewById(R.id.txthape);
            imghape = (ImageView) itemView.findViewById(R.id.imghp);
        }
    }
}

