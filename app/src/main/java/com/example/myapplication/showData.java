package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class showData extends RecyclerView.Adapter<showData.MyViewHolder> {
    private Context context;
    private ArrayList<UseHelpers>dataMhs;

    public showData(Context cont, ArrayList<UseHelpers>data){
        context = cont;
        dataMhs = data;
    }
    @NonNull
    @Override    
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_mhs, parent,false); //convert layout
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.nama.setText(dataMhs.get(position).getNama());
        holder.nim.setText(dataMhs.get(position).getNim());
        holder.alamat.setText(dataMhs.get(position).getAlamat());
        holder.umur.setText(dataMhs.get(position).getUmur());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView nama,nim,alamat,umur;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            nama = itemView.findViewById(R.id.hasilNama);
            nim = itemView.findViewById(R.id.hasilNim);
            alamat = itemView.findViewById(R.id.hasilAlamat);
            umur = itemView.findViewById(R.id.hasilUmur);
        }
    }
    
}
