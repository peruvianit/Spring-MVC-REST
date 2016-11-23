package it.peruvianit.componente;

import java.io.Serializable;
import java.util.LinkedList;

import it.peruvianit.interfaces.IComponenti;

/**
 * Classe Abstratta IContenitoreAbtract che serve per contenere tutti componenti
 * inviati al client
 * 
 * @author Sergio Arellano
 * @version 1.0.1
 * @since 19/11/2016
 */

public abstract class BaseContenitoreAbstract extends BaseAbstract implements Serializable{
	private static final long serialVersionUID = -4360886059971913314L;
	
	private LinkedList<IComponenti> componenti = new LinkedList<>();

	// Methods Private
	
	public void aggiungeComponente(IComponenti componente){
		componenti.add(componente);
	}

	// Getters and Setters
	
	public LinkedList<IComponenti> getComponenti() {
		return componenti;
	}

	public void setComponenti(LinkedList<IComponenti> componenti) {
		this.componenti = componenti;
	}
}
