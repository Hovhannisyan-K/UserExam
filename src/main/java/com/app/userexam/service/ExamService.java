package com.app.userexam.service;

import com.app.userexam.dto.ExamResponseDto;

public interface ExamService
{
	ExamResponseDto validate(String accountName);
}
