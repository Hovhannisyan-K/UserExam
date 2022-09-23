package com.app.userexam.service;


import com.app.userexam.dto.AccountLoginDto;
import com.app.userexam.dto.AccountResponseDto;
import com.app.userexam.dto.AccountSignUpDto;
import com.app.userexam.entity.Account;

public interface AccountService
{
	AccountResponseDto createAccount(AccountSignUpDto accountSignUpDto);
	
	AccountResponseDto login(AccountLoginDto loginDto);
	
}
