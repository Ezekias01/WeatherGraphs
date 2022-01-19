package com.example.demo.springboot.application.model;

import java.util.ArrayList;

/**
 * La superclasse Punto descrive un luogo nello spazio caratterizzato da due coordinate espresse dagli 
 * attributi double latitudine e longitudine ed infine un arraylist di misure.
 * Da questa classe erediterà la classe citta.
 * @author Ezekias Mastaki
 * @author Andrea Pizzuto
 */
public class Punto {
	private double lat;
	private double longit;
	private ArrayList<Misura> Misure;
	
	public Punto(double lat,double longit) {
		this.lat=lat;
		this.longit=longit;
		this.Misure=new ArrayList<Misura>();
	}

/**
 * Il metodo restituisce la latitudine
 * @return latitudine
 */
	public double getLat() {
		return lat;
	}

/**
 * 	Il metodo restituisce la longitudine
 * @return longitudine
 */
	public double getLongit() {
		return longit;
	}

/**
 * 	Il metodo restituisce l'arraylist di misure
 * @return arraylist di misure
 */
	public ArrayList<Misura> getMisura() {
		return Misure;
	}
	
/**
 * Il metodo aggiunge un oggetto di tipo misura all'arraylist Misure e restituisce 
 * vero solo se esso non e' gia' presente, altrimenti restituisce false.
 * @param misura
 * @return true/false
 */
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