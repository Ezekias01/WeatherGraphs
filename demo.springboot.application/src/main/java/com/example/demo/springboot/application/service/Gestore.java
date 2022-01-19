package com.example.demo.springboot.application.service;
import java.util.ArrayList;

import org.json.*;
import org.springframework.stereotype.Component;

import com.example.demo.springboot.application.model.Citta;
import com.example.demo.springboot.application.exceptions.NotFoundCityException;
/**
 * L'interfaccia Gestore prevede cinque metodi astratti implementati in GestoreImpl.
 * @author Andrea Pizzuto
 * @author Ezekias Mastaki
 */
@Component
public interface Gestore {
	
	public ArrayList<Citta> getElencoCitta();
	
	public void setList();
	
	public Citta parseCitta(JSONObject ci) throws JSONException;
	
	public Citta cercaCitta(String nome) throws NotFoundCityException;
	
	public Citta cercaCitta(int id) throws NotFoundCityException;
}
