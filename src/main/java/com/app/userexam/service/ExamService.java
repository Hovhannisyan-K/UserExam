package com.app.userexam.service;

import com.app.userexam.dto.ExamResponseDto;
import com.app.userexam.entity.Account;

public interface ExamService
{
	ExamResponseDto validate(String accountName);
	
	void createExamForAccount(Account accountId);
}
