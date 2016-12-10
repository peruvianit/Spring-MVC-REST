package it.peruvianit.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import it.peruvianit.dto.ExecuteTimeDTO;
import it.peruvianit.dto.RequestDetailsDTO;
import it.peruvianit.metrics.ExecuteQueuSingleton;
import it.peruvianit.utils.RequestUtil;

public class ExecuteTimeInterceptor extends HandlerInterceptorAdapter{
	final static Logger logger = LoggerFactory.getLogger(ExecuteTimeInterceptor.class);

	//before the actual handler will be executed
	public boolean preHandle(HttpServletRequest request,
							 HttpServletResponse response, 
							 Object handler) throws Exception {
		ExecuteTimeDTO executeTimeDTO = new ExecuteTimeDTO();
		executeTimeDTO.setStartTime(System.currentTimeMillis());
		
		RequestDetailsDTO requestDetailsDTO = RequestUtil.getRequestDetailsDTO(request);
		requestDetailsDTO.setExecuteTimeDTO(executeTimeDTO);
		
		request.setAttribute("requestDetailsDTO", requestDetailsDTO);

		return true;
	}

	//after the handler is executed
	public void postHandle(HttpServletRequest request, 
						   HttpServletResponse response,
						   Object handler, 
						   ModelAndView modelAndView) throws Exception {
		RequestDetailsDTO requestDetailsDTO = (RequestDetailsDTO)request.getAttribute("requestDetailsDTO");
		requestDetailsDTO.getExecuteTimeDTO().setEndTime(System.currentTimeMillis());
		requestDetailsDTO.getExecuteTimeDTO().setExecuteTime(requestDetailsDTO.getExecuteTimeDTO().getEndTime() - requestDetailsDTO.getExecuteTimeDTO().getStartTime());
		requestDetailsDTO.setStatusCode(response.getStatus());
		
		ExecuteQueuSingleton.getInstance().add(requestDetailsDTO);
	}
}