package com.codewithgaurav.blog.exceptions;

import lombok.Getter;
import lombok.Setter;

@SuppressWarnings("serial")
@Getter
@Setter
public class ResourceNotFoundException extends RuntimeException {
	
	private String message;
	private Integer fieldValue;
	
	public ResourceNotFoundException(String message) {
		super(message);
		this.message = message;
	}
	
	public ResourceNotFoundException(String message, Integer fieldValue) {
		super(String.format("%s %s", message, fieldValue));
		//super(message + fieldValue);
		this.message = message;
		this.fieldValue = fieldValue;
	}
	
	
}
