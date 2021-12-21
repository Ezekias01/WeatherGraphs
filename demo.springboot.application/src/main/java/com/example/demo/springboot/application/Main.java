package com.example.demo.springboot.application.model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
	private static HttpURLConnection connessione;
	
	public static void main(String[] args) {
		BufferedReader LEGGI;
		String record;											//legge ogni riga
		StringBuffer contenutoRisposta = new StringBuffer();	// fa l'append di ogni record e costruisce la risposta
		//String [] nomicitta = new String []{"Ancona","Rimini","Londra","Palombina"};
		try {
			URL url = new URL ("http://api.openweathermap.org/data/2.5/forecast?q="/*+nomicitta[Generanumero(0,3)]+*/+"Roma"+"&appid=0e4e6dbd50e93c3701086c841eb86f11");
			connessione = (HttpURLConnection) url.openConnection(); 			//casting
			
			//SETUP DELLA RICHIESTA
			connessione.setRequestMethod("GET");  //setting del tipo di richiesta
			connessione.setConnectTimeout(5000);
			connessione.setReadTimeout(5000);
			
			int status = connessione.getResponseCode();
			
			if(status>299) {
				LEGGI = new BufferedReader(new InputStreamReader(connessione.getErrorStream())); //legge il messaggio d'errore
				while((record=LEGGI.readLine())!=null) {contenutoRisposta.append(record);} LEGGI.close();
			}
			else {
				LEGGI = new BufferedReader(new InputStreamReader(connessione.getInputStream())); //legge il messaggio d'errore
				while((record=LEGGI.readLine())!=null) {contenutoRisposta.append(record);} LEGGI.close();
			}
			
			//System.out.println(contenutoRisposta.toString());
		}
		
		catch(MalformedURLException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		finally {connessione.disconnect();}
		
	}

}

