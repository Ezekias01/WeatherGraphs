package com.example.demo.springboot.application.model;

public class Weather {
	private int idW;
	private String main;
	private String description;
	public Weather(int idW,String main, String description) {
		this.idW=idW;
		this.main=main;
		this.description=description;
	}
	public int getIdW() {
		return idW;
	}
	
	public String getMain() {
		return main;
	}
	
	public String getDescription() {
		return description;
	}
	
	
}