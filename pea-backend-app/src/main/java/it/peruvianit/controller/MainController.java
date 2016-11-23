package it.peruvianit.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

@RestController
public class MainController {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home(){
		return "Home";
	}
}
