package com.example.sispakacstanding.modul;

import com.google.gson.annotations.SerializedName;

public class Datakerusakan{

	@SerializedName("keterangan")
	private String keterangan;
	@SerializedName("ciri")
	private String ciri;

	@SerializedName("solusi")
	private String solusi;

	@SerializedName("nama_kerusakan")
	private String namaKerusakan;

	@SerializedName("id_kerusakan")
	private String idKerusakan;

	public void setKeterangan(String keterangan){
		this.keterangan = keterangan;
	}

	public void setCiri(String ciri){
		this.ciri = ciri;
	}
	public String getCiri(){
		return ciri;
	}
	public String getKeterangan(){
		return keterangan;
	}

	public void setSolusi(String solusi){
		this.solusi = solusi;
	}

	public String getSolusi(){
		return solusi;
	}

	public void setNamaKerusakan(String namaKerusakan){
		this.namaKerusakan = namaKerusakan;
	}

	public String getNamaKerusakan(){
		return namaKerusakan;
	}

	public void setIdKerusakan(String idKerusakan){
		this.idKerusakan = idKerusakan;
	}

	public String getIdKerusakan(){
		return idKerusakan;
	}
}