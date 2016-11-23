package it.peruvianit.dto;

import java.util.LinkedList;

import it.peruvianit.interfaces.IComponenti;

public class SezioneDTO {
	private LinkedList<IComponenti> linkedListIComponenti;

	public LinkedList<IComponenti> getLinkedListIComponenti() {
		return linkedListIComponenti;
	}

	public void setLinkedListIComponenti(LinkedList<IComponenti> linkedListIComponenti) {
		this.linkedListIComponenti = linkedListIComponenti;
	}
}
