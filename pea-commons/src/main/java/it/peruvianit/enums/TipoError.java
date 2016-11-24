package it.peruvianit.enums;

/**
 * Classe enum per le tipologie di Errori gestiti, la classe gestice le informazioni :
 * codice : codice univoco del Tipo Errore
 * descrizione : Descrizione del Tipo Errore
 *
 * 
 * @author Sergio Arellano
 * @version 1.0.1
 * @since 24/11/2016
 */

public enum TipoError {
	APPLICATIVO("APP","Applicativo"), 
	REST("RES","Api Rest"), 
	GENERICO ("GEN","Generico");
	
	private String codice;
	private String descrizione;
	
	/**
	 * Constructore della classe
	 * 
	 * @param codice codice univoco per identificare un Tipo Errore.
	 * @param descrizione descrizione del Tipo Errore.
	 */
	
	private TipoError(final String codice, final String descrizione) {
		this.codice = codice;
		this.descrizione = descrizione;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	/**
	 * Constructore della classe
	 * 
	 * @param codice codice univoco errore.
	 * @return {@link TipoError} ritorna una instazia dal codice.
	 */
	
	public static TipoError getInstanceFromCode(String codice){
		TipoError instance = null;
		for (TipoError elem : TipoError.values()){
			if (elem.getCodice().equals(codice)){
				instance = elem;
				break;
			}
		}
		return instance;
	}
}
