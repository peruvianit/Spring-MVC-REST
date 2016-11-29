package it.peruvianit.dto;

import java.io.Serializable;

public class RequestDetailsDTO implements Serializable {
	private static final long serialVersionUID = 6175254360759111357L;
	
	private String ipAddressLocale;
	private String ipAddressRemote;	
	private String method;
	private String requestUri;
	private String contentType;
	private String reference;
	private String paramsQuery;
	
	ExecuteTimeDTO executeTimeDTO;
	
	public String getIpAddressLocale() {
		return ipAddressLocale;
	}
	public void setIpAddressLocale(final String ipAddressLocale) {
		this.ipAddressLocale = ipAddressLocale;
	}
	public String getIpAddressRemote() {
		return ipAddressRemote;
	}
	public void setIpAddressRemote(final String ipAddressRemote) {
		this.ipAddressRemote = ipAddressRemote;
	}
	public String getMethod() {
		return method;
	}
	public void setMethod(String method) {
		this.method = method;
	}
	public String getRequestUri() {
		return requestUri;
	}
	public void setRequestUri(final String requestUri) {
		this.requestUri = requestUri;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(final String contentType) {
		this.contentType = contentType;
	}
	public String getReference() {
		return reference;
	}
	public void setReference(final String reference) {
		this.reference = reference;
	}
	public String getParamsQuery() {
		return paramsQuery;
	}
	public void setParamsQuery(final String paramsQuery) {
		this.paramsQuery = paramsQuery;
	}
	public ExecuteTimeDTO getExecuteTimeDTO() {
		return executeTimeDTO;
	}
	public void setExecuteTimeDTO(ExecuteTimeDTO executeTimeDTO) {
		this.executeTimeDTO = executeTimeDTO;
	}
}
