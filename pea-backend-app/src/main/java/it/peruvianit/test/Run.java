package it.peruvianit.test;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import it.peruvianit.builder.ComponenteBuilder;
import it.peruvianit.builder.ComponenteBuilderImpl;
import it.peruvianit.componente.BaseComponenteAbstract;
import it.peruvianit.componenti.ContenitoreDTO;
import it.peruvianit.enums.Componenti;
import it.peruvianit.exception.PeaCoreException;
import it.peruvianit.interfaces.IComponenti;

public class Run {

	public static void main(String[] args) throws PeaCoreException {
		ComponenteBuilder componenteBuilder = new ComponenteBuilderImpl();

		List<String> componentiDaCaricare = new ArrayList<>();		
		componentiDaCaricare.add(Componenti.TEXTAREA.getClassName());
		componentiDaCaricare.add(Componenti.ALLEGATO.getClassName());	
		componentiDaCaricare.add(Componenti.COMBO_BOX.getClassName());
		componentiDaCaricare.add(Componenti.MULTI_BOX.getClassName());
		componentiDaCaricare.add(Componenti.TEXTAREA.getClassName());
		componentiDaCaricare.add(Componenti.ALLEGATO.getClassName());
		componentiDaCaricare.add(Componenti.ALLEGATO.getClassName());
		componentiDaCaricare.add(Componenti.ALLEGATO.getClassName());
		
		ContenitoreDTO contenitoreDTO = new ContenitoreDTO();
		contenitoreDTO.setKey("CONTENT");
		contenitoreDTO.setNome("CONTENT");
		
		int id = 1;
		for (String className : componentiDaCaricare) {
			LinkedHashMap<String, Object> paramsComponente = new LinkedHashMap<>();
			paramsComponente.put("id", String.valueOf(id));
			paramsComponente.put("className", className + "_" + id);
			
			Object componente = componenteBuilder.loadComponente(className, paramsComponente);
			System.out.println(((BaseComponenteAbstract)componente).getTipoComponente() + " -- " + 
							   ((BaseComponenteAbstract)componente).getInfo() + " -- " + 
							   ((BaseComponenteAbstract)componente).getInfoPermessi());
			
			contenitoreDTO.aggiungeComponente((IComponenti)componente);
			id++;
		}
		
		System.out.println(contenitoreDTO.getInfo() + " -- [" + contenitoreDTO.getComponenti().size()  + "] componente");
	}
}
