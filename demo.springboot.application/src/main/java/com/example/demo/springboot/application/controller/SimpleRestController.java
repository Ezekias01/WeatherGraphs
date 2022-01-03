package com.example.demo.springboot.application.controller;

import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.springboot.application.model.Citta;
import com.example.demo.springboot.application.model.Misura;
import com.example.demo.springboot.application.model.Temperatura;
import com.example.demo.springboot.application.model.Weather;
import com.example.demo.springboot.application.service.Gestore;
import com.example.demo.springboot.application.service.GestoreImpl;
import com.example.demo.springboot.application.filters.Filter;

@RestController //importazione della dipendenza
public class SimpleRestController {
	@Autowired
	Gestore gestore;

	@RequestMapping(value="/citta") 
	public ResponseEntity<Object> getCitta() {
		//gestore.setList();
		ArrayList<String> nomi = new ArrayList<String>();
		for(int i=0; i<gestore.getElencoCitta().size();i++) { 
			nomi.add(gestore.getElencoCitta().get(i).getNomeCity());
		}
		return new ResponseEntity<>(nomi,HttpStatus.OK);
		//ResponseStatusException(HttpStatus.BAD_REQUEST,"ERRORE: NIENTE LISTA DI CITTA "); }	}
	}

	
	@RequestMapping(value="/index") 
	public ResponseEntity<Object> getIndex() {
		String output = "Giovedi=1\n Venerdi=2\n Sabato=3\n Domenica=4\n "; 
		return new ResponseEntity<>(output,HttpStatus.OK);
	}
	
	@RequestMapping(value="/filter") 
	public ResponseEntity<Object> Filter() {
		Filter filtro = new Filter(1,4,1); //chiedere all'utente i tre parametri per filter
		Citta citta = gestore.getElencoCitta().get(1);
		return new ResponseEntity<>(filtro.Ricerca(citta),HttpStatus.OK);
	}
	/*
	@RequestMapping(value="/stats") 
	public ResponseEntity<Object> Stats() {
		Filter filtro = new Filter(1,1,1); //chiedere all'utente i tre parametri per filter
		Citta citta = gestore.getElencoCitta().get(1); //chiedere all'utente la citta
		ArrayList<Long> range = new ArrayList<Long>();
		range = filtro.Range();
		double tempMedia;
		ArrayList <Misura> misure = new ArrayList <Misura>();
		misure = filtro.Ricerca(citta);
		for(int i=0; i<misure.size(); i++) {
			tempMedia = misure.get(i).gettAttuale();
			
		}
		
		return new ResponseEntity<>(range,HttpStatus.OK);
	}
	*/
}

