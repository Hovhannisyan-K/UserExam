package com.app.userexam.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
public class Account extends BaseEntity
{
	private String accountName;
	private String username;
	private String password;
	@ManyToMany
	private List<Role> roles;
}
