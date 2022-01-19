package com.example.demo.springboot.application;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.junit.jupiter.api.BeforeEach;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import com.example.demo.springboot.application.filter_stats.FilterImpl;
import com.example.demo.springboot.application.service.GestoreImpl;
import com.example.demo.springboot.application.exceptions.IllegalTimeSlotException;
import com.example.demo.springboot.application.exceptions.NotFoundCityException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest (webEnvironment = WebEnvironment.RANDOM_PORT)
class ApplicationTests {
	FilterImpl filtro,filtro2;
	GestoreImpl gestore = new GestoreImpl();
	
	@Autowired
	private TestRestTemplate restTemplate;
	
	@LocalServerPort
	private int port;
	
	@BeforeEach
	void setUp() throws Exception {
		filtro = new FilterImpl(1,1,1);
		filtro2 = new FilterImpl(7,1,2);
		port = 8080;
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}
	
	@Test
	public void TestIllegalTimeSlotException() throws Exception {
		assertThrows(IllegalTimeSlotException.class,() -> filtro2.Range());
	}

	@Test
	public void TestNotFoundCityException() throws Exception {
		assertThrows(NotFoundCityException.class,() -> gestore.cercaCitta("Rimini"));
	}
	
	@Test
	void TestMetodoRange() throws Exception {
		ArrayList<Long> range = new ArrayList<Long>();
		range.add((long)1640239200);
		range.add((long)1640250000);
		assertArrayEquals(range.toArray(), filtro.Range().toArray());
	}
	
	@Test
	public void testRottaCitta() throws Exception { //per il testing lanciare l'applicazione
		ArrayList<String> nomi = new ArrayList<String>();
		nomi.add("Roma");
		nomi.add("Ancona");
		nomi.add("Milano");
		nomi.add("Cagliari");
		nomi.add("Palermo");
		nomi.add("Aosta");
		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/citta",String.class)).contains(nomi);
	}
	
	@Test
	public void testRottaIndex() throws Exception { //per il testing lanciare l'applicazione
		assertThat(this.restTemplate.getForObject("http://localhost:"+port+"/index",String.class).contains("application/json"));
	}
	
}
