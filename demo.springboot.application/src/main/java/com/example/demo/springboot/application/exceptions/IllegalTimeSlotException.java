package com.example.demo.springboot.application.exceptions;

public class IllegalTimeSlotException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String errore;
	public IllegalTimeSlotException() {
		super();
		this.errore="ERRORE NEI CODICI DELLA FASCIA ORARIA";
	}
	
	public IllegalTimeSlotException(String errore) {
		super(errore);
		this.errore=errore;
	}
	
	public String getErrore() {return errore;}
	

}