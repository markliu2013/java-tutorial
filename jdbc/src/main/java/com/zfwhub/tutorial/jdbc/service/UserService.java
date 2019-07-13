package com.zfwhub.tutorial.jdbc.service;

import com.zfwhub.tutorial.jdbc.dao.UserDao;
import com.zfwhub.tutorial.jdbc.domain.User;

public class UserService {
    private UserDao userDao;

    public void regist(User user) {
        this.userDao.addUser(user);
        // sendMail.send(user);
    }
}
