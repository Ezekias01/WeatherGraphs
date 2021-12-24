package com.example.demo.springboot.application.service;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.json.*;

import com.example.demo.springboot.application.model.*;


public class GestoreImpl implements Gestore{
	private static HttpURLConnection connessione;

	@Override
	public StringBuffer Avvio(String collegamento) {
		BufferedReader LEGGI;
		String record;											//legge ogni riga
		StringBuffer contenutoRisposta = new StringBuffer();	// fa l'append di ogni record e costruisce la risposta
		
		
		try {
			URL url = new URL (collegamento);
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
		
		return contenutoRisposta;
	}

	@Override
	public Citta ottieniCitta(StringBuffer x) {
		try {
			JSONObject obj1 = new JSONObject(x.toString());
			JSONObject obj2 = (JSONObject)obj1.get("coord");
			JSONObject obj3 = (JSONObject)obj1.get("sys");
			JSONObject obj4 = (JSONObject)obj1.get("main");
			JSONArray wea= (JSONArray)obj1.get("weather");
			JSONObject obj5=wea.getJSONObject(0);
			
			
			
			String nomeCitta = obj1.getString("name");
			int idCitta = (Integer)obj1.get("id");
			double longitudine = obj2.getDouble("lon");
			double latitudine = obj2.getDouble("lat");
			String country = obj3.getString("country");
			double valoreAttuale = obj4.getDouble("temp");
			double valorePercepito = obj4.getDouble("feels_like");
			double valoreMax = obj4.getDouble("temp_max");
			double valoreMin = obj4.getDouble("temp_min");
			int idWeather = (Integer)obj5.get("id");
			String main = obj5.getString("main");
			String description = obj5.getString("description");
			Temperatura tAttuale = new Temperatura(valoreAttuale);
			Temperatura tPercepita = new Temperatura(valorePercepito);
			Temperatura tMax = new Temperatura(valoreMax);
			Temperatura tMin = new Temperatura(valoreMin);
			Weather weather = new Weather(idWeather,main,description);
			Misura misura = new Misura(weather,tAttuale,tPercepita,tMax,tMin);
			
			Citta Citta = new Citta(idCitta,nomeCitta,country,latitudine,longitudine,misura);
			return Citta;
		}
		catch(JSONException exception) {exception.printStackTrace(); return null;}
		
		
	}

	@Override
	public void ToString(Citta Citta) {
		System.out.println("Nome: "+Citta.getNomeCity()+" Id: "+Citta.getCityId()+" Country: "+Citta.getCountry()+" long: "+Citta.getLat()+" lat: "+Citta.getLongit()+"\n"
				+"Misura:\n"+"Temperatura --> attuale: "+Citta.getMisura().gettAttuale().getValore()
				+" percepita: "+Citta.getMisura().gettPercepita().getValore()+" max: "+Citta.getMisura().gettMax().getValore()
				+" min: "+Citta.getMisura().gettMin().getValore()+"\nId weather: "
				+Citta.getMisura().getWeather().getIdW()+" main: "
						+Citta.getMisura().getWeather().getMain()+" description "
								+Citta.getMisura().getWeather().getDescription());
		
	}
	
	
}