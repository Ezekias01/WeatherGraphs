package com.example.demo.springboot.application.service;
import org.json.*;

import com.example.demo.springboot.application.model.Citta;


public interface Gestore {
	public StringBuffer Avvio(String collegamento);
	
	public Citta ottieniCitta(StringBuffer x);

	public void ToString(Citta Citta);
}
