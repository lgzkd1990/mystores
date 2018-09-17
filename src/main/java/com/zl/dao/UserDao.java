package com.zl.dao;

import com.zl.domain.User;

import java.sql.SQLException;

public interface UserDao {

    void save(User user) throws SQLException;

    User findByCode(String code) throws SQLException;

    void update(User user) throws SQLException;

    User login(String username, String password) throws SQLException;

    User findByUsername(String name) throws SQLException;
}
