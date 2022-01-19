package com.example.demo.springboot.application.model;
/**
 * La classe Misura possiede un long e una stringa che indicano il momento in cui
 * e' stata fatta la misura in formati differenti, infine tutte le altre proprietà
 * utili ai fini delle statistiche.
 * @author Andrea Pizzuto
 * @author Ezekias Mastaki
 * */
public class Misura {

	private long dt;

	private String dttxt;

	private int humidity;
	private	Temperatura tAttuale;
	private	Temperatura tPercepita; 
	private	Temperatura tMax;
	private	Temperatura tMin;
	private	Weather weather;

	
	public Misura(long dt, String dttxt, int humidity, Temperatura tAttuale, Temperatura tPercepita, Temperatura tMax, Temperatura tMin, Weather weather) {
		this.dt = dt;
		this.dttxt=dttxt;

		this.humidity = humidity;
		this.tAttuale = tAttuale;
		this.tPercepita = tPercepita;
		this.tMax = tMax;
		this.tMin = tMin;
		this.weather = weather;
	}

/**
 * Il metodo restituisce il date time in codice UTC
 * @return dt
 */
	public long getDt() {
		return dt;
	}
/**
 * Il metodo restituisce l'umidita'
 * @return umidità
 */
	public int getHumidity() {
		return humidity;
	}
/**
 * Il metodo restituisce la temperatura effettiva
 * @return temperatura effettiva
 */
	public Temperatura gettAttuale() {
		return tAttuale;
	}
/**
 * Il metodo restituisce la temperatura percepita
 * @return temperatura percepita
 */
	public Temperatura gettPercepita() {
		return tPercepita;
	}
/**
 * Il metodo restituisce la temperatura massima
 * @return temperatura massima
 */
	public Temperatura gettMax() {
		return tMax;
	}
/**
 * Il metodo restituisce la temperatura minima
 * @return temperatura minima
 */
	public Temperatura gettMin() {
		return tMin;
	}
/**
 * Il metodo restituisce un oggetto di tipo weather rappresentante il meteo atmosferico 
 * @return weather
 */
	public Weather getWeather() {
		return weather;
	}
/**
 * Il metodo restituisce una stringa che rappresenta la data
 * @return dttxt
 */
	public String getDatetxt() {
	    return dttxt;
	}
}

