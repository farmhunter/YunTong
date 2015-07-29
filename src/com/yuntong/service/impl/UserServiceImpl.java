package com.yuntong.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yuntong.common.PageModel;
import com.yuntong.model.PageInf;
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
		int type = 2;
		if(type == 1){
			userList = userReponsity.findAll();
		}else{
			userList = foundationJdbc.findAllUsers();
		}
		return userList;
		
	}

	@Override
	public PageModel findAllUser(Map<String,Object> pageContent) {
		int type = 2;
		int page = (int)pageContent.get("currentPage");
		int limit = (int)pageContent.get("pageSize");
		//sort s=new Sort(Direction.DESC, "PublishTime");
		Sort sort = new Sort(Direction.ASC ,"id");
		Pageable pageable = new PageRequest(page,limit,sort);
		if (type == 1) {
			Page<User> pageUsers = userReponsity.findAll(pageable);
			PageModel <User> pageInformation = new PageModel<User>();
			pageInformation.setNumber((page+1));
			pageInformation.setSize(limit);
			pageInformation.setTotalElements(pageUsers.getTotalElements());
			pageInformation.setNumberOfElements(pageUsers.getNumberOfElements());
			pageInformation.setTotalPages(pageUsers.getTotalPages());
			pageInformation.setPageInfo(pageUsers.getContent());
			return pageInformation;
		} else {
			return foundationJdbc.findUsers(pageContent);
		}
	}
}
