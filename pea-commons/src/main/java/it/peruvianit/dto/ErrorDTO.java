package it.peruvianit.dto;

import java.io.Serializable;
import java.util.UUID;

import it.peruvianit.enums.TipoError;

public class ErrorDTO implements Serializable {
	private static final long serialVersionUID = -4941783613362060008L;

	private UUID UUIDError;
	private Integer codice;
	private String descrizione;
	private TipoError tipoError;
	private String causaEccezione;
	
	public UUID getUUIDError() {
		return UUIDError;
	}
	public void setUUIDError(final UUID uUIDError) {
		UUIDError = uUIDError;
	}
	public Integer getCodice() {
		return codice;
	}
	public void setCodice(final Integer codice) {
		this.codice = codice;
	}
	public String getDescrizione() {
		return descrizione;
	}
	public void setDescrizione(final String descrizione) {
		this.descrizione = descrizione;
	}
	public TipoError getTipoError() {
		return tipoError;
	}
	public void setTipoError(final TipoError tipoError) {
		this.tipoError = tipoError;
	}
	public String getCausaEccezione() {
		return causaEccezione;
	}
	public void setCausaEccezione(final String causaEccezione) {
		this.causaEccezione = causaEccezione;
	}
}
