package com.app.userexam.exceptions;

public class AccountNotFoundException extends RuntimeException
{
	public AccountNotFoundException(String message)
	{
		super(message);
	}
}
