package it.peruvianit.utils;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import eu.bitwalker.useragentutils.UserAgent;
import it.peruvianit.dto.UserDetailsDTO;

public class RequestUtil {
	public static UserDetailsDTO getUserDetails(HttpServletRequest requestContext){
		UserDetailsDTO userDetails = new UserDetailsDTO();
		String userAgentHeader = requestContext.getHeader("User-Agent");
		
		if (userAgentHeader != null) {
			UserAgent userAgent = UserAgent.parseUserAgentString(userAgentHeader);
			
			// INFO MACCHINE
			String ipAddress = requestContext.getRemoteAddr();
			String userRemote = "";
			String macAddress = "";
			
			// INFO BROWSER
			Integer id = userAgent.getId();
			String browser = userAgent.getBrowser().getName();
			String browserType = userAgent.getBrowser().getBrowserType().getName();
			String browserVersion = userAgent.getBrowserVersion().getVersion();
			String nameOperatingSystem = userAgent.getOperatingSystem().getName();
			String deviceType = userAgent.getOperatingSystem().getDeviceType().getName();
			String manufacter = userAgent.getOperatingSystem().getManufacturer().getName();
			
			
			userDetails.setIpAddress(ipAddress);
			userDetails.setMacAddress(macAddress);
			userDetails.setUsername(userRemote);
			userDetails.setId(id);
			userDetails.setBrowser(browser);
			userDetails.setBrowserType(browserType);
			userDetails.setBrowserVersion(browserVersion);
			userDetails.setNameOperatingSystem(nameOperatingSystem);
			userDetails.setDeviceType(deviceType);
			userDetails.setManufacter(manufacter);
		}
		
		return userDetails;
	}
	
	public static String captureParamsRequest(HttpServletRequest requestContext){
		@SuppressWarnings("unchecked")
		Enumeration<String> parameterNames = (requestContext.getParameterNames());
		
		Map<String,Object> mapParams = new HashMap<String,Object>();
		
		String returnValue = "";
		
		while(parameterNames.hasMoreElements()){
			String paramNames = parameterNames.nextElement();
			String[] paramValues = requestContext.getParameterValues(paramNames);
			
			Object value = null;
			if (paramValues.length > 2){
				List<String> listValues = new ArrayList<>();
							
				for (int i=0; i < paramValues.length; i++){
					String paramValue = paramValues[i];
					listValues.add(paramValue);
				}
				value = listValues;
			}else{
				value = paramValues[0];				
			}
			
			mapParams.put(paramNames, value);			
		}
		
		if (mapParams.size()>0){
			returnValue = GsonUtil.objToJson(mapParams);
		}
		return returnValue;
	}
}
