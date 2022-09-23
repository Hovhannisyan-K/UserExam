package com.app.userexam.repository;

import com.app.userexam.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role,Long>
{
}
