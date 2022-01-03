package com.example.demo.springboot.application.filters_stats;
import java.util.*;

import com.example.demo.springboot.application.model.Citta;
import com.example.demo.springboot.application.model.Misura;

public class Filter  {
	private int codDataInizio;
	private int codDataFine;
	private int codFasciaOraria;


	public Filter(int codDataInizio, int codDataFine, int codFasciaOraria) {
		this.codDataInizio=codDataInizio;
		this.codDataFine=codDataFine;
		this.codFasciaOraria=codFasciaOraria;
	}
	
	public ArrayList<Long> Range() { //restuire il range
		ArrayList<Long> Range = new ArrayList<Long>();
		if(codDataInizio<=codDataFine) /*valutare di creare una exception apposta*/ {
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
							Range.add((long)1640498400);
							Range.add((long)1640509200);
							break;
						}
						if(codFasciaOraria==2) {
							Range.add((long)1640260800); 
							Range.add((long)1640271600);
							Range.add((long)1640347200);
							Range.add((long)1640358000);
							Range.add((long)1640520000);
							Range.add((long)1640530800);
							break;
						}
						if(codFasciaOraria==3) {
							Range.add((long)1640282400);
							Range.add((long)1640293200);
							Range.add((long)1640368800);
							Range.add((long)1640379600);
							Range.add((long)1640541600);
							Range.add((long)1640552400);
							break;
						}				
					}
					else if(codDataFine==4) {
						if(codFasciaOraria==1) {
							Range.add((long)1640239200);
							Range.add((long)1640250000);
							Range.add((long)1640325600);
							Range.add((long)1640336400);
							Range.add((long)1640498400);
							Range.add((long)1640509200);
							Range.add((long)1640498400);
							Range.add((long)1640509200);
							break;
						}
						if(codFasciaOraria==2) {
							Range.add((long)1640282400);
							Range.add((long)1640293200);
							Range.add((long)1640368800);
							Range.add((long)1640379600);
							Range.add((long)1640541600);
							Range.add((long)1640552400);
							Range.add((long)1640520000);
							Range.add((long)1640530800);
							break;
						}
						if(codFasciaOraria==3) {
							Range.add((long)1640282400);
							Range.add((long)1640293200);
							Range.add((long)1640368800);
							Range.add((long)1640379600);
							Range.add((long)1640541600);
							Range.add((long)1640552400);
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
							Range.add((long)1640498400);
							Range.add((long)1640509200);
							break;
						}
						if(codFasciaOraria==2) {
							Range.add((long)1640347200);
							Range.add((long)1640358000);
							Range.add((long)1640520000);
							Range.add((long)1640530800);
							break;
						}
						if(codFasciaOraria==3) {
							Range.add((long)1640368800);
							Range.add((long)1640379600);
							Range.add((long)1640541600);
							Range.add((long)1640552400);
							break;
						}				
					}
					else if(codDataFine==4) {
						if(codFasciaOraria==1) {
							Range.add((long)1640325600);
							Range.add((long)1640336400);
							Range.add((long)1640498400);
							Range.add((long)1640509200);
							Range.add((long)1640498400);
							Range.add((long)1640509200);
							break;
						}
						if(codFasciaOraria==2) {
							Range.add((long)1640347200);
							Range.add((long)1640358000);
							Range.add((long)1640520000);
							Range.add((long)1640530800);
							Range.add((long)1640520000);
							Range.add((long)1640530800);
							break;
						}
						if(codFasciaOraria==3) {
							Range.add((long)1640368800);
							Range.add((long)1640379600);
							Range.add((long)1640541600);
							Range.add((long)1640552400);
							Range.add((long)1640541600);
							Range.add((long)1640552400);
							break;
						}
					}
					break;
				case 3:
					if(codDataFine==3) {
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
					}
					else if(codDataFine==4) {
						if(codFasciaOraria==1) {
							Range.add((long)1640498400);
							Range.add((long)1640509200);
							Range.add((long)1640498400);
							Range.add((long)1640509200);
							break;
						}
						if(codFasciaOraria==2) {
							Range.add((long)1640520000);
							Range.add((long)1640530800);
							Range.add((long)1640520000);
							Range.add((long)1640530800);
							break;
						}
						if(codFasciaOraria==3) {
							Range.add((long)1640541600);
							Range.add((long)1640552400);
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
	return null;		
	}
	
	public ArrayList<Misura> Ricerca(Citta citta) {
		ArrayList<Misura> misure = new ArrayList<Misura>();
		for(int i=0; i<this.Range().size(); i++) {
			for(int y=0; y<citta.getMisura().size(); y++) {
				if (this.Range().get(i)==citta.getMisura().get(y).getDt()) {
					Misura m = citta.getMisura().get(y);
					misure.add(m);
				}
			}
		}
		return misure;
	}
	
	
}
