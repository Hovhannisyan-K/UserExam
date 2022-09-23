package com.app.userexam.controller;

import com.app.userexam.dto.AccountLoginDto;
import com.app.userexam.dto.AccountResponseDto;
import com.app.userexam.dto.AccountSignUpDto;
import com.app.userexam.dto.RoleDto;
import com.app.userexam.service.AccountService;
import com.app.userexam.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin("app.front.url")
@RequiredArgsConstructor
public class AuthController
{
	private final AccountService accountService;
	private final RoleService roleService;
	
	@PostMapping("/login")
	public AccountResponseDto login(@RequestBody AccountLoginDto loginDto)
	{
		return accountService.login(loginDto);
	}
	
	@PostMapping("/create")
	public AccountResponseDto create(@RequestBody AccountSignUpDto account)
	{
		return accountService.createAccount(account);
	}
	
	@PostMapping("/role")
	public AccountResponseDto role(@RequestBody RoleDto roleDTO)
	{
		return roleService.createAccountRole(roleDTO);
	}
	
}
