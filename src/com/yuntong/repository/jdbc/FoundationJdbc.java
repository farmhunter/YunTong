package com.yuntong.repository.jdbc;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.yuntong.common.PageModel;
import com.yuntong.model.User;

/**
 * Created by mylover on 7/22/15.
 */
@Repository
public interface FoundationJdbc {

    public User findUserByUsername(String username);
    
    public void addOneUser(User addOneUser);
    
    public List<User> findAllUsers();

    public PageModel<User> findUsers(Map<String,Object> pageInfo);
}
