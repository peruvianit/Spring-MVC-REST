package it.peruvianit.componente;

import it.peruvianit.interfaces.IPermessi;

public class BaseAbstract implements IPermessi {
	private String key;
	private String nome;

	private Boolean lettura;
	private Boolean scrittura;
	private Boolean esecuzione;
	
	// Methods 
	
	/**
	 * @return String Info del Componente con la concatenazione dei attributi
	 */	
	public String getInfo(){
		return "key=" + this.key + ", nome=" + this.nome;
	}

	public String getInfoPermessi() {
		return "Permessi [lettura=" + lettura + ", scrittura=" + scrittura + ", esecuzione=" + esecuzione + "]";
	}
	
	// Getters and Setters
	
	/**
	 * @return String la chiave per il Componente
	 */
	public String getKey() {
		return key;
	}

	/**
	 * Setta chiave per il Componente
	 * 
	 * @param key chiave per assignare al Componente
	 */
	public void setKey(final String key) {
		this.key = key;
	}

	/**
	 * @return String Nome del Componente
	 */
	public String getNome() {
		return nome;
	}

	/**
	 * Setta il nome per il Componente
	 * 
	 * @param nome Nome per assignare al Componente
	 */
	
	public void setNome(final String nome) {
		this.nome = nome;
	}
	
	@Override
	public Boolean getLettura() {
		return lettura;
	}
	
	@Override
	public void setLettura(Boolean lettura) {
		this.lettura = lettura;
	}
	
	@Override
	public Boolean getScrittura() {
		return scrittura;
	}
	
	@Override
	public void setScrittura(Boolean scrittura) {
		this.scrittura = scrittura;
	}
	
	@Override
	public Boolean getEsecuzione() {
		return esecuzione;
	}

	@Override
	public void setEsecuzione(Boolean esecuzione) {
		this.esecuzione = esecuzione;
	}

	{
		this.lettura = true;
		this.scrittura = true;
		this.esecuzione = true;
	}
}
