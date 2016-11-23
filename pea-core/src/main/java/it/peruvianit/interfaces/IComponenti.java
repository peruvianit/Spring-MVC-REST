package it.peruvianit.interfaces;

import java.util.LinkedHashMap;

import it.peruvianit.componente.BaseComponenteAbstract;

/**
 * Classe da implementare in tutti componenti 
 * 
 * @author Sergio Arellano
 * @version 1.0.1
 * @since 17/11/2016
 */

public interface IComponenti{
	/**
	 * Metodo abstracto che deve essere implementato per tutti componenti per 
	 * essere caricati tramite i servizi disponibili.
	 * 
	 * @return ComponenteDTO
	 */
	BaseComponenteAbstract caricaComponente(LinkedHashMap<String, Object> paramsComponente);
}
