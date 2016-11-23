package it.peruvianit.componenti;

import java.util.LinkedHashMap;

import it.peruvianit.componente.BaseComponenteAbstract;
import it.peruvianit.enums.Componenti;

public class ComponenteTextAreaDTO extends BaseComponenteAbstract{
	private static final long serialVersionUID = -8604352920901534520L;

	@Override
	public ComponenteTextAreaDTO caricaComponente(LinkedHashMap<String, Object> paramsComponente) {
		ComponenteTextAreaDTO componenteTexttAreaDTO = new ComponenteTextAreaDTO();
		componenteTexttAreaDTO.setKey((String)paramsComponente.get("id"));
		componenteTexttAreaDTO.setNome((String)paramsComponente.get("className"));
		
		return componenteTexttAreaDTO;
	}

	@Override
	public Componenti  getTipoComponente() {
		return Componenti.TEXTAREA;
	}
}
