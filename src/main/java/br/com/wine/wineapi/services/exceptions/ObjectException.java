package br.com.wine.wineapi.services.exceptions;

public class ObjectException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ObjectException(String message, Throwable cause) {
		super(message, cause);
	}

	public ObjectException(String message) {
		super(message);
	}

}
