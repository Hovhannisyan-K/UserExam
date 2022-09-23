package com.app.userexam.dto;

import lombok.Data;

import java.util.List;

@Data
public class RoleDto
{
	private List<Long> roleIds;
	private Long userId;
}
