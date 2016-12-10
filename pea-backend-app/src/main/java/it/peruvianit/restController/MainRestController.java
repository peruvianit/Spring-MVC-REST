package it.peruvianit.restController;

import java.util.Arrays;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import it.peruvianit.dto.ErrorDTO;
import it.peruvianit.utils.PopulatorUtil;

@RestController
public class MainRestController {
	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String home() throws Exception{
		return "Home";
	}
	
	/*
	 * Testing per ritornare HttpHeaders 
	 */
	@RequestMapping(value = "/httpHeaders", method = RequestMethod.POST)
	public ResponseEntity<Object> httpHeaders (HttpServletRequest request, 
			 								   HttpServletResponse response) throws Exception {
		
		MultiValueMap<String, String> headers = new HttpHeaders();
        headers.put("token", Arrays.asList(UUID.randomUUID().toString()));
		
		return  new ResponseEntity<Object>(".-.",headers, HttpStatus.OK);
	}
	
	/*
	 * Testing per ritornare HttpHeaders 
	 */
	@RequestMapping(value = "/errorDTO")
	public ResponseEntity<ErrorDTO> errorDTO (HttpServletRequest request, 
			 								  HttpServletResponse response) throws Exception {
		
		ErrorDTO errorDTO = PopulatorUtil.populateBean(ErrorDTO.class);
		
		return  new ResponseEntity<ErrorDTO>(errorDTO,HttpStatus.OK);
	}
}
