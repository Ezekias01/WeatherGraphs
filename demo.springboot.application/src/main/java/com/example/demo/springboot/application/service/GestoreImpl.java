package com.example.demo.springboot.application.service;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.example.demo.springboot.application.model.*;
import com.example.demo.springboot.application.exceptions.NotFoundObjectException;

@Component
@Qualifier("GestoreImpl")
public class GestoreImpl implements Gestore{
	private ArrayList<Citta> Elenco;
	
	public GestoreImpl(){
		Elenco = new ArrayList<Citta>();
		this.setList();
	}
	
	@Override
	public void setList() {
		JSONArray cityList;
		try { 
			String record;											//legge ogni riga
			StringBuffer contenutoRisposta = new StringBuffer();
			BufferedReader LEGGI = new BufferedReader(new InputStreamReader(new FileInputStream("citta.txt"), "UTF-8")); 
			while((record=LEGGI.readLine())!=null) {
				contenutoRisposta.append(record);
			}
			LEGGI.close();
			cityList= new JSONArray(contenutoRisposta.toString());
			int i=0;
			while(i<cityList.length()) {
				JSONObject city = cityList.getJSONObject(i);
				this.Elenco.add(parseCitta(city));
				i++;
			}
		}
		
		catch(FileNotFoundException e) {e.printStackTrace();}
		catch(IOException e) {e.printStackTrace();}
		catch(JSONException e) {e.printStackTrace();}		
	}
	
	@Override
	public ArrayList<Citta> getElencoCitta() {
		return Elenco;	
	}

	@Override
	public Citta parseCitta(JSONObject city)  throws JSONException {
		Citta Citta;
		try {
			JSONObject cityObj1 = (JSONObject) city.get("city");
			String nomeCitta = cityObj1.getString("name");
			int idCitta = (Integer)cityObj1.get("id");
			JSONObject cityObj2 = (JSONObject)cityObj1.get("coord");
			double longitudine = cityObj2.getDouble("lon");
			double latitudine = cityObj2.getDouble("lat");
			String country = cityObj1.getString("country");
			JSONArray list= (JSONArray) city.get("list");
		    JSONArray wea;
			Citta = new Citta(idCitta,nomeCitta,country,latitudine,longitudine);
			
			int y=0;
			while(y<list.length()){
				JSONObject obj5=list.getJSONObject(y);
				long dt = obj5.getLong("dt");
				String dttxt = obj5.getString("dt_txt");
				JSONObject obj6 = (JSONObject)obj5.get("main");
				double valoreAttuale = obj6.getDouble("temp");
				double valorePercepito = obj6.getDouble("feels_like");
				double valoreMax = obj6.getDouble("temp_max");
				double valoreMin = obj6.getDouble("temp_min");
				int humidity = obj6.getInt("humidity");
				wea = (JSONArray)obj5.get("weather");
				JSONObject obj7=wea.getJSONObject(0);
				int idWeather = (Integer)obj7.get("id");
				String main = obj7.getString("main");
				String description = obj7.getString("description");
				Temperatura tAttuale = new Temperatura(valoreAttuale);
				Temperatura tPercepita = new Temperatura(valorePercepito);
				Temperatura tMax = new Temperatura(valoreMax);
				Temperatura tMin = new Temperatura(valoreMin);
				Weather weather = new Weather(idWeather,main,description);
				Citta.addMisura(new Misura(dt,dttxt,humidity,tAttuale,tPercepita,tMax,tMin,weather));
				y++;
			}
			return Citta;
		}
		catch(JSONException exception) {throw new JSONException("ERRORE PARSING JSON");}
				
	}
	
	@Override
	public Citta cercaCitta(String nome) throws NotFoundObjectException {
		int temp1=0; 
		boolean flag=false;
		for(int x=0;x<Elenco.size();x++) { 
			if(nome.equals(this.Elenco.get(x).getNomeCity())) { 
				temp1=x; flag=true;
			}
		}
		if(flag) {
			return this.Elenco.get(temp1);
		}
		else {
			throw new NotFoundObjectException(nome+" not found");
		}
		
	}
	
	@Override
	public Citta cercaCitta(int id) throws NotFoundObjectException {
		int temp=0; boolean flag=false; 
		for(int z=0;z<Elenco.size();z++) { 
			if(id==Elenco.get(z).getCityId()) { temp=z; flag=true;}
						}
		
		if(flag) {return Elenco.get(temp);}
		else {throw new  NotFoundObjectException("Id not found");}
		
	}
	
}