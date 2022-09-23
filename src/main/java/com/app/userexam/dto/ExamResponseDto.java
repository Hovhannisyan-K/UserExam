package com.app.userexam.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ExamResponseDto
{
	private int score;
	private boolean isPassed;
	private String accountName;
}
