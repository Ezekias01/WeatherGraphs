package com.example.demo.springboot.application.model;
/**
 * La classe temperatura possiede un unico attributo
 * di tipo double che indica il valore della temperatura.
 * @author Ezekias Mastaki
 * @author Andrea Pizzuto
 */
public class Temperatura {
	private double valore;
	
	public Temperatura(double valore) {
		this.valore=valore;
	}
/**
 * Il metodo restituisce il valore della temperatura di tipo double	
 * @return valore della temperatura
 */
	public double getValore() {
		return valore;
	}	
}
