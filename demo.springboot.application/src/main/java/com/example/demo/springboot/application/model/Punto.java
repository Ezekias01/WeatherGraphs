package com.example.demo.springboot.application.model;

public class Punto {
	private double lat;
	private double longit;
	private Misura misura;
	
	public Punto(double lat,double longit,Misura misura) {
		this.lat=lat;
		this.longit=longit;
		this.misura=misura;
	}

	public double getLat() {
		return lat;
	}
	
	
	public double getLongit() {
		return longit;
	}

	public Misura getMisura() {
		return misura;
	}
	
}