package com.example.sispakacstanding.modul;

import com.google.gson.annotations.SerializedName;

public class Datagejala{

	@SerializedName("nama_gejala")
	private String namaGejala;

	@SerializedName("id_gejala")
	private String idGejala;

	public String getNamaGejala(){
		return namaGejala;
	}

	public String getIdGejala(){
		return idGejala;
	}
}