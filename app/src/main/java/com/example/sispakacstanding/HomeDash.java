package com.example.sispakacstanding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeDash extends AppCompatActivity {

    Button kerus,diag,tentang;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_dash);
        kerus = findViewById(R.id.butdaftar);
        diag = findViewById(R.id.butdiagnosa);
        tentang = findViewById(R.id.buttentang);
        diag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeDash.this, Diagnosa.class);
                startActivity(intent);
                finish();
            }
        });
        kerus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeDash.this, InfoKerusakan.class);
                startActivity(intent);
                finish();
            }
        });
        tentang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeDash.this, Tentang.class);
                startActivity(intent);
                finish();
            }
        });
    }
}