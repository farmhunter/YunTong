package com.yuntong.service;

import java.util.List;

import com.yuntong.model.User;

public interface UserService {

	public void addOneUser (User addOne);
	
	public List<User> findAllUsers();
}
