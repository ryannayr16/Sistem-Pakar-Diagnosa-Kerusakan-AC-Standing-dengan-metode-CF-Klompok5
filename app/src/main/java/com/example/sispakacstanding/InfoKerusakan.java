package com.example.sispakacstanding;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.sispakacstanding.adapter.AdapterInfoKerusakan;
import com.example.sispakacstanding.api.ApiClient;
import com.example.sispakacstanding.api.ApiInterface;
import com.example.sispakacstanding.modul.Datakerusakan;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class InfoKerusakan extends AppCompatActivity {

    RecyclerView recy;
    AdapterInfoKerusakan adp;
    LinearLayoutManager linearLayoutManager;
    List<Datakerusakan> data;
    ApiInterface api;
    ImageButton but1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_kerusakan);
        recy = findViewById(R.id.recyclekerus);
        linearLayoutManager = new LinearLayoutManager(this);
        recy.setLayoutManager(linearLayoutManager);
        recy.setHasFixedSize(true);
        but1 = findViewById(R.id.butkeminfoker);
        dataaa();
         but1.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent intent = new Intent(InfoKerusakan.this, HomeDash.class);
                 startActivity(intent);
                 finish();
             }
         });

    }

    public void dataaa(){
        api = ApiClient.getClient().create(ApiInterface.class);
        Call<ArrayList<Datakerusakan>> call = api.getdatakerus();
        call.enqueue(new Callback<ArrayList<Datakerusakan>>(){
            @Override
            public void onResponse(Call<ArrayList<Datakerusakan>> call, Response<ArrayList<Datakerusakan>> response) {
                data = response.body();
                adp = new AdapterInfoKerusakan(InfoKerusakan.this, data);
                recy.setAdapter(adp);
                adp.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<ArrayList<Datakerusakan>> call, Throwable t) {
                Toast.makeText(InfoKerusakan.this, t.getLocalizedMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}