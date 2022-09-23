package com.app.userexam.security.filter;

import com.app.userexam.entity.Account;
import com.app.userexam.security.UserPrincipal;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.stream.Collectors;

@AllArgsConstructor
public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter
{
	
	private final AuthenticationManager authenticationManager;
	
	public static final int TOKEN_EXPIRATION = 86_400_000;
	public static final String SECRET = "THIS_IS_YOUR_SECRET";
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException
	{
		try
		{
			Account user = new ObjectMapper().readValue(request.getInputStream(), Account.class);
			return authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getUsername(), user.getPassword()));
		}
		catch (IOException e)
		{
			throw new RuntimeException("Unable to auth ", e);
		}
	}
	
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException
	{
		
		UserPrincipal userPrincipal = (UserPrincipal) authResult.getPrincipal();
		String issuer = request.getRequestURL().toString();
		String token = JWT.create().withSubject(userPrincipal.getUsername()).withExpiresAt(new Date(System.currentTimeMillis() + TOKEN_EXPIRATION))
						  .withClaim("roles", userPrincipal.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList())).withIssuer(issuer)
						  .sign(Algorithm.HMAC512(SECRET.getBytes()));
		
		response.getWriter().write(String.format("{\"token\":\"%s\"}", token));
		response.getWriter().flush();
	}
	
}
