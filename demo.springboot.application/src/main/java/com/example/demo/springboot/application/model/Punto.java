package com.example.demo.springboot.application.model;

public class Punto {
	private double lat;
	private double longit;
	
	public Punto(double lat,double longit) {
		this.lat=lat;
		this.longit=longit;
	}

	public double getLat() {
		return lat;
	}
	
	
	public double getLongit() {
		return longit;
	}
}