package com.app.userexam.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AccountResponseDto
{
	private String accountName;
	private String username;
}
