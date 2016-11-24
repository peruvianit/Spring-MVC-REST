package it.peruvianit.helper;

import java.util.UUID;

import org.apache.commons.lang3.exception.ExceptionUtils;

import it.peruvianit.dto.ErrorDTO;
import it.peruvianit.enums.TipoError;

public class ErrorHelper {
	public static ErrorDTO getErrorDTO(Exception exception){
		ErrorDTO errorDTO = new ErrorDTO();
		
		errorDTO.setUUIDError(UUID.randomUUID());
		errorDTO.setCodice(0); 
		errorDTO.setTipoError(TipoError.APPLICATIVO); 
		errorDTO.setDescrizione(ExceptionUtils.getRootCauseMessage(exception));
		errorDTO.setCausaEccezione(ExceptionUtils.getStackTrace(exception));
		
		return errorDTO;
	}

}
