package it.peruvianit.dto;

import java.io.Serializable;

public class UserDetailsDTO implements Serializable {
	private static final long serialVersionUID = 8451941391726098952L;
	
	private String username;
	private String ipAddress;
	private String macAddress;
	
	private Integer id;
	private String browser;
	private String browserType;
	private String browserVersion;
	private String nameOperatingSystem;
	private String deviceType;
	private String manufacter;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(final String username) {
		this.username = username;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(final String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getMacAddress() {
		return macAddress;
	}
	public void setMacAddress(final String macAddress) {
		this.macAddress = macAddress;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getBrowser() {
		return browser;
	}
	public void setBrowser(final String browser) {
		this.browser = browser;
	}
	public String getBrowserType() {
		return browserType;
	}
	public void setBrowserType(final String browserType) {
		this.browserType = browserType;
	}
	public String getBrowserVersion() {
		return browserVersion;
	}
	public void setBrowserVersion(final String browserVersion) {
		this.browserVersion = browserVersion;
	}
	public String getNameOperatingSystem() {
		return nameOperatingSystem;
	}
	public void setNameOperatingSystem(final String nameOperatingSystem) {
		this.nameOperatingSystem = nameOperatingSystem;
	}
	public String getDeviceType() {
		return deviceType;
	}
	public void setDeviceType(final String deviceType) {
		this.deviceType = deviceType;
	}
	public String getManufacter() {
		return manufacter;
	}
	public void setManufacter(final String manufacter) {
		this.manufacter = manufacter;
	}
}
