package com.example.demo.springboot.application.filter_stats;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.demo.springboot.application.model.Citta;
import com.example.demo.springboot.application.exceptions.IllegalTimeSlotException;

@Component
public interface Stats {
	
	public double tempMedia(Filter filtro, Citta citta) throws IllegalTimeSlotException;
	
	ArrayList<Double> serieTempMax(Filter filtro, Citta citta) throws IllegalTimeSlotException;
	
	public double tempMinMedia(Filter filtro, Citta citta) throws IllegalTimeSlotException;
	
	public double varTemp(Filter filtro, Citta citta) throws IllegalTimeSlotException;
	
	public double varUmidita(Filter filtro, Citta citta) throws IllegalTimeSlotException;
	
	public double varTempEff(Filter filtro, Citta citta) throws IllegalTimeSlotException;
	
}