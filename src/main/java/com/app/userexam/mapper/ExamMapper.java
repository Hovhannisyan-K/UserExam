package com.app.userexam.mapper;

import com.app.userexam.dto.ExamResponseDto;
import com.app.userexam.entity.Exam;
import org.springframework.stereotype.Component;

@Component
public class ExamMapper
{
	public ExamResponseDto mapFromExam(Exam exam)
	{
		return ExamResponseDto.builder().accountName(exam.getAccount().getName()).score(exam.getScore()).isPassed(exam.isPassed()).build();
	}
}
