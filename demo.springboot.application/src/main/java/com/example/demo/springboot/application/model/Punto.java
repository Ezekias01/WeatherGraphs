package com.example.demo.springboot.application.model;
import java.util.Arraylist;
public class Punto {
	private double lat;
	private double longit;
	private ArrayList<Misura> Misure;
	
	public Punto(double lat,double longit) {
		this.lat=lat;
		this.longit=longit;
		this.Misure=new Arraylist<Misura>();
	}

	public double getLat() {
		return lat;
	}
	
	
	public double getLongit() {
		return longit;
	}

	public ArrayList<Misura> getMisura() {
		return Misure;
	}
	
	public boolean addMisura (Misura misura) {
		if(Misure.contains(misura)) {
			return false;
		}
		else {
			Misure.add(misura);
			return true;
		}
	}
}
