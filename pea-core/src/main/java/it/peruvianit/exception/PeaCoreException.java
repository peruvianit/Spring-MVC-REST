package it.peruvianit.exception;
/**
 * Classe generica per la gestione di errori nel pea-core
 * 
 * @author Sergio Arellano
 * @version 1.0.1
 * @since 17/11/2016
 */

public class PeaCoreException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5343656408475786453L;

	public PeaCoreException() {
	}

	public PeaCoreException(final String message) {
		super(message);
	}

	public PeaCoreException(final Throwable cause) {
		super(cause);
	}

	public PeaCoreException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public PeaCoreException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}
