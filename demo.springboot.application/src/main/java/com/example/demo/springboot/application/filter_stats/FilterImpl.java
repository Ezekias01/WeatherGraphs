package com.example.demo.springboot.application.filter_stats;
import java.util.*;

import com.example.demo.springboot.application.exceptions.IllegalTimeSlotException;
import com.example.demo.springboot.application.model.Citta;
import com.example.demo.springboot.application.model.Misura;
/**
 * La classe FilterImpl specifica i metodi descritti dall'interfaccia Filter.
 * E' caratterizzata da tre attributi di tipo intero che indicano la codifica per
 * data di inizio, la data di fine e la fascia oraria indicate dall'utente.
 * @author Ezekias Mastaki
 * @author Andrea Pizzuto
 */
public class FilterImpl  {
	private int codDataInizio;
	private int codDataFine;
	private int codFasciaOraria;


	public FilterImpl(int codDataInizio, int codDataFine, int codFasciaOraria) {
		this.codDataInizio=codDataInizio;
		this.codDataFine=codDataFine;
		this.codFasciaOraria=codFasciaOraria;
	}
/**
 * Il metodo Range, dopo aver verificato la correttezza dei codici, costruisce un ArrayList
 * di long contenente le date in formato UTC corrispondenti alla richiesta dell'utente e lo restituisce.
 * Ove fossero presenti errori nell'inserimento dei codici, verrebbe lanciata l'eccezione customizzata
 * IllegalTimeSlotException.
 * @return Range
 * @throws IllegalTimeSlotException
 */
	public ArrayList<Long> Range() throws IllegalTimeSlotException { //restuire il range
		ArrayList<Long> Range = new ArrayList<Long>();
		if((codDataInizio==1||codDataInizio==2||codDataInizio==3||codDataInizio==4)&&
		    (codDataFine==1||codDataFine==2||codDataFine==3||codDataFine==4)&&
		    (codFasciaOraria==1||codFasciaOraria==2||codFasciaOraria==3)) {
			if(codDataInizio<=codDataFine) {
				switch(codDataInizio) {
					case 1: 
						if(codDataFine==1) {
							if(codFasciaOraria==1) {
								Range.add((long)1640239200);
								Range.add((long)1640250000);
								break;
							}
							if(codFasciaOraria==2) {
								Range.add((long)1640260800); 
								Range.add((long)1640271600);
								break;
							}
							if(codFasciaOraria==3) {
								Range.add((long)1640282400);
								Range.add((long)1640293200);
								break;
							}
						}
						else if(codDataFine==2) {
							if(codFasciaOraria==1) {
								Range.add((long)1640239200);
								Range.add((long)1640250000);
								Range.add((long)1640325600);
								Range.add((long)1640336400);
								break;
							}
							if(codFasciaOraria==2) {
								Range.add((long)1640260800); 
								Range.add((long)1640271600);
								Range.add((long)1640347200);
								Range.add((long)1640358000);
								break;
							}
							if(codFasciaOraria==3) {
								Range.add((long)1640282400);
								Range.add((long)1640293200);
								Range.add((long)1640368800);
								Range.add((long)1640379600);
								break;
							}
						}
						else if(codDataFine==3) {
							if(codFasciaOraria==1) {
								Range.add((long)1640239200);
								Range.add((long)1640250000);
								Range.add((long)1640325600);
								Range.add((long)1640336400);
								Range.add((long)1640412000);
								Range.add((long)1640422800);
								break;
							}
							if(codFasciaOraria==2) {
								Range.add((long)1640260800); 
								Range.add((long)1640271600);
								Range.add((long)1640347200);
								Range.add((long)1640358000);
								Range.add((long)1640433600);
								Range.add((long)1640444400);
								break;
							}
							if(codFasciaOraria==3) {
								Range.add((long)1640282400);
								Range.add((long)1640293200);
								Range.add((long)1640368800);
								Range.add((long)1640379600);
								Range.add((long)1640455200);
								Range.add((long)1640466000);
								break;
							}				
						}
						else if(codDataFine==4) {
							if(codFasciaOraria==1) {
								Range.add((long)1640239200);
								Range.add((long)1640250000);
								Range.add((long)1640325600);
								Range.add((long)1640336400);
								Range.add((long)1640412000);
								Range.add((long)1640422800);
								Range.add((long)1640498400);
								Range.add((long)1640509200);
								break;
							}
							if(codFasciaOraria==2) {
								Range.add((long)1640282400);
								Range.add((long)1640293200);
								Range.add((long)1640368800);
								Range.add((long)1640379600);
								Range.add((long)1640433600);
								Range.add((long)1640444400);
								Range.add((long)1640520000);
								Range.add((long)1640530800);
								break;
							}
							if(codFasciaOraria==3) {
								Range.add((long)1640282400);
								Range.add((long)1640293200);
								Range.add((long)1640368800);
								Range.add((long)1640379600);
								Range.add((long)1640455200);
								Range.add((long)1640466000);
								Range.add((long)1640541600);
								Range.add((long)1640552400);
								break;
							}
						}
						
					case 2:
						if(codDataFine==2) {
							if(codFasciaOraria==1) {
								Range.add((long)1640325600);
								Range.add((long)1640336400);
								break;
							}
							if(codFasciaOraria==2) {
								Range.add((long)1640347200);
								Range.add((long)1640358000);
								break;
							}
							if(codFasciaOraria==3) {
								Range.add((long)1640368800);
								Range.add((long)1640379600);
								break;
							}
						}
						else if(codDataFine==3) {
							if(codFasciaOraria==1) {
								Range.add((long)1640325600);
								Range.add((long)1640336400);
								Range.add((long)1640412000);
								Range.add((long)1640422800);
								break;
							}
							if(codFasciaOraria==2) {
								Range.add((long)1640347200);
								Range.add((long)1640358000);
								Range.add((long)1640433600);
								Range.add((long)1640444400);
								break;
							}
							if(codFasciaOraria==3) {
								Range.add((long)1640368800);
								Range.add((long)1640379600);
								Range.add((long)1640455200);
								Range.add((long)1640466000);
								break;
							}				
						}
						else if(codDataFine==4) {
							if(codFasciaOraria==1) {
								Range.add((long)1640325600);
								Range.add((long)1640336400);
								Range.add((long)1640412000);
								Range.add((long)1640422800);
								Range.add((long)1640498400);
								Range.add((long)1640509200);
								break;
							}
							if(codFasciaOraria==2) {
								Range.add((long)1640347200);
								Range.add((long)1640358000);
								Range.add((long)1640433600);
								Range.add((long)1640444400);
								Range.add((long)1640520000);
								Range.add((long)1640530800);
								break;
							}
							if(codFasciaOraria==3) {
								Range.add((long)1640368800);
								Range.add((long)1640379600);
								Range.add((long)1640455200);
								Range.add((long)1640466000);
								Range.add((long)1640541600);
								Range.add((long)1640552400);
								break;
							}
						}
						break;
					case 3:
						if(codDataFine==3) {
							if(codFasciaOraria==1) {
								Range.add((long)1640412000);
								Range.add((long)1640422800);
								break;
							}
							if(codFasciaOraria==2) {
								Range.add((long)1640433600);
								Range.add((long)1640444400);
								break;
							}
							if(codFasciaOraria==3) {
								Range.add((long)1640455200);
								Range.add((long)1640466000);
								break;
							}				
						}
						else if(codDataFine==4) {
							if(codFasciaOraria==1) {
								Range.add((long)1640412000);
								Range.add((long)1640422800);
								Range.add((long)1640498400);
								Range.add((long)1640509200);
								break;
							}
							if(codFasciaOraria==2) {
								Range.add((long)1640433600);
								Range.add((long)1640444400);
								Range.add((long)1640520000);
								Range.add((long)1640530800);
								break;
							}
							if(codFasciaOraria==3) {
								Range.add((long)1640455200);
								Range.add((long)1640466000);
								Range.add((long)1640541600);
								Range.add((long)1640552400);
								break;
							}
						}
						break;
					case 4: 
						if(codFasciaOraria==1) {
							Range.add((long)1640498400);
							Range.add((long)1640509200);
							break;
						}
						if(codFasciaOraria==2) {
							Range.add((long)1640520000);
							Range.add((long)1640530800);
							break;
						}
						if(codFasciaOraria==3) {
							Range.add((long)1640541600);
							Range.add((long)1640552400);
							break;
						}
						break;
				}
				return Range;
			}
			else {
				String mex="IL CODICE DELLA DATA INIZIALE INSERITO ("+codDataInizio+") NON PUO' ESSERE MAGGIORE DEL CODICE  DELLA DATA FINALE INSERITO ("+codDataFine+")";	
				throw new IllegalTimeSlotException(mex); 
			}
		}
		else {
			String warning="INSERIMENTO DI UN VALORE DIVERSO DA QUELLI INDICATI DALLA CODIFICA DELLA FASCIA ORARIA";
			throw new IllegalTimeSlotException(warning);
		}
	
	}
/**
 * Il metodo Ricerca riceve un oggetto di tipo Citta e verifica che i date time 
 * dell'ArrayList Range corrispondano con quelli dell'ArrayList di misure della citta.
 * Se cio' si verifica, le misure vengono aggiunte ad un ArrayList precedentemente
 * creato come appoggio nel metodo ed infine restituite tramite esso. 
 * Il metodo lancia l'eccezione IllegalTimeSlotException nel caso in cui l'utente inserisca dei codici
 * non corretti.	
 * @param citta
 * @return ArrayList di misure
 * @throws IllegalTimeSlotException
 */
	public ArrayList<Misura> Ricerca(Citta citta) throws IllegalTimeSlotException {
		ArrayList<Misura> misure = new ArrayList<Misura>();
		try {
			for(int i=0; i<this.Range().size(); i++) {
				for(int y=0; y<citta.getMisura().size(); y++) {
					if (this.Range().get(i)==citta.getMisura().get(y).getDt()) {
						Misura m = citta.getMisura().get(y);
						misure.add(m);
					}
				}
			}
			return misure;
		} catch (IllegalTimeSlotException e) {
			throw new IllegalTimeSlotException();
			
		}
		
	}	
}
