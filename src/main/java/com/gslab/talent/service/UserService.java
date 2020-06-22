package com.gslab.talent.service;

import java.util.List;

import com.gslab.talent.model.User;

public interface UserService {

	List<User> getAllUser();
	User getUserById(int userId);
	void createUser(User user);
	void deleteById(int userId);
	void updateUser(User user);
}
