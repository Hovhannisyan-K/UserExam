package com.app.userexam.service;


import com.app.userexam.dto.AccountLoginDto;
import com.app.userexam.dto.AccountResponseDto;
import com.app.userexam.dto.AccountSignUpDto;

public interface AccountService
{
	AccountResponseDto register(AccountSignUpDto accountSignUpDto);
	
	AccountResponseDto login(AccountLoginDto loginDto);
	
}
