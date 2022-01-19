package com.example.demo.springboot.application.model;
/**
 * La sottoclasse Citta eredita dalla superclasse Punto 
 * e possiede tre attributi di cui un intero che indica l'identificativo 
 * della citta, e due stringhe che corrispondono al nome della citta e al nome
 * dello stato in cui si trova.
 * @author Andrea Pizzuto
 * @author Ezekias Mastaki
 */
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
/**
 * Il metodo restituisce l'identificativo della citta
 * @return identificativo
 */
	public int getCityId() {
		return identificativo;
	}
/**
 * Il metodo restituisce il nome della citta
 * @return name
 */
	public String getNomeCity() {
		return name;
	}
/**
 * Il metodo restituisce il nome del paese in cui si trova la citta
 * @return country
 */
	public String getCountry() {
		return country;
	}
		
}