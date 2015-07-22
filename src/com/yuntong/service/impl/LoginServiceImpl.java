package com.yuntong.service.impl;

import com.yuntong.model.User;
import com.yuntong.service.LoginService;
import org.springframework.stereotype.Service;

/**
 * Created by mylover on 7/22/15.
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Override
    public boolean checkUser(User user) {
        return true;
    }

}
