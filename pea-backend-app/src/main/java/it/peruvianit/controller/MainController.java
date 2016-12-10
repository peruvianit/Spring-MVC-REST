package it.peruvianit.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.InternalResourceView;
import org.springframework.web.servlet.view.RedirectView;

import it.peruvianit.dto.ErrorDTO;
import it.peruvianit.exception.PeaBackEndAppException;
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
	 * Testing per utilizo Handler exception {PeruvianExceptionHandler}
	 */
	@RequestMapping(value = "/exception", method = RequestMethod.GET)
	public String exception() throws Exception{		
		throw new PeaBackEndAppException("Errore generato PeaBackendAppException");
	}
	
	/*
	 * Testing per ritornare un ModelAndView
	 * chiamata standard con il set della propieta.
	 * modelAndView.setViewName("test/modelAndView");
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
	 * Testing per ritornare un ModelAndView senza : 
	 * modelAndView.setViewName("test/modelAndView");
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
	
	/*
	 * Testing per ritornare un Model
	 */
	@RequestMapping(value = "/test/model", method = RequestMethod.GET)
	public Model model(Model model) throws Exception{		
		model.addAttribute("model", "invio stringa Modelo");
		return model;
	}
	
	/*
	 * Testing per ritornare un Oggetto Map
	 */
	@RequestMapping(value = "/test/map", method = RequestMethod.GET)	
	public Map<String, Object> MAP() {
		Map<String, Object> out = new LinkedHashMap<String, Object>();
		out.put("key", "ISUDU78789");
		return out;
	}
	
	/*
	 * Testing per ritornare una View Sample 1
	 */
	@RequestMapping(value = "/viewSample1", method = RequestMethod.GET)
	public View viewRedirectView(){
		return new RedirectView("test/model");
	}
	
	/*
	 * Testing per ritornare una View Sample 2
	 */
	@RequestMapping(value = "/viewSample2", method = RequestMethod.GET)
	public View viewInternalResourceView(){
		return new InternalResourceView("test/model");
	}
	
	/*
	 * Testing per ritornare un Void Sample 1
	 */
	@RequestMapping(value = "/void/sample1", method = RequestMethod.GET)
	public void callVoidReturnBuffer(HttpServletResponse response) throws Exception {
		response.setContentType("application/vnd.ms-excel");

		response.setHeader("Pragma", "public");
		response.setHeader("Cache-Control", "max-age=0");
		response.setHeader("X-UA-Compatible","IE=EmulateIE7");
		response.setHeader("Set-Cookie", "fileDownload=true; path=/");
		/**
		 * Fine
		 */		
		response.setHeader("Content-Disposition", "attachment; filename=\""
				+ "sample.xls" + "\"");
		ServletOutputStream out = response.getOutputStream();
		
		/*
		 * Implementazione per creazione del file da scaricare 
		 */
		
		out.write("Chiamata con ritorno VOID".getBytes());
		response.flushBuffer();
		out.close();
	}
	
	/*
	 * Testing per ritornare un Void Sample 1
	 */
	@RequestMapping(value = "/void/Sample2", method = RequestMethod.GET)
	public void callVoidReturnStatusCode(HttpServletResponse response) throws Exception {
		response.setStatus(403);
	}
	
	/*
	 * Testing per ritornare AbstractExcelView
	 * @Deprecated AbstractExcelView
	 */
	@RequestMapping(value = "/download/excel", method = RequestMethod.GET)
	public ModelAndView downloadExcel() throws Exception {
		List<String> listString = new ArrayList<String>();
		listString.add("uno");
		listString.add("due");
		listString.add("tre");
		listString.add("quattro");
		return new ModelAndView("ExcelView","listString",listString);
	}
	
	/*
	 * Testing per ritornare AbstractExcelView
	 * @Deprecated AbstractExcelView
	 */
	@RequestMapping(value = "/download/excelXls", method = RequestMethod.GET)
	public ModelAndView downloadExcelXls() throws Exception {
		List<String> listString = new ArrayList<String>();
		listString.add("uno");
		listString.add("due");
		listString.add("tre");
		listString.add("quattro");
		return new ModelAndView("XlsView","listString",listString);
	}
	
	/*
	 * Testing per ritornare AbstractPdfView
	 */
	@RequestMapping(value = "/download/pdf", method = RequestMethod.GET)
	public ModelAndView downloadPdf() throws Exception {
		List<String> listString = new ArrayList<String>();
		listString.add("uno");
		listString.add("due");
		listString.add("tre");
		listString.add("quattro");
		return new ModelAndView("PdfView","listString",listString);
	}
	
	/*
	 * Testing per ritornare AbstractView
	 */
	@RequestMapping(value = "/download/csv", method = RequestMethod.GET)
	public ModelAndView csv() throws Exception {
		
		/*** HEADER ***/ 
		List<String> csvHeaderIterable = new ArrayList<String>();
		csvHeaderIterable.add("column 1");
		csvHeaderIterable.add("column 2");
		csvHeaderIterable.add("column 3");
		csvHeaderIterable.add("column 4");
		
		/*** ROWS ***/
		List<List<String>> inputIterable = new ArrayList<List<String>>();
		
		List<String> listRow1 = new ArrayList<String>();
		listRow1.add("aa");
		listRow1.add("bb");
		listRow1.add("cc");
		listRow1.add("dd");
		inputIterable.add(listRow1);
		
		List<String> listRow2 = new ArrayList<String>();
		listRow2.add("aa");
		listRow2.add("bb");
		listRow2.add("cc");
		listRow2.add("dd");
		inputIterable.add(listRow2);
		
		/************/
		ModelAndView model = new ModelAndView("CsvView");
		
		model.addObject("csvHeaderIterable", csvHeaderIterable);
		model.addObject("inputIterable", inputIterable);
		
		return model;
	}
}
