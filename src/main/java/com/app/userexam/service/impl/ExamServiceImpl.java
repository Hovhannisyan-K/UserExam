package com.app.userexam.service.impl;

import com.app.userexam.dto.ExamResponseDto;
import com.app.userexam.entity.Account;
import com.app.userexam.entity.Exam;
import com.app.userexam.exceptions.ExamNotFoundException;
import com.app.userexam.mapper.ExamMapper;
import com.app.userexam.repository.ExamRepository;
import com.app.userexam.service.ExamService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class ExamServiceImpl implements ExamService
{
	private final ExamRepository examRepository;
	private final ExamMapper examMapper;
	
	@Override
	public ExamResponseDto validate(String username)
	{
		final Exam examByAccountName = examRepository.findExamByAccountUsername(username);
		if (examByAccountName == null)
		{
			throw new ExamNotFoundException("Exam Not Found");
		}
		examByAccountName.setPassed(examByAccountName.getScore() > 5);
		return examMapper.mapFromExam(examByAccountName);
	}
	
	@Override
	public void createExamForAccount(Account account)
	{
		examRepository.save(new Exam(ThreadLocalRandom.current().nextInt(0, 10 + 1), true, account));
	}
}
