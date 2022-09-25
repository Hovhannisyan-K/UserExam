package com.app.userexam.service.impl;

import com.app.userexam.dto.AccountLoginDto;
import com.app.userexam.dto.AccountResponseDto;
import com.app.userexam.dto.AccountSignUpDto;
import com.app.userexam.dto.RoleDto;
import com.app.userexam.entity.Account;
import com.app.userexam.exceptions.AccountExistsException;
import com.app.userexam.mapper.AccountMapper;
import com.app.userexam.repository.AccountRepository;
import com.app.userexam.service.AccountService;
import com.app.userexam.service.ExamService;
import com.app.userexam.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService
{
	private final AccountRepository accountRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	private final AccountMapper accountMapper;
	private final RoleService roleService;
	private final ExamService examService;
	
	@Override
	public AccountResponseDto register(AccountSignUpDto accountSignUpDto)
	{
		final Account account = accountRepository.findByUsername(accountSignUpDto.getUsername());
		if (account != null)
		{
			throw new AccountExistsException("Account already exists");
		}
		accountSignUpDto.setPassword(passwordEncoder.encode(accountSignUpDto.getPassword()));
		final Account save = accountRepository.save(accountMapper.mapFromDto(accountSignUpDto));
		roleService.createAccountRole(new RoleDto(accountSignUpDto.getRoles(), save.getId()));
		examService.createExamForAccount(save);
		return accountMapper.mapFromAccount(save);
	}
	
	@Override
	public AccountResponseDto login(AccountLoginDto loginDto)
	{
		final Account account = accountRepository.findByUsername(loginDto.getUsername());
		if (account == null)
		{
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
		if (passwordEncoder.matches(loginDto.getPassword(), account.getPassword()))
		{
			return accountMapper.mapFromAccount(account);
		}
		else
		{
			throw new ResponseStatusException(HttpStatus.UNAUTHORIZED);
		}
	}
}
