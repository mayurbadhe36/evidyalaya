package com.app.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class CredentialDto {

	private String email;
	private String password;

	public CredentialDto(String mail, String password) {
		this.email = mail;
		this.password = password;
	}
}
