package com.app.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
@Entity
@Table(name = "userdetail")
public class User extends BaseEntity {

	@Column(length = 45)
	@NotBlank(message = "name is required")
	private String name;
	@Column(length = 45)
	@NotBlank(message = "address is required")
	private String address;
	@NotBlank(message = "dob is required")
	private LocalDate dob;
	@NotBlank(message = "password is required")
	private String password;
	private String email;
	@Column(name = "mobno")
	private String mobNo;
	@Enumerated
	@NotBlank(message = "role is required")
	private Role role;

}
