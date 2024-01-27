package com.example.sispakacstanding.modul;

import com.google.gson.annotations.SerializedName;

public class HasilDiag{

	@SerializedName("nilai")
	private String nilai;

	@SerializedName("solusi")
	private String solusi;

	@SerializedName("nama_kerusakan")
	private String namaKerusakan;

	@SerializedName("id_kerusakan")
	private String idKerusakan;

	@SerializedName("status")
	private int status;

	public String getNilai(){
		return nilai;
	}

	public String getSolusi(){
		return solusi;
	}

	public String getNamaKerusakan(){
		return namaKerusakan;
	}

	public String getIdKerusakan(){
		return idKerusakan;
	}

	public int getStatus(){
		return status;
	}
}