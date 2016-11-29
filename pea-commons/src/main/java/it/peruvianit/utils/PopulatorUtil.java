package it.peruvianit.utils;

import io.github.benas.jpopulator.api.Populator;
import io.github.benas.jpopulator.impl.PopulatorBuilder;

public class PopulatorUtil {
	public PopulatorUtil(){};
	
	public static <T> T populateBean (Class<T> object){
		PopulatorBuilder builder = new PopulatorBuilder(); 
		Populator populator = builder.build();
		return (T) populator.populateBean(object);
	}
}
