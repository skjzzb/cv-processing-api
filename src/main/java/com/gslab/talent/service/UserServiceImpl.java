package com.gslab.talent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gslab.talent.model.User;
import com.gslab.talent.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepoObj;
	
	@Override
	public List<User> getAllUser() {
		
		return userRepoObj.findAll();
	}

	@Override
	public User getUserById(int userId) {
	
		return userRepoObj.findById(userId).orElse(null);
	}

	@Override
	public void createUser(User user) {
		userRepoObj.save(user);

	}

	@Override
	public void deleteById(int userId) {
		userRepoObj.deleteById(userId);

	}

	@Override
	public void updateUser(User user) {
		userRepoObj.save(user);

	}

}
