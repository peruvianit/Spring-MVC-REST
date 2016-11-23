package it.peruvianit.builder;

import java.util.LinkedHashMap;

import it.peruvianit.exception.PeaCoreException;
import it.peruvianit.interfaces.IComponenti;

public interface ComponenteBuilder {
	IComponenti loadComponente(final String className, LinkedHashMap<String, Object> paramsComponente) throws PeaCoreException;
}
