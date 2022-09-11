package com.app.service;

import com.app.entities.User;

public interface IStudentService {

	User authenticateUser(String email, String password);

}
