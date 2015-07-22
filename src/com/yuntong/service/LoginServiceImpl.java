package com.yuntong.service;

import com.yuntong.model.User;
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
