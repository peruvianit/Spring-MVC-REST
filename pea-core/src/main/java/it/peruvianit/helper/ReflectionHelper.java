package it.peruvianit.helper;

import it.peruvianit.exception.PeaCoreException;

/**
 * Classe Helper
 * 
 * @author Sergio Arellano
 * @version 1.0.1
 * @since 17/11/2016
 */

public class ReflectionHelper {
	/**
	 * Metodo statico per la creazione tramite reflection di una instanzia
	 * di un Componente. 
	 * 
	 * @param className nome completo de la classe d'istanziare
	 * @exception PeaCoreException
	 * @return Object
	 */
	
	public static Object createObject(final String className) throws PeaCoreException {
	      Object object = null;
	      try {
	          Class<?> classDefinition = Class.forName(className);
	          object = classDefinition.newInstance();
	      } catch (InstantiationException e) {
	          throw new PeaCoreException(e);
	      } catch (IllegalAccessException e) {
	    	  throw new PeaCoreException(e);
	      } catch (ClassNotFoundException e) {
	    	  throw new PeaCoreException(e);
	      }
	      return object;
	}
}
