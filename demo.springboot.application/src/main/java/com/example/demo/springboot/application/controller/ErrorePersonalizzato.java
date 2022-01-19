package com.example.demo.springboot.application.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * La classe ErrorePersonalizzato possiede un'unica rotta: "/error"
 * la quale utilizza il metodo error che restituisce un messaggio di
 * errore generico. 
 */
@RestController
public class ErrorePersonalizzato implements ErrorController {
    private static final String ROTTA = "/error";

    @RequestMapping(value = ROTTA)
    public String error() {
        String output ="ERRORE, QUALCOSA E' ANDATO STORTO ";
        String Emoji = "&#128531";
    	
    	return output+Emoji;
    }
      
}