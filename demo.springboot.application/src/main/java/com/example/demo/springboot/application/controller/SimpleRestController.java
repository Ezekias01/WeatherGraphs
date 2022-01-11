package com.example.demo.springboot.application.controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.jfree.chart.ChartUtils;
import org.jfree.data.category.DefaultCategoryDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.springboot.application.model.Citta;
import com.example.demo.springboot.application.service.Gestore;
import com.example.demo.springboot.application.chart.Chart;
import com.example.demo.springboot.application.exceptions.IllegalTimeSlotException;
import com.example.demo.springboot.application.exceptions.NotFoundObjectException;
import com.example.demo.springboot.application.filter_stats.Stats;
import com.example.demo.springboot.application.filter_stats.Filter;

@RestController 
public class SimpleRestController {
	@Autowired //consente di effettuare la "dependecy injection", ovvero creare un'instanza di Gestore
	@Qualifier("GestoreImpl")
	Gestore gestore;
	
	@Autowired //consente di effettuare la "dependecy injection", ovvero creare un'instanza di Stats
	@Qualifier("StatsImpl")
	Stats stats;
	
	@RequestMapping(value="/citta") 
	public ResponseEntity<Object> getCitta() {
		ArrayList<String> nomi = new ArrayList<String>();
		for(int i=0; i<gestore.getElencoCitta().size();i++) { 
			nomi.add(gestore.getElencoCitta().get(i).getNomeCity());
		}
		return new ResponseEntity<>(nomi,HttpStatus.OK);
	}
	
	@RequestMapping(value="/index", produces = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Object> getIndex() throws IOException {
		try {
			String record;											
			StringBuffer contenutoRisposta = new StringBuffer();
			BufferedReader LEGGI = new BufferedReader(new InputStreamReader(new FileInputStream("index.txt"), "UTF-8")); 
			while((record=LEGGI.readLine())!=null) {
				contenutoRisposta.append(record);
				
				}
			LEGGI.close();
			return new ResponseEntity<>(contenutoRisposta,HttpStatus.OK);
			
		} catch(FileNotFoundException e) {String error; error = "ERRORE: ECCEZIONE IO";
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);}
		catch(IOException e) {String error; error = "ERRORE: FILE INDEX NON TROVATO";
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST); }
	
		
	}
	
	@RequestMapping(value="/filter/measurements") 
	public ResponseEntity<Object> Filter(@RequestParam ("CityName") String CityName, 
			@RequestParam  ("FirstDay")int FirstDay, @RequestParam  ("LastDay")int LastDay, @RequestParam  ("TimeSlot") int TimeSlot) {
		
		Citta citta;
		Filter filtro;
		
		try {
		filtro = new Filter(FirstDay,LastDay,TimeSlot);  //chiedere all'utente i tre parametri per filter
		citta = gestore.cercaCitta((String)CityName);
		return new ResponseEntity<>(filtro.Ricerca(citta),HttpStatus.OK);
		} catch (NotFoundObjectException e) { //TODO Auto-generated catch block
			String sErrorMsg; sErrorMsg = "ERRORE: "+e.getErrore();
			return new ResponseEntity<>(sErrorMsg,HttpStatus.BAD_REQUEST);} 
		catch (IllegalTimeSlotException e) {
			String error; error = "ERRORE: "+e.getErrore();
			return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);} 
		}
	
	@RequestMapping(value="/stats/mediumTemperature") 
	public void getMedia(@RequestParam ("firstCityName") String firstCityName, @RequestParam  ("secondCityName")String secondCityName, 
			@RequestParam  ("FirstDay")int FirstDay, @RequestParam  ("LastDay")int LastDay, @RequestParam  ("TimeSlot") int TimeSlot, HttpServletResponse response) throws IllegalTimeSlotException, NullPointerException, NotFoundObjectException {
		Citta citta1, citta2;
		Filter filtro;
		Chart grafico;
		String s,s1;
		
		OutputStream outputStream = null;
		
		try {
			response.setContentType(MediaType.IMAGE_PNG_VALUE);	
			outputStream = response.getOutputStream();
			DefaultCategoryDataset  data= new DefaultCategoryDataset();
			filtro = new Filter(FirstDay,LastDay,TimeSlot); //chiedere all'utente i tre parametri per filter
			citta1=gestore.cercaCitta((String)firstCityName);
			citta2=gestore.cercaCitta((String)secondCityName);
			s= " \""+citta1.getNomeCity()+"\"";
			s1 =  " \""+citta2.getNomeCity()+"\"";
			data.addValue(stats.tempMedia(filtro, citta1),"CityNames",s);
			data.addValue(stats.tempMedia(filtro, citta2),"CityNames",s1);
			grafico=new Chart();
			grafico.CreaBarChart("CITY RECORD","Temperature Average",data);
			ChartUtils.writeChartAsPNG(outputStream, grafico.getChart(), 500, 350);
			
		} catch (NotFoundObjectException e) { //TODO Auto-generated catch block
			String sErrorMsg; sErrorMsg = "ERRORE: "+e.getErrore();
			throw new NotFoundObjectException(sErrorMsg);
			} 
			catch (IllegalTimeSlotException e) {
				String Msg; Msg = "ERRORE: "+e.getErrore();
				throw new IllegalTimeSlotException(Msg);} 
			catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		catch (NullPointerException e) {
			// TODO Auto-generated catch block
			throw new NullPointerException("NULL POINTER EXCEPTION");
		}
			}
	
	@RequestMapping(value="/stats/humidityVariance") 
	public void getVarianza(@RequestParam  ("FirstDay")int FirstDay, @RequestParam  ("LastDay")int LastDay, @RequestParam  ("TimeSlot") int TimeSlot, HttpServletResponse response) throws IllegalTimeSlotException {
		Citta citta;
		Filter filtro;
		Chart grafico;
		String s;
		OutputStream outputStream = null;
		
		try {
		response.setContentType(MediaType.IMAGE_PNG_VALUE);	
		outputStream = response.getOutputStream();
		DefaultCategoryDataset  data= new DefaultCategoryDataset();
		filtro = new Filter(FirstDay,LastDay,TimeSlot);  //chiedere all'utente i tre parametri per filter
		
		for (int i=0;i<gestore.getElencoCitta().size();i++) {
			citta = gestore.getElencoCitta().get(i);
			s= " \""+citta.getNomeCity()+"\"";
			data.addValue(stats.varUmidita(filtro, citta),"CityNames",s);
			}
		
		grafico=new Chart();
		grafico.CreaBarChart("HUMIDITY VARIANCE COMPARISON","Humidity Variance",data);
		ChartUtils.writeChartAsPNG(outputStream, grafico.getChart(), 600, 450);
		
		} catch (IllegalTimeSlotException e) {
			
			throw new IllegalTimeSlotException("ERRORE"+e.getErrore()); } 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	catch (NullPointerException e) {
		// TODO Auto-generated catch block
		throw new NullPointerException("NULL POINTER EXCEPTION");
	}
		}
	
}