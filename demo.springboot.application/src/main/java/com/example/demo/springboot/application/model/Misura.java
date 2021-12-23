package com.example.demo.springboot.application.model;

public class Misura {
	private Weather w;
	private Temperatura tAttuale;
	private Temperatura tPercepita;
	private Temperatura tMax;
	private Temperatura tMin;
	private long data;
	
	public Misura(Weather w, Temperatura tAttuale, Temperatura tPercepita, Temperatura tMax, Temperatura tMin) {
		this.w = w;
		this.tAttuale = tAttuale;
		this.tPercepita = tPercepita;
		this.tMax = tMax;
		this.tMin = tMin;
	}
	
	public Weather getWeather() {
		return w;
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
	
	public long data() {
		return data;
	}
	
	//get data2
}
