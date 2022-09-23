package com.app.userexam.service.impl;

import com.app.userexam.repository.AccountRepository;
import com.app.userexam.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService
{
	private final AccountRepository accountRepository;
}
