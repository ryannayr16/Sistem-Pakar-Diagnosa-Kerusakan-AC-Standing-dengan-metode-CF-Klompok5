package com.example.sispakacstanding.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sispakacstanding.DetailKerusakan;
import com.example.sispakacstanding.InfoKerusakan;
import com.example.sispakacstanding.R;
import com.example.sispakacstanding.modul.Datakerusakan;

import java.util.List;

public class AdapterInfoKerusakan extends RecyclerView.Adapter<AdapterInfoKerusakan.AdapterHolder> {

    private Context context;
    private List<Datakerusakan> dtkr;

    public AdapterInfoKerusakan(Context context, List<Datakerusakan> dtkr){
        this.context = context;
        this.dtkr = dtkr;
    }

    @NonNull
    @Override
    public AdapterInfoKerusakan.AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.viewdatakerusakan,parent, false);
        AdapterHolder holder = new AdapterHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterHolder holder, int position) {

        Datakerusakan dtmodel = dtkr.get(position);
        String nmkrs = dtmodel.getNamaKerusakan();

        holder.nmpn.setText(nmkrs);
        holder.cons.setOnClickListener(v ->{

            Intent inten = new Intent(context, DetailKerusakan.class);
            inten.putExtra("id kerusakan", dtmodel.getIdKerusakan());
            inten.putExtra("nama kerusakan", dtmodel.getNamaKerusakan());
            inten.putExtra("keterangan", dtmodel.getKeterangan());
            inten.putExtra("solusi", dtmodel.getSolusi());
            inten.putExtra("ciri", dtmodel.getCiri());
            context.startActivity(inten);
            ((InfoKerusakan) context).finish();
        });
    }

    @Override
    public int getItemCount() {
        return dtkr.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        TextView nmpn;
        ConstraintLayout cons;
        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            nmpn = itemView.findViewById(R.id.nminfokerus);
            cons = itemView.findViewById(R.id.viewdatakerus);
        }
    }
}
