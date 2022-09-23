package com.app.userexam.service.impl;

import com.app.userexam.dto.AccountResponseDto;
import com.app.userexam.dto.RoleDto;
import com.app.userexam.entity.Account;
import com.app.userexam.entity.Role;
import com.app.userexam.mapper.AccountMapper;
import com.app.userexam.repository.AccountRepository;
import com.app.userexam.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService
{
	private final AccountMapper accountMapper;
	private final AccountRepository userRepository;
	@Override
	public AccountResponseDto createAccountRole(RoleDto roleDto)
	{
		Optional<Account> optionalAccount = userRepository.findById(roleDto.getUserId());
		if (optionalAccount.isEmpty()) throw new Error("Account does not exists!");
		List<Role> roles;
		roles = roleDto.getRoleIds().stream().map(Role::new).collect(Collectors.toList());
		Account account = optionalAccount.get();
		account.setRoles(roles);
		userRepository.save(account);
		return accountMapper.mapFromAccount(account);
	}
}
