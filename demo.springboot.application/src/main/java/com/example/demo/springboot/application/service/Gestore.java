package com.example.demo.springboot.application.service;
import java.util.ArrayList;

import org.json.*;
import org.springframework.stereotype.Component;

import com.example.demo.springboot.application.model.Citta;

@Component
public interface Gestore {
	
	public ArrayList<Citta> getElencoCitta();
	
	public Citta parseCitta(JSONObject ci);

	public void setList();
	
}
