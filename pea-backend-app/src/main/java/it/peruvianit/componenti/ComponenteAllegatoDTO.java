package it.peruvianit.componenti;

import java.util.LinkedHashMap;

import it.peruvianit.componente.BaseComponenteAbstract;
import it.peruvianit.enums.Componenti;

public class ComponenteAllegatoDTO extends BaseComponenteAbstract{
	private static final long serialVersionUID = 3332800403192068584L;

	@Override
	public ComponenteAllegatoDTO caricaComponente(LinkedHashMap<String, Object> paramsComponente) {
		ComponenteAllegatoDTO componenteAllegatoDTO = new ComponenteAllegatoDTO();
		componenteAllegatoDTO.setKey((String)paramsComponente.get("id"));
		componenteAllegatoDTO.setNome((String)paramsComponente.get("className"));
		
		return componenteAllegatoDTO;
	}

	@Override
	public Componenti getTipoComponente() {
		return Componenti.ALLEGATO;
	}
}
