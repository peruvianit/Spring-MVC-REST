package it.peruvianit.builder;
import java.util.LinkedHashMap;

import it.peruvianit.exception.PeaCoreException;
import it.peruvianit.helper.ReflectionHelper;
import it.peruvianit.interfaces.IComponenti;

/**
 * Classe ComponenteBuilderImpl carica tutti componeti richiesti nella List
 * 
 * @author Sergio Arellano
 * @version 1.0.1
 * @since 17/11/2016
 */

public class ComponenteBuilderImpl implements ComponenteBuilder {
	
	public IComponenti loadComponente(final String className, LinkedHashMap<String, Object> paramsComponente) throws PeaCoreException{
		IComponenti componente = getInstanceIComponente(className);
		return (IComponenti)componente.caricaComponente(paramsComponente);
	}
	
	private final IComponenti getInstanceIComponente(final String className) throws PeaCoreException{
		return (IComponenti)ReflectionHelper.createObject(className);
	}
}
