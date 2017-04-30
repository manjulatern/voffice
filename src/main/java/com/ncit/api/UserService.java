package com.ncit.api;

import java.util.List;

import com.ncit.entity.User;

public interface UserService {

	// Returns true is user is valid
	public boolean isUserValid(User user);

	// Get list of users
	public List<User> getUserList();

	// Get User Information
	public User getUserDetail(User user);

	// Create a new user / Registration
	public boolean registerUser(User user);

	// Delete User
	public boolean deleteUser(User user);

	// Update User
	public boolean updateUser(User user);

}
