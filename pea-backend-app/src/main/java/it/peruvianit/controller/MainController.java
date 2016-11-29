package it.peruvianit.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import it.peruvianit.dto.ErrorDTO;
import it.peruvianit.utils.PopulatorUtil;

@Controller
public class MainController {
	
	/*
	 * Testing per utilizzo chiamata JSP standard WebContent/jsp/{return string}.jsp
	 */
	@RequestMapping(value = "/message", method = RequestMethod.GET)
	public String message() throws Exception{		
		return "test/message";
	}
	
	/*
	 * Testing per ritornare un ModelAndView
	 * chiamata standard con il set della jsp manuale 
	 * ::> modelAndView.setViewName("test/modelAndView");
	 */
	@RequestMapping(value = "/modelAndView", method = RequestMethod.GET)
	public ModelAndView modelAndViewCall(HttpServletRequest request, 
										 HttpServletResponse response) throws Exception{		
		Map<String, Object> miModelo = new HashMap<String, Object>();
        miModelo.put("ip", request.getRemoteAddr());
        miModelo.put("lang", request.getLocale());
        miModelo.put("tipoChiamata", "/modelAndView");
        
		ModelAndView modelAndView = new ModelAndView();
		
		modelAndView.addObject("miModelo",miModelo);
		modelAndView.addObject(PopulatorUtil.populateBean(ErrorDTO.class));
		
		modelAndView.setViewName("test/modelAndView");
		modelAndView.addObject("test", "messagio di prova da modelAndViewCall");
		
		return modelAndView;
	}
	
	/*
	 * Testing per ritornare un ModelAndView
	 * chiamata standard con il set della jsp manuale 
	 */
	@RequestMapping(value = "/test/modelAndView", method = RequestMethod.GET)
	public ModelAndView modelAndViewCallDirectJSP(HttpServletRequest request, 
										 		  HttpServletResponse response) throws Exception{		
		Map<String, Object> miModelo = new HashMap<String, Object>();
        miModelo.put("ip", request.getRemoteAddr());
        miModelo.put("lang", request.getLocale());
        miModelo.put("tipoChiamata", "/test/modelAndView");
        
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("miModelo",miModelo);
		modelAndView.addObject("test", "messagio di prova da modelAndViewCallDirectJSP");
		return modelAndView;
	}
	
}
