package it.peruvianit.componenti;

import java.util.LinkedHashMap;

import it.peruvianit.componente.BaseComponenteAbstract;
import it.peruvianit.enums.Componenti;

public class ComponenteMultiBoxDTO extends BaseComponenteAbstract{
	private static final long serialVersionUID = 1431926481617596465L;

	@Override
	public ComponenteMultiBoxDTO caricaComponente(LinkedHashMap<String, Object> paramsComponente) {
		ComponenteMultiBoxDTO componenteMultiBoxDTO = new ComponenteMultiBoxDTO();
		componenteMultiBoxDTO.setKey((String)paramsComponente.get("id"));
		componenteMultiBoxDTO.setNome((String)paramsComponente.get("className"));
		
		return componenteMultiBoxDTO;
	}

	@Override
	public Componenti getTipoComponente() {
		return Componenti.MULTI_BOX;
	}
}
