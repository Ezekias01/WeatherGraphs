package com.example.demo.springboot.application.model;

public class Weather {
	private int idW;
	private String main;
	public Weather(int idW,String main) {
		this.idW=idW;
		this.main=main;
	}
	public int getIdW() {
		return idW;
	}
	
	public String getMain() {
		return main;
	}
	
	
	
	
}
