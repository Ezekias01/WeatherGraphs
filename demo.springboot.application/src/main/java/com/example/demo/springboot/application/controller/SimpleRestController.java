package com.example.demo.springboot.application.controller;

import org.json.simple.JSONObject;
import org.springframework.web.bind.annotation.*;

@RestController //importazione della dipendenza
public class SimpleRestController {
	@GetMapping("/hello") 
	public String exampleMethod(@RequestParam(name = "param1", defaultValue = "ciao") String param1) {
		return param1;
	}

	@PostMapping("https://jsonplaceholder.typicode.com/users?id=1") 
		public String exampleMethod2(@RequestBody String body) {
		System.out.println(body);
			return body;
		}

}

