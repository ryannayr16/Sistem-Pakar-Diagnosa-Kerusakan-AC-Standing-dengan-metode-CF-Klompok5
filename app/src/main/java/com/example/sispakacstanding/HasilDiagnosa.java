package com.example.sispakacstanding;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.sispakacstanding.api.ApiClient;
import com.example.sispakacstanding.api.ApiInterface;
import com.example.sispakacstanding.modul.HasilDiag;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HasilDiagnosa extends AppCompatActivity {

    TextView hs,sl;
    ApiInterface api;
    Button info, ulang, konsul;
    ImageButton kem;
    String hasil, namhasil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil_diagnosa);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            hasil = extras.getString("hasil");
            namhasil = extras.getString("namhasil");
        }
        hs = findViewById(R.id.hasildiag);
        sl = findViewById(R.id.solusidiag);
        info = findViewById(R.id.butinfokerus);
        ulang = findViewById(R.id.butdiagulang);
        kem = findViewById(R.id.butkemdhasil);
        konsul = findViewById(R.id.butkonsul);
        init(hasil, namhasil);
        kem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HasilDiagnosa.this, HomeDash.class);
                startActivity(intent);
                finish();
            }
        });
        info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HasilDiagnosa.this, InfoKerusakan.class);
                startActivity(intent);
                finish();
            }
        });

        ulang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HasilDiagnosa.this, Diagnosa.class);
                startActivity(intent);
                finish();
            }
        });
        konsul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = "6281248793440";  // Ganti dengan nomor telepon yang diinginkan
                String url = "https://api.whatsapp.com/send?phone=" + phoneNumber;
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
            }
        });
    }

    public void init(String key, String keyy){
        api = ApiClient.getClient().create(ApiInterface.class);
        Call<HasilDiag> call = api.gethasilpak(key, keyy);
        call.enqueue(new Callback<HasilDiag>() {
            @Override
            public void onResponse(Call<HasilDiag> call, Response<HasilDiag> response) {
                if (response.body() != null && response.isSuccessful()) {
                    HasilDiag hsll = response.body();
                    String nm = hsll.getNamaKerusakan();
                    String nl = hsll.getNilai();
                    String sol = hsll.getSolusi();
                    String nil = nl.substring(0, nl.indexOf("."));
                    hs.setText(nm+" "+nil+"%");
                    sl.setText(sol);
                }else{
                }
            }
            @Override
            public void onFailure(Call<HasilDiag> call, Throwable t) {

            }
        });
    }
}