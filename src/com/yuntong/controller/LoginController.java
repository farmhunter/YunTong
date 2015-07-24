package com.yuntong.controller;

import com.yuntong.common.Foundation;
import com.yuntong.service.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by mylover on 7/24/15.
 */
@Controller
@RequestMapping(Foundation.MODULE_MAPPING_ROOT + "service/")
public class LoginController {

    private static Logger logger = LogManager.getLogger(LoginController.class.getName());

    @Autowired
    private LoginService loginService;

    @ResponseBody
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public ModelAndView login(){

        return null;
    }
}
