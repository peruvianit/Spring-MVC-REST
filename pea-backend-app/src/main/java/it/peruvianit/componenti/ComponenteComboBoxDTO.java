package it.peruvianit.componenti;

import java.util.LinkedHashMap;

import it.peruvianit.componente.BaseComponenteAbstract;
import it.peruvianit.enums.Componenti;

public class ComponenteComboBoxDTO extends BaseComponenteAbstract{
	private static final long serialVersionUID = -3131981471765698045L;

	@Override
	public ComponenteComboBoxDTO caricaComponente(LinkedHashMap<String, Object> paramsComponente) {
		ComponenteComboBoxDTO componenteComboBoxDTO = new ComponenteComboBoxDTO();
		componenteComboBoxDTO.setKey((String)paramsComponente.get("id"));
		componenteComboBoxDTO.setNome((String)paramsComponente.get("className"));
		
		return componenteComboBoxDTO;
	}

	@Override
	public Componenti getTipoComponente() {
		return Componenti.COMBO_BOX;
	}
}
