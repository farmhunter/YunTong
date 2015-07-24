package com.yuntong.service.impl;

import com.yuntong.model.User;
import com.yuntong.service.LoginService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

/**
 * Created by mylover on 7/22/15.
 */
@Service
public class LoginServiceImpl implements LoginService {

    Logger logger = LogManager.getLogger(LoginServiceImpl.class.getName());

    @Override
    public boolean checkUser(User user) {
        logger.info("checkUser begin");

        logger.info("checkUser end");
        return true;
    }

}
