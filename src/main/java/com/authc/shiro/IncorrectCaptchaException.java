package com.authc.shiro;

import javax.naming.AuthenticationException;

public class IncorrectCaptchaException extends AuthenticationException {
	private static final long serialVersionUID = 1L;
	private String message;

	public IncorrectCaptchaException() {
		super();
	}
	public IncorrectCaptchaException(String message) {
		super(message);
	}

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
