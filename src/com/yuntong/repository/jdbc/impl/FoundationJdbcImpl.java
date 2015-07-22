package com.yuntong.repository.jdbc.impl;

import com.yuntong.model.User;
import com.yuntong.repository.jdbc.FoundationJdbc;
import org.springframework.stereotype.Repository;

/**
 * Created by mylover on 7/22/15.
 */
@Repository
public class FoundationJdbcImpl implements FoundationJdbc {

    @Override
    public boolean checkUser(User user) {
        return true;
    }

}
