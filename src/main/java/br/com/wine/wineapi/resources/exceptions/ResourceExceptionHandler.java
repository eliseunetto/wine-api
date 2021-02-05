package br.com.wine.wineapi.resources.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.wine.wineapi.services.exceptions.ObjectException;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectException e, HttpServletRequest request) {
		StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), System.currentTimeMillis(),
				e.getMessage());

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
}
