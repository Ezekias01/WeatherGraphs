package com.example.demo.springboot.application.filter_stats;

import java.util.ArrayList;

import com.example.demo.springboot.application.exceptions.IllegalTimeSlotException;
import com.example.demo.springboot.application.model.Citta;
import com.example.demo.springboot.application.model.Misura;
/**
 * L'interfaccia Filter prevede due metodi astratti implementati in FilterImpl.
 * I suddetti metodi si occupano di costruire il range temporale nel quale
 * procedere con la ricerca e di effettuarla.
 * La Ricerca, sfruttando il metodo Range, restituirà un ArrayList di misure
 * il cui attributo dt corrisponde al range temporale indicato dall'utente.
 * @author Andrea Pizzuto
 * @author Ezekias Mastaki
 *
 */
public interface Filter {
	
	public ArrayList<Long> Range() throws IllegalTimeSlotException;
	
	public ArrayList<Misura> Ricerca(Citta citta) throws IllegalTimeSlotException;
}
