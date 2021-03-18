package com.financialomejor.exceptions;

public class InternalServerErrorExceptionDTO {
	private String message;
	private boolean error;
	
	public InternalServerErrorExceptionDTO(String message, boolean error) {
		this.message = message;
		this.error = error;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isError() {
		return error;
	}

	public void setError(boolean error) {
		this.error = error;
	}	
	
}
