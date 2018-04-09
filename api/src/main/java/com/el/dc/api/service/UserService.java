package com.el.dc.api.service;

import com.el.dc.api.dao.impl.UserDao;
import com.el.dc.api.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService {
    @Autowired
    UserDao userDao;

    public void addUser(String userName, String password){
        User user = new User();
        user.setLoginName(userName);
        user.setLoginPassword(password);
        userDao.persist(user);
    }
}
