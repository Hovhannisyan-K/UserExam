package com.app.userexam.repository;

import com.app.userexam.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long>
{
}
