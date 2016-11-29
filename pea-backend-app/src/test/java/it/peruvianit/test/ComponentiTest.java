package it.peruvianit.test;
import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.junit.Test;

import it.peruvianit.builder.ComponenteBuilder;
import it.peruvianit.builder.ComponenteBuilderImpl;
import it.peruvianit.componenti.ContenitoreDTO;
import it.peruvianit.enums.Componenti;
import it.peruvianit.exception.PeaCoreException;

public class ComponentiTest {
	@Test
	public void CreazioneComponentiTest() {		
		ComponenteBuilder componenteBuilder = new ComponenteBuilderImpl();

		List<String> componentiDaCaricare = new ArrayList<>();		
		componentiDaCaricare.add(Componenti.TEXTAREA.getClassName());
		componentiDaCaricare.add(Componenti.ALLEGATO.getClassName());	
		componentiDaCaricare.add(Componenti.COMBO_BOX.getClassName());
		componentiDaCaricare.add(Componenti.MULTI_BOX.getClassName());
		
		ContenitoreDTO contenitoreDTO = new ContenitoreDTO();
		contenitoreDTO.setKey("CONTENT");
		contenitoreDTO.setNome("CONTENT");
		
		int id = 1;
		for (String className : componentiDaCaricare) {
			@SuppressWarnings("unused")
			Object componente;
			try {
				LinkedHashMap<String, Object> paramsComponente = new LinkedHashMap<>();
				paramsComponente.put("id", String.valueOf(id));
				paramsComponente.put("className", className + "_" + id);
				
				componente = componenteBuilder.loadComponente(className, paramsComponente);
				
				id++;
			} catch (PeaCoreException e) {
				fail("Problemi con la creazione del componente : " + className);
			}
		}
	}
}
