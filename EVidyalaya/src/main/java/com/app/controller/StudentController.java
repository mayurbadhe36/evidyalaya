package com.app.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.CredentialDto;
import com.app.entities.User;
import com.app.service.IStudentService;

@RestController
@RequestMapping("/Student")
public class StudentController {

	@Autowired
	IStudentService studentService;

	@PostMapping
	public ResponseEntity<HashMap<String, Object>> authenticateUser(@RequestBody CredentialDto cred) {
		User u = studentService.authenticateUser(cred.getEmail(), cred.getPassword());
		if (u == null)
			throw new RuntimeException("Wrong email id or password");
		HashMap<String, Object> ht = new HashMap<String, Object>();
		ht.put("status", new String("success"));
		ht.put("data", u);
		return ResponseEntity.ok(ht);
	}

}
