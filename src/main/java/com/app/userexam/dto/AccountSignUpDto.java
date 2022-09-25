package com.app.userexam.dto;

import lombok.Data;

import java.util.List;

@Data
public class AccountSignUpDto
{
	private String accountName;
	private String username;
	private String password;
	private List<Long> roles;
}
