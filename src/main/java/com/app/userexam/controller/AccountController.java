package com.app.userexam.controller;

import com.app.userexam.dto.ExamRequestDto;
import com.app.userexam.dto.ExamResponseDto;
import com.app.userexam.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/account")
@CrossOrigin("app.front.url")
@RequiredArgsConstructor
public class AccountController
{
	private final ExamService examService;
	
	@PreAuthorize("hasRole('USER')")
	@GetMapping
	public ExamResponseDto checkExamResult(@RequestBody ExamRequestDto examRequestDto)
	{
		return examService.validate(examRequestDto.getAccountName());
	}
}
