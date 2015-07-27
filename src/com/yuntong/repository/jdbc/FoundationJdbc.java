package com.yuntong.repository.jdbc;

import java.util.List;

import com.yuntong.model.User;

import org.springframework.stereotype.Repository;

/**
 * Created by mylover on 7/22/15.
 */
@Repository
public interface FoundationJdbc {

    public User findUserByUsername(String username);
    
    public void addOneUser(User addOneUser);
    
    public List<User> findAllUsers();

}
