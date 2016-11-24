package it.peruvianit.utils;

import com.google.gson.GsonBuilder;

public class GsonUtil {
	public GsonUtil(){};
	
	public static String objToJsonPrettyPrinting (final Object object){
		return new GsonBuilder().setPrettyPrinting().create().toJson(object);
	}
	
	public static String objToJson (final Object object){
		return new GsonBuilder().create().toJson(object);
	}
}
