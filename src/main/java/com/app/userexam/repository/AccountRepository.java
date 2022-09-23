package com.app.userexam.repository;

import com.app.userexam.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AccountRepository extends JpaRepository<Account, Long>
{
	Account findByUsername(String username);
	
	@Query("SELECT u from Account u JOIN FETCH u.roles where u.username = :username")
	Account findByUsernameFetchRoles(@Param("username") String username);
}
