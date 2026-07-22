package com.incidentops.incidentops.exception;

import com.incidentops.incidentops.common.response.ApiResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(UserAlreadyExistsException.class)
	public ResponseEntity<ApiResponse<Void>> handleUserAlreadyExistsException(UserAlreadyExistsException ex) {

		ApiResponse<Void> response = ApiResponse.<Void>builder()
				.success(false)
				.message(ex.getMessage())
				.data(null)
				.build();

		return ResponseEntity
				.status(HttpStatus.CONFLICT)
				.body(response);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ApiResponse<Void>> handleUserNotFoundException(UserNotFoundException ex) {

		ApiResponse<Void> response = ApiResponse.<Void>builder()
				.success(false)
				.message(ex.getMessage())
				.data(null)
				.build();

		return ResponseEntity
				.status(HttpStatus.NOT_FOUND)
				.body(response);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ApiResponse<Void>> handleException(Exception ex) {

		ApiResponse<Void> response = ApiResponse.<Void>builder()
				.success(false)
				.message(ex.getMessage())
				.data(null)
				.build();

		return ResponseEntity
				.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(response);
	}
}
