package com.example.demo.springboot.application.model;

public class Citta extends Punto
{
	private int identificativo;
	private String name;
	private String country;
	
	public Citta(int identificativo, String name,String country,double lat, double longit) {
		super(lat, longit);
		this.identificativo=identificativo;
		this.name=name;
		this.country=country;
	}
	
	public int getCityId() {
		return identificativo;
	}
	
	public String getNomeCity() {
		return name;
	}
	
	public String getCountry() {
		return country;
	}
		
}