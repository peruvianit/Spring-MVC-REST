package it.peruvianit.handler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.core.Ordered;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import it.peruvianit.helper.ErrorHelper;
import it.peruvianit.utils.RequestUtil;

public class PeruvianExceptionHandler implements HandlerExceptionResolver, Ordered {
	public int getOrder() {
        return Integer.MIN_VALUE;
    }

    public ModelAndView resolveException(HttpServletRequest aReq, 
    									 HttpServletResponse aRes, 
    									 Object aHandler, 
    									 Exception anExc) {
    	final ModelAndView mv = new ModelAndView();
        final String header = aReq.getHeader("X-Requested-With");

        if ("XMLHttpRequest".equalsIgnoreCase(header)) { // richiesta AJAX
           aRes.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
           final MappingJackson2JsonView mappingJacksonJsonView = new MappingJackson2JsonView();
           mappingJacksonJsonView.setExtractValueFromSingleKeyModel(true);
           mv.setView(mappingJacksonJsonView);

           // Dettaglio del Errore
           mv.addObject(ErrorHelper.getErrorDTO(anExc));
           mv.addObject(RequestUtil.getUserDetails(aReq));
        } else { // a JSP style error
           mv.setViewName("error/500");
        }
        anExc.printStackTrace();
        return mv;
    }
}