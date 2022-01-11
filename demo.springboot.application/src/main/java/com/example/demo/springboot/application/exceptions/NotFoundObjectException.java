package com.example.demo.springboot.application.exceptions;

public class NotFoundObjectException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errore;
	public NotFoundObjectException() {
		super();
		this.errore="sconosciuto";
	}
	
	public NotFoundObjectException(String errore) {
		super(errore);
		this.errore=errore;
	}
	
	public String getErrore() {return errore;}
	
}