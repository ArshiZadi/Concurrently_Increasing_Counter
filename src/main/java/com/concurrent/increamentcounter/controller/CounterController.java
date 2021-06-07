package com.concurrent.increamentcounter.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.concurrent.increamentcounter.service.CounterService;

@RestController
public class CounterController {
	@Autowired
	CounterService counterService;
	
	@GetMapping("/setInitialCounter")
	public ResponseEntity<String> setInitialCounter(@RequestParam(value ="id") Long id)
	{
		try {
			counterService.setInitialCounterValue(id);
		} catch (Exception e) {
			return new ResponseEntity<String>("Initial counter setting exception", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("Initial value set for Number ", HttpStatus.OK);
	}
	
	@GetMapping("/increaseCounterValue")
	public ResponseEntity<String> increaseCounterValue(@RequestParam(value = "id") Long id)
	{
		try {
			counterService.increaseCounterValue(id);
		} catch (Exception e) {
			return new ResponseEntity<String>("Counter increament exception", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>("Counter increased successfully", HttpStatus.OK);
	}

}
