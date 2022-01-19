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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.springboot.application.model.Citta;
import com.example.demo.springboot.application.service.Gestore;
import com.example.demo.springboot.application.chart.Chart;
import com.example.demo.springboot.application.exceptions.IllegalTimeSlotException;
import com.example.demo.springboot.application.exceptions.NotFoundCityException;
import com.example.demo.springboot.application.filter_stats.Stats;
import com.example.demo.springboot.application.filter_stats.FilterImpl;
/**
 * La classe SimpleRestController e' utilizzata per implementare le varie rotte
 * nelle quali tramite l'annotazione RequestMapping possiamo specificare quali
 * Url sono associati ad ogni metodo.
 * @author Ezekias Mastaki
 * @author Andrea Pizzuto
 */
@RestController 
public class SimpleRestController {
	@Autowired //consente di effettuare la "dependecy injection"
	@Qualifier("GestoreImpl")
	Gestore gestore;
	
	@Autowired //consente di effettuare la "dependecy injection"
	@Qualifier("StatsImpl")
	Stats stats;
/**
 * La rotta "/citta" utilizza il metodo getCitta, il quale instanzia un ArrayList di String 
 * che all'interno di un ciclo viene popolato dai nomi delle citta ricavate dal file citta.
 * @return ArrayList di String popolato dai nomi di citta utilizzabili nelle rotte
 */
	@RequestMapping(value="/citta", method=RequestMethod.GET) 
	public ResponseEntity<Object> getCitta() {
		ArrayList<String> nomi = new ArrayList<String>();
		for(int i=0; i<gestore.getElencoCitta().size();i++) { 
			nomi.add(gestore.getElencoCitta().get(i).getNomeCity());
		}
		return new ResponseEntity<>(nomi,HttpStatus.OK);
	}
/**
 * La rotta "/index" utilizza il metodo getIndex, il quale legge il file e, tramite le sue righe,
 * costruisce un contenuto risposta di tipo StringBuffer.
 * Il contenuto della risposta sarà costituito dalla codifica delle date e delle fascie orarie e verra'
 * restituito sotto forma di JSON dalla rotta.
 * Tramite l'eccezione FileNotFoundException gestiamo tutti gli errori legati al file.
 * Puo' essere lanciata anche l'IOEcxeption. 
 * @throws IOException
 * @throws FileNotFoundException
 * @return contenuto del file index  
 */
	@RequestMapping(value="/index", method=RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE) 
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
			
		} catch(FileNotFoundException e) {String error; error = "ERRORE: ECCEZIONE FILENOTFOUND";
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);}
		catch(IOException e) {String error; error = "ERRORE: ECCEZIONE IO";
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST); }
	
		
	}
/**
 * La rotta "/metadata/measurements" utilizza il metodo GetMeasurements, il quale fa uso 
 * di quattro RequestParam per instanziare un filtro e una citta.
 * Il metodo restituirà l'elenco delle misure della città aderenti ai requisiti del filtro.
 * Tramite le eccezioni NotFoundObjectException e IllegalTimeSlotException gestiamo i casi
 * in cui la citta non sia presente oppure se i codici dei giorni e/o della fascia oraria
 * inseriti siano errati.
 * @param CityName
 * @param FirstDay
 * @param LastDay
 * @param TimeSlot
 * @return ArrayList di misure filtrate sulla base dei parametri inseriti dall'utente
 */
	@RequestMapping(value="/metadata/measurements", method=RequestMethod.GET) 
	public ResponseEntity<Object> GetMeasurements(@RequestParam ("CityName") String CityName, 
			@RequestParam  ("FirstDay")int FirstDay, @RequestParam  ("LastDay")int LastDay, @RequestParam  ("TimeSlot") int TimeSlot) {
		
		Citta citta;
		FilterImpl filtro;
		
		try {
		filtro = new FilterImpl(FirstDay,LastDay,TimeSlot);  
		citta = gestore.cercaCitta((String)CityName);
		return new ResponseEntity<>(filtro.Ricerca(citta),HttpStatus.OK);
		} catch (NotFoundCityException e) { 
			String sErrorMsg; sErrorMsg = "ERRORE: "+e.getErrore();
			return new ResponseEntity<>(sErrorMsg,HttpStatus.BAD_REQUEST);} 
		catch (IllegalTimeSlotException e) {
			String error; error = "ERRORE: "+e.getErrore();
			return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);} 
		}
/**
 * La rotta "/stats/mediumTemperature" utilizza il metodo getMedia, il quale fa uso 
 * dei parametri richiesti per costruire un grafico a barre contenente il confronto
 * delle medie delle temperature effettive delle citta indicate facendo riferimento al range
 * temporale del filtro.
 * Verrano lanciate le seguenti eccezioni: IllegalTimeSlotException, NullPointerException, NotFoundCityException.
 * @param firstCityName
 * @param secondCityName
 * @param FirstDay
 * @param LastDay
 * @param TimeSlot
 * @param response
 * @throws IllegalTimeSlotException
 * @throws NullPointerException
 * @throws NotFoundCityException
 */
	@RequestMapping(value="/stats/mediumTemperature", method=RequestMethod.GET) 
	public void getMedia(@RequestParam ("firstCityName") String firstCityName, @RequestParam  ("secondCityName")String secondCityName, 
			@RequestParam  ("FirstDay")int FirstDay, @RequestParam  ("LastDay")int LastDay, @RequestParam  ("TimeSlot") int TimeSlot, HttpServletResponse response) throws IllegalTimeSlotException, NullPointerException, NotFoundCityException {
		Citta citta1, citta2;
		FilterImpl filtro;
		Chart grafico;
		String s,s1;
		
		OutputStream outputStream = null;
		
		try {
			response.setContentType(MediaType.IMAGE_PNG_VALUE);	
			outputStream = response.getOutputStream();
			DefaultCategoryDataset  data= new DefaultCategoryDataset();
			filtro = new FilterImpl(FirstDay,LastDay,TimeSlot); //chiedere all'utente i tre parametri per filter
			citta1=gestore.cercaCitta((String)firstCityName);
			citta2=gestore.cercaCitta((String)secondCityName);
			s= " \""+citta1.getNomeCity()+"\"";
			s1 =  " \""+citta2.getNomeCity()+"\"";
			data.addValue(stats.tempMediaEff(filtro, citta1),"City Name",s);
			data.addValue(stats.tempMediaEff(filtro, citta2),"City Name",s1);
			grafico=new Chart();
			grafico.CreaBarChart("CITY RECORD","Temperature Average",data);
			ChartUtils.writeChartAsPNG(outputStream, grafico.getChart(), 500, 350);
			
		} catch (NotFoundCityException e) { //TODO Auto-generated catch block
			String sErrorMsg; sErrorMsg = "ERRORE: "+e.getErrore();
			throw new NotFoundCityException(sErrorMsg);
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
/**
 * La rotta "/stats/humidityVariance" utilizza il metodo getVarianza, il quale fa uso 
 * dei parametri richiesti per costruire un grafico a barre contenente il confronto
 * delle varianze delle umidita' delle città indicate facendo riferimento al range
 * temporale del filtro.
 * Verrano lanciate le seguenti eccezioni: IllegalTimeSlotException, NullPointerException, NotFoundCityException.	
 * @param FirstDay
 * @param LastDay
 * @param TimeSlot
 * @param response
 * @throws IllegalTimeSlotException
 */
	@RequestMapping(value="/stats/humidityVariance", method=RequestMethod.GET) 
	public void getVarianza(@RequestParam  ("FirstDay")int FirstDay, @RequestParam  ("LastDay")int LastDay, @RequestParam  ("TimeSlot") int TimeSlot, HttpServletResponse response) throws IllegalTimeSlotException {
		Citta citta;
		FilterImpl filtro;
		Chart grafico;
		String s;
		OutputStream outputStream = null;
		
		try {
		response.setContentType(MediaType.IMAGE_PNG_VALUE);	
		outputStream = response.getOutputStream();
		DefaultCategoryDataset  data= new DefaultCategoryDataset();
		filtro = new FilterImpl(FirstDay,LastDay,TimeSlot);  //chiedere all'utente i tre parametri per filter
		
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
			e.printStackTrace();
		}
	catch (NullPointerException e) {
		throw new NullPointerException("NULL POINTER EXCEPTION");
	}
		}
/**
 * La rotta "/stats/MaxComparison" utilizza il metodo getMax, il quale fa uso 
 * dei parametri richiesti per costruire un grafico a linee contenente il confronto
 * delle temperature massime delle citta indicate facendo riferimento al range
 * temporale del filtro.
 * Verrano lanciate le seguenti eccezioni: IllegalTimeSlotException, NullPointerException, NotFoundCityException.
 * @param FirstDay
 * @param LastDay
 * @param TimeSlot
 * @param response
 * @throws IllegalTimeSlotException
 */
	@RequestMapping(value="/stats/MaxComparison", method=RequestMethod.GET) 
	public void getMax(@RequestParam  ("FirstDay")int FirstDay, @RequestParam  ("LastDay")int LastDay, @RequestParam  ("TimeSlot") int TimeSlot, HttpServletResponse response) throws IllegalTimeSlotException {
		Citta citta;
		FilterImpl filtro;
		Chart grafico;
		String s,x;
		OutputStream outputStream = null;
		
		try {
		response.setContentType(MediaType.IMAGE_PNG_VALUE);	
		outputStream = response.getOutputStream();
		DefaultCategoryDataset  data= new DefaultCategoryDataset();
		filtro = new FilterImpl(FirstDay,LastDay,TimeSlot);  //chiedere all'utente i tre parametri per filter
		
		for (int i=0;i<gestore.getElencoCitta().size();i++) {
			citta = gestore.getElencoCitta().get(i);
			s= " \""+citta.getNomeCity()+"\"";
			for (int y=0;y<filtro.Range().size();y++) {
				x=" \""+filtro.Range().get(y)+"\"";
				data.addValue(stats.serieTempMax(filtro, citta).get(y),s,x);
			}
		}
		
		grafico=new Chart();
		grafico.CreaLineChart("MAX TEMPERATURE COMPARISON","Date Time (UTC)","Max Temperature",data);
		ChartUtils.writeChartAsPNG(outputStream, grafico.getChart(), 700, 550);
		
		} catch (IllegalTimeSlotException e) {
			throw new IllegalTimeSlotException("ERRORE"+e.getErrore()); } 
		catch (IOException e) {
			e.printStackTrace();
		}
	catch (NullPointerException e) {
		throw new NullPointerException("NULL POINTER EXCEPTION");
	}
		}
	
}


