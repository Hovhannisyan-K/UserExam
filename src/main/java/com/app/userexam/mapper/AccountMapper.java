package com.app.userexam.mapper;

import com.app.userexam.dto.AccountResponseDto;
import com.app.userexam.dto.AccountSignUpDto;
import com.app.userexam.entity.Account;
import com.app.userexam.entity.Role;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class AccountMapper
{
	public Account mapFromDto(AccountSignUpDto signUpDto)
	{
		return Account.builder()
					  .name(signUpDto.getAccountName())
					  .roles(signUpDto.getRoles().stream().map(Role::new).collect(Collectors.toList()))
					  .username(signUpDto.getUsername())
					  .password(signUpDto.getPassword())
					  .build();
	}
	
	public AccountResponseDto mapFromAccount(Account account)
	{
		return AccountResponseDto.builder().accountName(account.getName()).username(account.getUsername()).build();
	}
}
