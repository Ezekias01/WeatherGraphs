package com.example.demo.springboot.application.exceptions;
/**
 * La classe NotFoundObjectException estende dalla superclasse Exception
 * e gestisce il caso in cui la città inserita dall'utente non e'
 * presente tra quelle disponibili.
 * 
 * @author Andrea Pizzuto
 * @author Ezekias Mastaki
 */
public class NotFoundCityException extends Exception{
	
	private static final long serialVersionUID = 1L;
	private String errore;
	public NotFoundCityException() {
		super();
		this.errore="sconosciuto";
	}
	
	public NotFoundCityException(String errore) {
		super(errore);
		this.errore=errore;
	}
	
	public String getErrore() {return errore;}
	
}