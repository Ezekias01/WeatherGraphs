package com.example.demo.springboot.application.model;
/**
 * La classe Weather possiede un intero che indica l'identificativo
 * del tempo in un preciso momento e che descrivono il tempo.  
 */
public class Weather {
	private int idW;
	private String main;
	private String description;
	
	public Weather(int idW,String main, String description) {
		this.idW=idW;
		this.main=main;
		this.description=description;
	}
/**
 * Il metodo restituisce l'identificativo della condizione atmosferica 	
 * @return l'identificativo della condizione atmosferica
 */
	public int getIdW() {
		return idW;
	}
/**
 * Il metodo restituisce descrizione essenziale della condizione metereologica
 * @return main
 */
	public String getMain() {
		return main;
	}
/**
 *	Il metodo restituisce la descrizione ampliata della condizione metereologica
 * @return description
 */
	public String getDescription() {
		return description;
	}	
}

