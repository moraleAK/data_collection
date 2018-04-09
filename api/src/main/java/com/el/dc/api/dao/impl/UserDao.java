package com.el.dc.api.dao.impl;

import com.el.dc.api.database.dao.GenericDaoImpl;
import com.el.dc.api.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao extends GenericDaoImpl<User, Long> {
    @Override
    protected Class<User> getDomainClass() {
        return null;
    }
}
