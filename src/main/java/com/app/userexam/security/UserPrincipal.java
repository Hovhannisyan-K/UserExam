package com.app.userexam.security;

import com.app.userexam.entity.Account;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.stream.Collectors;

public class UserPrincipal implements UserDetails
{
	private final String username;
	private final String password;
	private final Collection<? extends GrantedAuthority> authorities;
	
	public UserPrincipal(Account account)
	{
		this.username    = account.getUsername();
		this.password    = account.getPassword();
		this.authorities = account.getRoles().stream().map(
				role -> new SimpleGrantedAuthority("ROLE_".concat(role.getName())))
								  .collect(Collectors.toList());
	}
	
	public static UserPrincipal create(Account account)
	{
		return new UserPrincipal(account);
	}
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return authorities;
	}
	
	@Override
	public String getPassword()
	{
		return password;
	}
	
	@Override
	public String getUsername()
	{
		return username;
	}
	
	@Override
	public boolean isAccountNonExpired()
	{
		return true;
	}
	
	@Override
	public boolean isAccountNonLocked()
	{
		return true;
	}
	
	@Override
	public boolean isCredentialsNonExpired()
	{
		return true;
	}
	
	@Override
	public boolean isEnabled()
	{
		return true;
	}
}
