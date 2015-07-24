package com.yuntong.repository.jdbc.impl;

import com.ibatis.sqlmap.client.SqlMapClient;
import com.yuntong.model.User;
import com.yuntong.repository.jdbc.FoundationJdbc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;
import org.springframework.stereotype.Repository;

/**
 * Created by mylover on 7/22/15.
 */
@Repository
public class FoundationJdbcImpl extends SqlMapClientDaoSupport implements FoundationJdbc {

    @Autowired
    public FoundationJdbcImpl(SqlMapClient sqlMapClient) {
        this.setSqlMapClient(sqlMapClient);
    }

    @Override
    public boolean checkUser(User user) {
        return true;
    }

}
