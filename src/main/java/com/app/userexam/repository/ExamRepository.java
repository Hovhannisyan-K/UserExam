package com.app.userexam.repository;

import com.app.userexam.entity.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepository extends JpaRepository<Exam, Long>
{
}
