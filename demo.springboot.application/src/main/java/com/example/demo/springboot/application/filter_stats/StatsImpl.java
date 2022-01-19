package com.example.demo.springboot.application.filter_stats;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.demo.springboot.application.model.Citta;
import com.example.demo.springboot.application.exceptions.IllegalTimeSlotException;

/**
 * La classe StatsImpl specifica i metodi descritti dall'interfaccia Stats.
 * @author Andrea Pizzuto
 * @author Ezekias Mastaki
 *
 */
@Component
@Qualifier("StatsImpl")
public class StatsImpl implements Stats {
/**
 * Il metodo tempMediaEff, dato un range temporale filtrato e una citta, restiruisce la media delle temperature
 * effettive.
 * Il metodo lancia due eccezioni che gestiscono rispettivamente il caso in cui i codici della fascia oraria
 * siano errati e tutti i possibili errori matematici.
 * @param filtro
 * @param citta
 * @return media delle temperature effettive
 * @throws IllegalTimeSlotException
 * @throws ArithmeticException
 */
	public double tempMediaEff(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException  {		

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

		catch(ArithmeticException a) {
			throw new ArithmeticException();
		}
	}
/**	
 * Il metodo tempMediaPer, dato un range temporale filtrato e una citta, restiruisce la media delle temperature
 * percepite.
 * Il metodo lancia due eccezioni che gestiscono rispettivamente il caso in cui i codici della fascia oraria
 * siano errati e tutti i possibili errori matematici.
 * @param filtro
 * @param citta
 * @throws IllegalTimeSlotException
 * @throws ArithmeticException
 * @return media delle temperature percepite
 */
	public double tempMediaPer(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException  {		
		double sommaTempPer=0;
		double temp; 
		int cont=0;
	
		try {
			for(int i=0; i<filtro.Ricerca(citta).size(); i++) {
				temp = filtro.Ricerca(citta).get(i).gettPercepita().getValore();
				sommaTempPer += temp;
				cont++;
			}
			return sommaTempPer/cont;
		}
		catch(IllegalTimeSlotException e) {
			throw new IllegalTimeSlotException();
		}
		catch(ArithmeticException a) {
			throw new ArithmeticException();
		}
	}
/**	
 * Il metodo umiditaMedia, dato un range temporale filtrato e una città, restiruisce la media dei dati relativi
 * all'umidita.
 * Il metodo lancia due eccezioni che gestiscono rispettivamente il caso in cui i codici della fascia oraria
 * siano errati e tutti i possibili errori matematici.
 * @param filtro
 * @param citta
 * @throws IllegalTimeSlotException
 * @throws ArithmeticException
 * @return media dell'umidità
 */
	public double umiditaMedia(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException {
		double sommaUmidita=0;
		double umidita; 
		int cont=0;
	
		try {
			for(int i=0; i<filtro.Ricerca(citta).size(); i++) {
				umidita = filtro.Ricerca(citta).get(i).getHumidity();
				sommaUmidita += umidita;
				cont++;
			}
			return sommaUmidita/cont;
		}
		catch(IllegalTimeSlotException e) {
			throw new IllegalTimeSlotException();
		}
		catch(ArithmeticException a) {
			throw new ArithmeticException();
		}
	}
/**	
 * Il metodo serieTempMax, dato un range temporale filtrato e una citta, restiruisce tutte le temperature
 * massime.
 * Il metodo lancia due eccezioni che gestiscono rispettivamente il caso in cui i codici della fascia oraria
 * siano errati e tutti i possibili errori matematici.
 * @param filtro
 * @param citta
 * @throws IllegalTimeSlotException
 * @throws ArithmeticException
 * @return serieMassime
 */
	
	public ArrayList<Double> serieTempMax(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException {
		ArrayList<Double> serieMassime=new ArrayList<Double>();

		try {
			for(int i=0; i<filtro.Ricerca(citta).size(); i++) {
				serieMassime.add(filtro.Ricerca(citta).get(i).gettMax().getValore());
			}
			return serieMassime;
		}
		catch(IllegalTimeSlotException e) {
			throw new IllegalTimeSlotException();
		}

		catch(ArithmeticException a) {
			throw new ArithmeticException();
		}
	}
/**	
 * Il metodo tempMinMedia, dato un range temporale filtrato e una citta, restiruisce la media delle 
 * temperature minime effettive.
 * Il metodo lancia due eccezioni che gestiscono rispettivamente il caso in cui i codici della fascia oraria
 * siano errati e tutti i possibili errori matematici.
 * @param filtro
 * @param citta
 * @throws IllegalTimeSlotException
 * @throws ArithmeticException
 * @return media delle temperature minime effettive
 */	
	public double tempMinMedia(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException {
		double sommaTempMin=0;

		double temp; 
		int cont=0;
	
		try {
			for(int i=0; i<filtro.Ricerca(citta).size(); i++) {
				temp = filtro.Ricerca(citta).get(i).gettMin().getValore();

				sommaTempMin += temp;
				cont++;
			}
			return sommaTempMin/cont;

		}
		catch(IllegalTimeSlotException e) {
			throw new IllegalTimeSlotException();
		}

		catch(ArithmeticException a) {
			throw new ArithmeticException();
		}
	}
/**	
 * Il metodo tempMaxMedia, dato un range temporale filtrato e una citta, restiruisce la media delle 
 * temperature massime effettive.
 * Il metodo lancia due eccezioni che gestiscono rispettivamente il caso in cui i codici della fascia oraria
 * siano errati e tutti i possibili errori matematici.
 * @param filtro
 * @param citta
 * @throws IllegalTimeSlotException
 * @throws ArithmeticException
 * @return media delle temperature massime effettive
 */
	public double tempMaxMedia(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException {
		double sommaTempMax=0;
		double temp; 
		int cont=0;
	
		try {
			for(int i=0; i<filtro.Ricerca(citta).size(); i++) {
				temp = filtro.Ricerca(citta).get(i).gettMax().getValore();
				sommaTempMax += temp;
				cont++;
			}
			return sommaTempMax/cont;
		}
		catch(IllegalTimeSlotException e) {
			throw new IllegalTimeSlotException();
		}
		catch(ArithmeticException a) {
			throw new ArithmeticException();
		}
	}
/**	
 * Il metodo varTempEff, dato un range temporale filtrato e una citta, restiruisce la varianza delle 
 * temperature effettive.
 * Il metodo lancia due eccezioni che gestiscono rispettivamente il caso in cui i codici della fascia oraria
 * siano errati e tutti i possibili errori matematici.
 * @param filtro
 * @param citta
 * @throws IllegalTimeSlotException
 * @throws ArithmeticException
 * @return varianza temperature effettive
 */	
	public double varTempEff(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException{
		int cont=0;
		double mediaTempEff=0;
		double num=0;
		double varTempEff;
		try {
			mediaTempEff = this.tempMediaEff(filtro, citta);
			for(int i=0; i<filtro.Ricerca(citta).size(); i++) {
				num += Math.pow((filtro.Ricerca(citta).get(i).gettAttuale().getValore())-mediaTempEff, 2);
				cont++;				
			}
			varTempEff = num/cont-1;
			return varTempEff;

		}
		catch(IllegalTimeSlotException e) {
			throw new IllegalTimeSlotException();
		}

		catch(ArithmeticException a) {
			throw new ArithmeticException();
		}
	}
/**	
 * Il metodo varTempPer, dato un range temporale filtrato e una citta, restiruisce la varianza delle 
 * temperature percepite.
 * Il metodo lancia due eccezioni che gestiscono rispettivamente il caso in cui i codici della fascia oraria
 * siano errati e tutti i possibili errori matematici.
 * @param filtro
 * @param citta
 * @throws IllegalTimeSlotException
 * @throws ArithmeticException
 * @return varianza temperature percepite
 */	
	public double varTempPer(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException{
		int cont=0;
		double mediaTempPer=0;
		double num=0;
		double varTempPer;
		try {
			mediaTempPer = this.tempMediaPer(filtro, citta);
			for(int i=0; i<filtro.Ricerca(citta).size(); i++) {
				num += Math.pow((filtro.Ricerca(citta).get(i).gettPercepita().getValore())-mediaTempPer, 2);
				cont++;				
			}
			varTempPer = num/cont-1;
			return varTempPer;
		}
		catch(IllegalTimeSlotException e) {
			throw new IllegalTimeSlotException();
		}
		catch(ArithmeticException a) {
			throw new ArithmeticException();
		}
	}
/**	
 * Il metodo varUmidita, dato un range temporale filtrato e una citta, restiruisce la varianza
 * dell'umidita'.
 * Il metodo lancia due eccezioni che gestiscono rispettivamente il caso in cui i codici della fascia oraria
 * siano errati e tutti i possibili errori matematici.
 * @param filtro 
 * @param citta
 * @throws IllegalTimeSlotException
 * @throws ArithmeticException
 * @return varianza umidità
 */	
	public double varUmidita(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException{
		double mediaUmidita=0, num=0, varUmidita;
		int cont=0;
		
		try {
			mediaUmidita = this.umiditaMedia(filtro, citta);

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

		catch(ArithmeticException a) {
			throw new ArithmeticException();
		}
	}
/**	
 * Il metodo varTempMin, dato un range temporale filtrato e una citta, restiruisce la varianza
 * delle temperature minime.
 * Il metodo lancia due eccezioni che gestiscono rispettivamente il caso in cui i codici della fascia oraria
 * siano errati e tutti i possibili errori matematici.
 * @param filtro
 * @param citta
 * @throws IllegalTimeSlotException
 * @throws ArithmeticException	
 * @return varianza temperature minime
 */
	public double varTempMin(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException{
		int cont=0;
		double mediaTempMin=0;
		double num=0;
		double varTempMin;
		try {
			mediaTempMin = this.tempMinMedia(filtro, citta);
			for(int i=0; i<filtro.Ricerca(citta).size(); i++) {
				num += Math.pow((filtro.Ricerca(citta).get(i).gettPercepita().getValore())-mediaTempMin, 2);
				cont++;				
			}
			varTempMin = num/cont-1;
			return varTempMin;
		}
		catch(IllegalTimeSlotException e) {
			throw new IllegalTimeSlotException();
		}
		catch(ArithmeticException a) {
			throw new ArithmeticException();
		}
	}
/**
 * Il metodo varTempMax, dato un range temporale filtrato e una citta, restiruisce la varianza
 * delle temperature massime.
 * Il metodo lancia due eccezioni che gestiscono rispettivamente il caso in cui i codici della fascia oraria
 * siano errati e tutti i possibili errori matematici.
 * @param filtro
 * @param citta
 * @throws IllegalTimeSlotException
 * @throws ArithmeticException
 * @return varianza temperature massime
 */
	public double varTempMax(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException{
		int cont=0;
		double mediaTempMax=0;
		double num=0;
		double varTempMax;
		try {
			mediaTempMax = this.tempMaxMedia(filtro, citta);
			for(int i=0; i<filtro.Ricerca(citta).size(); i++) {
				num += Math.pow((filtro.Ricerca(citta).get(i).gettPercepita().getValore())-mediaTempMax, 2);
				cont++;				
			}
			varTempMax = num/cont-1;
			return varTempMax;

		}
		catch(IllegalTimeSlotException e) {
			throw new IllegalTimeSlotException();
		}

		catch(ArithmeticException a) {
			throw new ArithmeticException();
		}
	}
/**
 * Il metodo varTempMax, dato un range temporale filtrato e una citta, restiruisce la deviazione
 * standard delle temperature effettive.
 * Il metodo lancia due eccezioni che gestiscono rispettivamente il caso in cui i codici della fascia oraria
 * siano errati e tutti i possibili errori matematici.
 * @param filtro
 * @param citta
 * @throws IllegalTimeSlotException
 * @throws ArithmeticException
 * @return deviazione standard delle temperature effettive
 */

	public double devstdTempEff(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException {
		double devstdTempEff=0;
		devstdTempEff = Math.sqrt(this.varTempEff(filtro, citta));
		return devstdTempEff;
	}
/**
 * Il metodo devstdUmidita, dato un range temporale filtrato e una citta, restiruisce la deviazione
 * standard considerando i dati relativi all'umidita'.
 * Il metodo lancia due eccezioni che gestiscono rispettivamente il caso in cui i codici della fascia oraria
 * siano errati e tutti i possibili errori matematici.
 * @param filtro
 * @param citta
 * @throws IllegalTimeSlotException
 * @throws ArithmeticException
 * @return deviazione standard dell'umidita'
 */
	public double devstdUmidita(FilterImpl filtro, Citta citta) throws IllegalTimeSlotException, ArithmeticException {
		double devstdUmidita=0;
		devstdUmidita = Math.sqrt(this.varUmidita(filtro, citta));
		return devstdUmidita;
	}
}
