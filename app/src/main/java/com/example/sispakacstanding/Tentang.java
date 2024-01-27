package com.example.sispakacstanding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class Tentang extends AppCompatActivity {

    ImageButton kem;
    Button pak;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tentang);
        kem = findViewById(R.id.butkemtentang);
        pak = findViewById(R.id.buttentangpakar);
        kem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tentang.this, HomeDash.class);
                startActivity(intent);
                finish();
            }
        });
        pak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Tentang.this, TentangPakar.class);
                startActivity(intent);
                finish();
            }
        });
    }
}