package com.example.demo.springboot.application.filter_stats;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.demo.springboot.application.model.Citta;
import com.example.demo.springboot.application.exceptions.IllegalTimeSlotException;

@Component
@Qualifier("StatsImpl")
public class StatsImpl implements Stats {
	
	public double tempMedia(Filter filtro, Citta citta) throws IllegalTimeSlotException  {		
		double sommaTemp=0;
		double temp; 
		int cont=0;
	
		try {
			for(int i=0; i<filtro.Ricerca(citta).size(); i++) {
				temp = filtro.Ricerca(citta).get(i).gettAttuale().getValore();
				sommaTemp += temp;
				cont++;
			}
			return sommaTemp/cont;
		}
		catch(IllegalTimeSlotException e) {
			throw new IllegalTimeSlotException();
		}
	}
	
	public double tempMaxMedia(Filter filtro, Citta citta) throws IllegalTimeSlotException {
		double sommaTemp=0;
		double temp; 
		int cont=0;
	
		try {
			for(int i=0; i<filtro.Ricerca(citta).size(); i++) {
				temp = filtro.Ricerca(citta).get(i).gettMax().getValore();
				sommaTemp += temp;
				cont++;
			}
			return sommaTemp/cont;
		}
		catch(IllegalTimeSlotException e) {
			throw new IllegalTimeSlotException();
		}
	}
	
	public double tempMinMedia(Filter filtro, Citta citta) throws IllegalTimeSlotException {
		double sommaTemp=0;
		double temp; 
		int cont=0;
	
		try {
			for(int i=0; i<filtro.Ricerca(citta).size(); i++) {
				temp = filtro.Ricerca(citta).get(i).gettMin().getValore();
				sommaTemp += temp;
				cont++;
			}
			return sommaTemp/cont;
		}
		catch(IllegalTimeSlotException e) {
			throw new IllegalTimeSlotException();
		}
	}
	
	public double varTemp(Filter filtro, Citta citta) throws IllegalTimeSlotException{
		double sommaTemp=0;
		double temp; 
		int cont=0;
		double mediaTemp=0;
		double num=0;
		double den=0;
		double varTemp;
		try {
			for(int i=0; i<filtro.Ricerca(citta).size(); i++) {
				temp = filtro.Ricerca(citta).get(i).gettAttuale().getValore();
				sommaTemp += temp;
				cont++;
			}
			mediaTemp = sommaTemp/cont;
			for(int i=0; i<filtro.Ricerca(citta).size(); i++) {
				num += Math.pow((filtro.Ricerca(citta).get(i).gettAttuale().getValore())-mediaTemp, 2);
				den = i-1;				
			}
			varTemp = num/den;
			return varTemp;
		}
		catch(IllegalTimeSlotException e) {
			throw new IllegalTimeSlotException();
		}
	}
	
	public double varUmidita(Filter filtro, Citta citta) throws IllegalTimeSlotException{
		double sommaUmidita=0, mediaUmidita=0, num=0, umidita, varUmidita;
		int cont=0;
		
		try {
			for(int i=0; i<filtro.Ricerca(citta).size(); i++) {
				umidita = filtro.Ricerca(citta).get(i).getHumidity();
				sommaUmidita += umidita;
				cont++;
			}
			mediaUmidita = sommaUmidita/cont;
			cont =0;
			for(int i=0; i<filtro.Ricerca(citta).size(); i++) {
				num += Math.pow((filtro.Ricerca(citta).get(i).getHumidity())-mediaUmidita, 2);
				cont++;				
			}
			varUmidita = num/cont-1;
			return varUmidita;
		}
		catch(IllegalTimeSlotException e) {
			throw new IllegalTimeSlotException();
		}
	}
	
	public double varTempEff(Filter filtro, Citta citta) throws IllegalTimeSlotException{
		double sommaTempEff=0;
		double tempEff; 
		int cont=0;
		double mediaTempEff=0;
		double num=0;
		double den=0;
		double varTempEff;
		try {
			for(int i=0; i<filtro.Ricerca(citta).size(); i++) {
				tempEff = filtro.Ricerca(citta).get(i).gettPercepita().getValore();
				sommaTempEff += tempEff;
				cont++;
			}
			mediaTempEff = sommaTempEff/cont;
			for(int i=0; i<filtro.Ricerca(citta).size(); i++) {
				num += Math.pow((filtro.Ricerca(citta).get(i).gettPercepita().getValore())-mediaTempEff, 2);
				den = i-1;				
			}
			varTempEff = num/den;
			return varTempEff;
		}
		catch(IllegalTimeSlotException e) {
			throw new IllegalTimeSlotException();
		}
	}
}