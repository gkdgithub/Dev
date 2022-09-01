package com.codewithgaurav.blog.exceptions;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.codewithgaurav.blog.response.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ApiResponse> resourceNotFoundException(ResourceNotFoundException ex) {

		ApiResponse apiResponse = new ApiResponse(ex.getMessage(), false, String.valueOf(HttpStatus.NOT_FOUND),
				String.valueOf(LocalDate.now() + ", " + LocalTime.now()));

		return new ResponseEntity<ApiResponse>(apiResponse, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleMethodArgumentNotValidException(
			MethodArgumentNotValidException ex) {

		Map<String, String> erroMap = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach(error -> {
			String fieldName = ((FieldError) error).getField();
			String errorMessage = error.getDefaultMessage();
			erroMap.put(fieldName, errorMessage);
		});
		return new ResponseEntity<Map<String, String>>(erroMap, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ResponseEntity<ApiResponse> handleHttpRequestMethodNotSupportedException(
			HttpRequestMethodNotSupportedException ex) {
		return new ResponseEntity<ApiResponse>(
				new ApiResponse(ex.getMessage(), false, String.valueOf(HttpStatus.METHOD_NOT_ALLOWED),
						String.valueOf(LocalDate.now() + ", " + LocalTime.now())),
				HttpStatus.METHOD_NOT_ALLOWED);
	}
}
