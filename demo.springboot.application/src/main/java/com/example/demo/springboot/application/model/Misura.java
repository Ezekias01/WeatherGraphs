package com.example.demo.springboot.application.model;

public class Misura {

	private long dt;
	private int humidity;
	private	Temperatura tAttuale;
	private	Temperatura tPercepita; 
	private	Temperatura tMax;
	private	Temperatura tMin;
	private	Weather weather;
	private String datetxt;

	public Misura(long dt, String dttxt, int humidity, Temperatura tAttuale, Temperatura tPercepita, Temperatura tMax, Temperatura tMin, Weather weather) {
		this.dt = dt;
		this.datetxt=dttxt;
		this.humidity = humidity;
		this.tAttuale = tAttuale;
		this.tPercepita = tPercepita;
		this.tMax = tMax;
		this.tMin = tMin;
		this.weather = weather;
	}

	public long getDt() {
		return dt;
	}

	public int getHumidity() {
		return humidity;
	}

	public Temperatura gettAttuale() {
		return tAttuale;
	}

	public Temperatura gettPercepita() {
		return tPercepita;
	}

	public Temperatura gettMax() {
		return tMax;
	}

	public Temperatura gettMin() {
		return tMin;
	}

	public Weather getWeather() {
		return weather;
	}
	
	public String getDatetxt() {
	    return datetxt;
	}
}