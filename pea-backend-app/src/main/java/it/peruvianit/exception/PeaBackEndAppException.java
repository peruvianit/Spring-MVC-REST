package it.peruvianit.exception;

public class PeaBackEndAppException extends Exception {
	private static final long serialVersionUID = 7574202786025521677L;

	public PeaBackEndAppException() {
	}

	public PeaBackEndAppException(final String message) {
		super(message);
	}

	public PeaBackEndAppException(final Throwable cause) {
		super(cause);
	}

	public PeaBackEndAppException(final String message, final Throwable cause) {
		super(message, cause);
	}

	public PeaBackEndAppException(final String message, final Throwable cause, final boolean enableSuppression,
			final boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
}