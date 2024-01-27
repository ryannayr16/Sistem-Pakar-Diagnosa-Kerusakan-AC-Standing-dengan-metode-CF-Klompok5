package com.example.sispakacstanding.api;

import com.example.sispakacstanding.modul.Datagejala;
import com.example.sispakacstanding.modul.Datakerusakan;
import com.example.sispakacstanding.modul.HasilDiag;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("datakerusakan.php")
    Call<ArrayList<Datakerusakan>> getdatakerus();

    @GET("datagejala.php")
    Call<ArrayList<Datagejala>> getdatagejala();

    @GET("rule.php")
    Call<HasilDiag> gethasilpak(
            @Query("key") String keyword,
            @Query("keyy") String keyyword
    );
}
