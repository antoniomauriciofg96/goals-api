package br.com.fiap.rm335913.goals.configuration;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.fiap.rm335913.goals.response.ErrorResponse;
import br.com.fiap.rm335913.goals.response.ResponseApiError;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(ResponseApiError.class)
	public ResponseEntity<ErrorResponse> exceptionHandlerResponseApiError(ResponseApiError ex) {
		ErrorResponse error = new ErrorResponse();
		error.setErrorCode(ex.getResponseCode());
		error.setMessage(ex.getErrorMessage());
		return new ResponseEntity<ErrorResponse>(error, HttpStatus.valueOf(ex.getResponseCode()));
	}

	@ExceptionHandler(value = { TransactionSystemException.class })
	public ResponseEntity<ErrorResponse> exceptionTransactionSystemException(TransactionSystemException ex) {
		Throwable t = ex.getCause();
		if (t.getCause() instanceof ConstraintViolationException) {

			ErrorResponse error = new ErrorResponse();
			error.setErrorCode(HttpServletResponse.SC_BAD_REQUEST);

			StringBuilder messages = new StringBuilder();

			error.setMessage(messages.toString());
			return new ResponseEntity<ErrorResponse>(error, HttpStatus.BAD_REQUEST);

		} else {
			ErrorResponse error = new ErrorResponse();
			error.setErrorCode(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
			error.setMessage(ex.getMessage());
			return new ResponseEntity<ErrorResponse>(error, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

}
