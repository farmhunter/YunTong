package com.yuntong.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.yuntong.common.PageModel;
import com.yuntong.model.User;
import com.yuntong.service.UserService;

@Controller
@RequestMapping(Foundation.MODULE_MAPPING_ROOT + "service/user")
public class UserController {

	private static Logger logger = LogManager.getLogger(UserController.class
			.getName());

	@Autowired
	private UserService userService;

	@ResponseBody
	@RequestMapping(value = "addUser", method = RequestMethod.POST)
	public ModelAndView addUser(@RequestParam("department") String department,
			@RequestParam("userName") String userName,
			@RequestParam("userTrueName") String userTrueName,
			@RequestParam("userPhone") String userPhone,
			@RequestParam("userCardId") String userCardId,
			@RequestParam("password") String password,
			@RequestParam("password2") String password2) {
		User addOneUser = new User();
		addOneUser.setUsername(userName);
		addOneUser.setName(userTrueName);
		addOneUser.setUserPhone(userPhone);
		addOneUser.setUserIdCard(userCardId);
		addOneUser.setPassword(password);
		addOneUser.setUserDate(new Date());
		
		userService.addOneUser(addOneUser);
		String path = "Y_Index.jsp";

		ModelAndView model = new ModelAndView();
		RedirectView redirectView = new RedirectView("/yuntong/" + path);
		redirectView.setExpandUriTemplateVariables(false);
		model.setView(redirectView);
		logger.info("end login");
		
		Long date = new Date().getTime();
		
		return model;
	}
	/*
	@ResponseBody
	@RequestMapping(value = "findAllUsers1", method = RequestMethod.GET)
	public ModelAndView findAllUsers1(
			@RequestParam(value = "page", required = false) Integer page,// 当前页
			@RequestParam(value = "limit", required = false) Integer limit,// 每页显示数
			@RequestParam(value = "searchType", required = false) String type) {

		Map<String, Object> pageContent = new HashMap<String, Object>();

		if (page != null && limit != null && type != null) {
			if (type.equals("firstPage")) {
				page = 1;
			} else if (type.equals("beforePage")) {
				page = page - 1;
			} else if (type.equals("nextPage")) {
				page = page + 1;
			} else if (type.equals("lastPage")) {
				page = 20;
			}
			pageContent.put("currentPage", page);
			pageContent.put("pageSize", limit);

		}

		List<User> list = new ArrayList<User>();
		list = userService.findAllUsers();
		logger.info("enter");

		Page<User> listPage = userService.findAllUser(pageContent);

		ModelAndView model = new ModelAndView();
		model.addObject("Y_userinfopage1", list);
		model.setViewName("forward:/JBZL/Y_CZY_1.jsp");
		// model.addObject("useList", listPage.getContent());
		logger.info("end");
		return model;
	}
	*/
	
	@ResponseBody
	@RequestMapping(value = "findAllUsers", method = RequestMethod.GET)
	public ModelAndView findAllUsers(
			@RequestParam(value = "page", required = false) Integer page,// 当前页
			@RequestParam(value = "limit", required = false) Integer limit,// 每页显示数
			@RequestParam(value = "searchType", required = false) String type,
			@RequestParam(value = "pageContent",required = false	)Integer tatalPage
			) {

		Map<String, Object> pageContent = new HashMap<String, Object>();

		if (page != null && limit != null && type != null) {
			if (type.equals("firstPage")) {
				page = 1;
			} else if (type.equals("beforePage")) {
				page = page - 1;
			} else if (type.equals("nextPage")) {
				page = page + 1;
			} else if (type.equals("lastPage")) {
				page = tatalPage;
			}
			pageContent.put("currentPage", (page-1));
			pageContent.put("pageSize", limit);

		}

		List<User> list = new ArrayList<User>();
		logger.info("enter");
/*
		Page<User> listPage = userService.findAllUser(pageContent);
		list = listPage.getContent();
*/
		PageModel<User> pageInformation = new PageModel<User>();
		pageInformation = userService.findAllUser(pageContent);
		ModelAndView model = new ModelAndView();
		model.addObject("useList", pageInformation.getPageInfo());
		model.addObject("pageInfo", pageInformation);
		model.setViewName("forward:/JBZL/Y_CZY_1.jsp");
		logger.info("end");
		return model;
	}
	
	public static void main(String[] args) {
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		Long date = new Date().getTime();
		System.out.println(sdf.format(date));
	}
	
}
