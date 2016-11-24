package it.peruvianit.enums;

/**
 * Classe enum per le tipologie di Componenti gestiti, la classe gestice le informazioni :
 * codice : codice univoco del Tipo Componente
 * descrizione : Descrizione del Tipo Componente
 * className : Classe del componente che sara utilizato como informazione del servizio
 * per instanziare la classe tramite reflection.
 *
 * 
 * @author Sergio Arellano
 * @version 1.0.1
 * @since 17/11/2016
 */

public enum Componenti {
	TEXTAREA("TA","Editor di testo","it.peruvianit.componenti.ComponenteTextAreaDTO"), 
	ALLEGATO ("UP","UP","it.peruvianit.componenti.ComponenteAllegatoDTO"), 
	COMBO_BOX ("CB","CB","it.peruvianit.componenti.ComponenteComboBoxDTO"), 
	MULTI_BOX ("MB","MB","it.peruvianit.componenti.ComponenteMultiBoxDTO");
	
	private String codice;
	private String descrizione;
	private String className;
	
	/**
	 * Constructore della classe
	 * 
	 * @param codice codice univoco per identificare un Tipo Componente.
	 * @param descrizione descrizione del Tipo Componente.
	 * @param className nome completo de la Classe Componente.
	 */
	
	private Componenti(final String codice, final String descrizione, final String className) {
		this.codice = codice;
		this.descrizione = descrizione;
		this.className = className;
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
	
	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	/**
	 * Constructore della classe
	 * 
	 * @param codice codice univoco Componente.
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
