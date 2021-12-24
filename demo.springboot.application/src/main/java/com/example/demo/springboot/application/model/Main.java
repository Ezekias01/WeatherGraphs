package com.example.demo.springboot.application.model;


import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Random;

import com.example.demo.springboot.application.service.GestoreImpl;




public class Main {
		//genera un numero casuale
		public static int Generanumero(int min, int max) {
			Random r = new Random();
			int a = min; // numero minimo
			int b = max; // numero massimo
			int c = ((b-a) + 1);
			int y = r.nextInt(c) + a;
			return y;} 
		
	
	public static void main(String[] args) {
		    String [] nomicitta = new String []{"Ancona","New York","Falconara Marittima","Londra"};
		    String collegamento="http://api.openweathermap.org/data/2.5/weather?q="+nomicitta[Generanumero(0,3)]+"&appid=0e4e6dbd50e93c3701086c841eb86f11";
		    GestoreImpl Programma = new GestoreImpl();
		    Programma.ToString(Programma.ottieniCitta(Programma.Avvio(collegamento))); 
		    String lat = Double.toString(Programma.ottieniCitta(Programma.Avvio(collegamento)).getLat());
		    String lon = Double.toString(Programma.ottieniCitta(Programma.Avvio(collegamento)).getLat());
		    long utc=1639440000;
		    String utcStr = Long.toString(utc);
		    String collegamentoDue ="http://api.openweathermap.org/data/2.5/onecall/timemachine?lat="+lat+"&lon="+lon+"&dt="+utcStr+"&appid=0e4e6dbd50e93c3701086c841eb86f11";
		    SimpleDateFormat sdf = new SimpleDateFormat("MMMM d, yyyy 'at' h:m a");
		    String date = sdf.format(utc*1000L );
		    System.out.println("\n"+Programma.ottieniCitta(Programma.Avvio(collegamento)).getNomeCity()+" in data "+ date+"\n");
		    System.out.println(Programma.Avvio(collegamentoDue).toString());
			
	}
}
