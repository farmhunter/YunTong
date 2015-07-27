package com.yuntong.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.yuntong.common.Foundation;
import com.yuntong.model.User;
import com.yuntong.service.UserService;


@Controller 
@RequestMapping(Foundation.MODULE_MAPPING_ROOT+"service/user")

public class UserController {

	private static Logger logger = LogManager.getLogger(UserController.class.getName());
	
	@Autowired
	private UserService userService;
	
	@ResponseBody
    @RequestMapping(value = "addUser", method = RequestMethod.POST)
	public ModelAndView addUser(
			@RequestParam("department") String department,
			@RequestParam("userName") String userName,	
			@RequestParam("userTrueName") String userTrueName,
			@RequestParam("userPhone") String userPhone,
			@RequestParam("userCardId") String userCardId,
			@RequestParam("password") String password,
			@RequestParam("password2") String password2
			
			//密码的比较放在jsp上了
			){
		User addOneUser = new User();
	//	addOneUser.setDepartment(department);
		addOneUser.setUsername(userName);
		addOneUser.setName(userTrueName);
		addOneUser.setUserPhone(userPhone);
		addOneUser.setUserIdCard(userCardId);
		addOneUser.setPassword(password);

		userService.addOneUser(addOneUser);
		String path = "Y_Index.jsp";
		
		ModelAndView model=new ModelAndView();
		RedirectView redirectView = new RedirectView("/yuntong/" + path);
		redirectView.setExpandUriTemplateVariables(false);
		model.setView(redirectView);
    	logger.info("end login");
	
		return model;
	} 
	
	@ResponseBody
	@RequestMapping(value = "findAllUsers", method = RequestMethod.GET)
	public ModelAndView findAllUsers() {

		List<User> list = new ArrayList<>();
		// List <User> roleList = new ArrayList<>();
		list = userService.findAllUsers();
		// roleList =
		String path = "JBZL/Y_CZY_1.jsp";
		logger.info("com in");

		/*
		 * ModelAndView model=new ModelAndView();
		 * model.addObject("Y_userinfopage1", list); RedirectView redirectView =
		 * new RedirectView("/yuntong/" + path);
		 * redirectView.setExpandUriTemplateVariables(false);
		 * model.setView(redirectView); logger.info("end login");
		 */
		ModelAndView model = new ModelAndView();
		model.addObject("Y_userinfopage1", list);
		model.setViewName("forward:/JBZL/Y_CZY_1.jsp");

		logger.info("end login");
		return model;
	}

}
