package com.app.userexam.exceptions;

public class AccountExistsException extends RuntimeException
{
	public AccountExistsException(String message)
	{
		super(message);
	}
}
