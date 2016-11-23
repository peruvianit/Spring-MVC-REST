package it.peruvianit.componente;

import java.io.Serializable;

import it.peruvianit.interfaces.IComponenti;

/**
 * Classe BaseComponenteAbtract che extendeno tutti componenti creati
 * 
 * @author Sergio Arellano
 * @version 1.0.1
 * @since 17/11/2016
 */

public abstract class BaseComponenteAbstract extends BaseAbstract implements IComponenti, Serializable{
	private static final long serialVersionUID = 2437218058758073845L;
	
	public abstract Enum<?> getTipoComponente();
}
