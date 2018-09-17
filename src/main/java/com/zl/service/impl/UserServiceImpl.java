package com.zl.service.impl;

import com.zl.dao.UserDao;
import com.zl.dao.impl.UserDaoImpl;
import com.zl.domain.User;
import com.zl.service.UserService;

import java.sql.SQLException;


public class UserServiceImpl implements UserService {
    /**
     * 添加用户
     * @param user
     * @throws SQLException
     */
    @Override
    public void save(User user) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        userDao.save(user);
    }

    /**
     * 更新用户信息
     * @param user
     * @throws SQLException
     */
    @Override
    public void update(User user) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        userDao.update(user);
    }

    /**
     * 用户登录
     * @param name
     * @param password
     * @return
     */
    @Override
    public User login(String name, String password) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        return  userDao.login(name,password);
    }

    /**
     * 通过激活码查找客户
     * @param code
     * @return
     * @throws SQLException
     */
    @Override
    public User findByCode(String code) throws SQLException {
        UserDao userDao = new UserDaoImpl();
        return userDao.findByCode(code);
    }
}
