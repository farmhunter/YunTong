package com.yuntong.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuntong.model.User;
import com.yuntong.repository.jdbc.FoundationJdbc;
import com.yuntong.repository.jpa.UserRepository;
import com.yuntong.service.UserService;

@Service
@Transactional(readOnly = true)
public class UserServiceImpl implements UserService {
	
	@Autowired
	private FoundationJdbc  foundationJdbc;
	@Autowired
	private UserRepository userReponsity;

	
	@Override
	@Transactional(readOnly = false)
	public void addOneUser(User addOne) {
		
		int type = 2;
		if(type==1){
			foundationJdbc.addOneUser(addOne);
		}else{
			userReponsity.save(addOne);
		}
	}
	
	@Override
	public List<User> findAllUsers(){
		List<User> userList = new ArrayList<User>();
		int type = 1;
		if(type == 1){
			userList = userReponsity.findAll();
		}else{
			userList = foundationJdbc.findAllUsers();
		}
		return userList;
		
	}
}
