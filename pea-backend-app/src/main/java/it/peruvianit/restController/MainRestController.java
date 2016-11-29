package it.peruvianit.restController;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class MainRestController {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() throws Exception{
		return "Home";
	}
	
	/*
	 * Testing per utilizo Handler exception {PeruvianExceptionHandler}
	 */
	@RequestMapping(value = "/exception", method = RequestMethod.GET)
	public String exception() throws Exception{		
		return String.valueOf(2/0);
	}
}
