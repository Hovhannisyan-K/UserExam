package com.app.userexam.service;

import com.app.userexam.dto.AccountResponseDto;
import com.app.userexam.dto.RoleDto;

public interface RoleService
{
	AccountResponseDto createAccountRole(RoleDto roleDto);
}
