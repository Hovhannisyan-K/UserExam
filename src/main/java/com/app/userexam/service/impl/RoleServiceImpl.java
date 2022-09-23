package com.app.userexam.service.impl;

import com.app.userexam.dto.RoleDto;
import com.app.userexam.entity.Account;
import com.app.userexam.entity.Role;
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
	private final AccountRepository userRepository;
	
	public Account createUserRole(RoleDto roleDto)
	{
		Optional<Account> optionalAccount = userRepository.findById(roleDto.getUserId());
		if (optionalAccount.isEmpty()) throw new Error("Account does not exists!");
		List<Role> roles;
		roles = roleDto.getRoleIds().stream().map(Role::new).collect(Collectors.toList());
		Account user = optionalAccount.get();
		user.setRoles(roles);
		userRepository.save(user);
		return user;
	}
}
