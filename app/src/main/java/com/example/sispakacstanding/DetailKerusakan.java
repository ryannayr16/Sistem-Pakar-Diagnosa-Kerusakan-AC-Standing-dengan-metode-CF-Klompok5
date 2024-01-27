package com.example.sispakacstanding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class DetailKerusakan extends AppCompatActivity {

    TextView nama,keter,solus,cr;
    ImageButton ima;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_kerusakan);
        nama  = findViewById(R.id.nmdetailkerus);
        keter = findViewById(R.id.keterdetailkerus);
        solus = findViewById(R.id.detailsoluskerus);
        ima = findViewById(R.id.butkemdetail);
        cr = findViewById(R.id.detailcirikerus);

        String nmkrs = getIntent().getStringExtra("nama kerusakan");
        String ket = getIntent().getStringExtra("keterangan");
        String sol = getIntent().getStringExtra("solusi");
        String cir = getIntent().getStringExtra("ciri");

        nama.setText(nmkrs);
        keter.setText(ket);
        solus.setText(sol);
        cr.setText(cir);

        ima.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DetailKerusakan.this, InfoKerusakan.class);
                startActivity(intent);
                finish();
            }
        });

    }
}