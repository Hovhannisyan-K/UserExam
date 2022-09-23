package com.app.userexam.security;

import com.app.userexam.exceptions.AccountNotFoundException;
import com.app.userexam.entity.Account;
import com.app.userexam.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
@Slf4j
public class CustomUserDetailsService implements UserDetailsService
{
	private final AccountRepository accountRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
	{
		Account existingAccount = accountRepository.findByUsernameFetchRoles(username);
		if (existingAccount == null)
		{
			log.info("Account not found by {}", username);
			throw new AccountNotFoundException("Account not found by " + username + " username");
		}
		return UserPrincipal.create(existingAccount);
	}
}
