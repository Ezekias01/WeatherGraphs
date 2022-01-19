package com.example.demo.springboot.application.filter_stats;
import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.example.demo.springboot.application.model.Citta;
import com.example.demo.springboot.application.exceptions.IllegalTimeSlotException;

/**
 * L'interfaccia Stats prevede sei metodi astratti implementati in StatsImpl.
 * I suddetti metodi hanno il compito di calcolare le varie statistiche passando come unici attributi
 * un oggetto di tipo Filtro e un oggetto di tipo Citta.
 * 
 * @author Andrea Pizzuto
 * @author Ezekias Mastaki
 */
@Component
public interface Stats {
	
	public double tempMediaEff(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException;
	
	public double tempMediaPer(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException;

	public double umiditaMedia(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException;

	public ArrayList<Double> serieTempMax(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException;
	
	public double tempMinMedia(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException;
	
	public double tempMaxMedia(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException;
	
	public double varTempEff(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException;
	
	public double varTempPer(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException;

	public double varUmidita(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException;
	
	public double varTempMin(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException;
	
	public double varTempMax(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException;
	
	public double devstdTempEff(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException;

	public double devstdUmidita(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException;

	
}

