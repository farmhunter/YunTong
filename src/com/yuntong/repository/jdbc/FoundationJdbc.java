package com.yuntong.repository.jdbc;

import com.yuntong.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by mylover on 7/22/15.
 */
@Repository
public interface FoundationJdbc {

    public boolean checkUser(User user);

}