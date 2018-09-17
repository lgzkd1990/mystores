package com.zl.dao.impl;

import com.zl.dao.UserDao;
import com.zl.domain.User;
import com.zl.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

public class UserDaoImpl implements UserDao {
    /**
     * 新增用户
     *
     * @param user
     * @throws SQLException
     */
    @Override
    public void save(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "insert into user values(?,?,?,?,?,?,?,?,?,?)";
        Object[] obj = {user.getUid(), user.getUsername(), user.getPassword(), user.getName(), user.getEmail(), user.getTelphone(), user.getBirthday(), user.getSex(), user.getState(), user.getCode()};
        qr.update(sql, obj);
    }

    /**通过激活码查找用户
     * @param code
     * @return
     * @throws SQLException
     */
    @Override
    public User findByCode(String code) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from user where code=?";
        User user = qr.query(sql, new BeanHandler<User>(User.class), code);
        return user;
    }

    /**更新用户状态
     * @param user
     * @throws SQLException
     */
    @Override
    public void update(User user) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "update user set state=? where uid =?";
        qr.update(sql, user.getState(), user.getUid());
    }

    /**用户登录
     * @param username
     * @param password
     * @return
     * @throws SQLException
     */
    @Override
    public User login(String username, String password) throws SQLException {

        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from user where username=? and password=?";
        return qr.query(sql, new BeanHandler<User>(User.class), username, password);
    }

    /**
     * 通过用户名查找用户
     * @param name
     * @return
     */
    @Override
    public User findByUsername(String name) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from user where username=?";
        User user = qr.query(sql, new BeanHandler<User>(User.class), name);
        return user;
    }
}
