package com.example.demo.springboot.application.model;

import java.text.SimpleDateFormat;

public class Misura {

	private long dt;
	private int humidity;
	private	Temperatura tAttuale;
	private	Temperatura tPercepita; 
	private	Temperatura tMax;
	private	Temperatura tMin;
	private	Weather weather;
	private SimpleDateFormat sdf;
	private String datetxt;

	public Misura(long dt, int humidity, Temperatura tAttuale, Temperatura tPercepita, Temperatura tMax, Temperatura tMin, Weather weather) {
		this.dt = dt;
		this.humidity = humidity;
		this.tAttuale = tAttuale;
		this.tPercepita = tPercepita;
		this.tMax = tMax;
		this.tMin = tMin;
		this.weather = weather;
		this.sdf = new SimpleDateFormat("MMMM d, yyyy 'at' h:m a");
	    this.datetxt = sdf.format(this.dt*1000L );
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
