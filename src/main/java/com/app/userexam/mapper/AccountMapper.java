package com.app.userexam.mapper;

import com.app.userexam.dto.AccountResponseDto;
import com.app.userexam.dto.AccountSignUpDto;
import com.app.userexam.entity.Account;
import org.springframework.stereotype.Component;

@Component
public class AccountMapper
{
	public Account mapFromDto(AccountSignUpDto signUpDto)
	{
		return Account.builder()
					  .accountName(signUpDto.getAccountName())
					  .roles(signUpDto.getRoles())
					  .username(signUpDto.getUsername())
					  .password(signUpDto.getPassword())
					  .build();
	}
	
	public AccountResponseDto mapFromAccount(Account account)
	{
		return AccountResponseDto.builder().accountName(account.getAccountName()).username(account.getUsername()).build();
	}
}
