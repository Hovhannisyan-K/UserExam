package com.app.userexam.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Account extends BaseEntity
{
	private String accountName;
	private String username;
	private String password;
	@ManyToMany
	private List<Role> roles;
}
