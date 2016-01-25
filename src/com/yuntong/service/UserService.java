package com.yuntong.service;

import java.util.List;
import java.util.Map;

import com.yuntong.common.PageModel;
import com.yuntong.model.User;

public interface UserService {

	public void addOneUser (User addOne);
	
	public List<User> findAllUsers();

	public PageModel<User> findAllUser(Map<String,Object> pageContent);
}
