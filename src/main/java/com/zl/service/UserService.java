package com.zl.service;

import com.zl.domain.User;

import java.sql.SQLException;

public interface UserService {
    void save(User user) throws SQLException;

    //User findById(String code) throws SQLException;

    void update(User user) throws SQLException;

    User login(String name, String password) throws SQLException;

    User findByCode(String code) throws SQLException;
}
