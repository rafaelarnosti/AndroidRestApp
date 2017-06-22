package com.rafaelarnosti.androidrestapp.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rafaelarnosti.androidrestapp.R;
import com.rafaelarnosti.androidrestapp.model.Android;
import com.squareup.picasso.Picasso;

import java.util.List;
import java.util.zip.Inflater;

public class AndroidAdapter extends RecyclerView.Adapter<AndroidAdapter.AndroidViewHolder> {

    private List<Android> androids;

    public AndroidAdapter(List<Android> androids){
        this.androids = androids;
    }

    @Override
    public AndroidViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View meuLayout = inflater.inflate(R.layout.android_row,parent,false);
        return new AndroidViewHolder(meuLayout);
    }

    @Override
    public void onBindViewHolder(AndroidViewHolder holder, int position) {

        holder.tvTitulo.setText(androids.get(position).getNome());
        holder.tvSubTitulo.setText(androids.get(position).getVersao());

        Picasso.with(holder.itemView.getContext())
                .load(androids.get(position).getUrlImagem())
                .into(holder.ivAndroid);

    }

    @Override
    public int getItemCount() {
        return androids.size();
    }

    public class AndroidViewHolder extends RecyclerView.ViewHolder {

        public ImageView ivAndroid;
        public TextView tvTitulo;
        public TextView tvSubTitulo;

        public AndroidViewHolder(View itemView) {
            super(itemView);
            ivAndroid = (ImageView) itemView.findViewById(R.id.ivAndroid);
            tvTitulo = (TextView) itemView.findViewById(R.id.tvTitulo);
            tvSubTitulo = (TextView) itemView.findViewById(R.id.tvSubTitulo);

           }
    }
    public void update(List<Android> androids){
        this.androids = androids;
        notifyDataSetChanged();
    }
}
