package it.peruvianit.beans;

import java.util.LinkedHashMap;

public class AttribFormDTO {
	private LinkedHashMap<String ,Object> attribForm = new LinkedHashMap<>();

	public LinkedHashMap<String, Object> getAttribForm() {
		return attribForm;
	}

	public void setAttribForm(LinkedHashMap<String, Object> attribForm) {
		this.attribForm = attribForm;
	}
}
