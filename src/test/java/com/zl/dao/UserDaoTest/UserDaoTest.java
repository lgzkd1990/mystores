package com.zl.dao.UserDaoTest;

import com.zl.dao.UserDao;
import com.zl.dao.impl.UserDaoImpl;
import com.zl.domain.User;
import com.zl.utils.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class UserDaoTest {

    @Test
    public void saveTest() {
        try {
            UserDao userDao = new UserDaoImpl();
            User user = new User();
            Map<String, Object> map = new HashMap<>();
            map.put("uid", UUIDUtils.getUUID());
            map.put("username", "lgzkd");
            map.put("password", "rootroot");
            map.put("name", "测试用户");
            map.put("email", "wodeshijie1234@126.com");
            //map.put("telphone", "15979192968");
            map.put("birthday", "20180816");
            map.put("sex", "男");
            map.put("state", 0);
            map.put("code", UUIDUtils.getUUID() + UUIDUtils.getUUID());
            BeanUtils.populate(user, map);
            userDao.save(user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Test
    public void findUserByCode() {
        UserDao userDao = new UserDaoImpl();
        try {
            User user1 = userDao.findByUsername("lgzkd");
            System.out.println("userpassword is " + user1.getPassword() + "code is " + user1.getCode());
            User user2 = userDao.findByCode(user1.getCode());
            System.out.println("userpassword is " + user2.getPassword() + "code is " + user2.getCode());
            if (user1.getPassword().equals(user2.getPassword())) {
                System.out.println("方法都正确");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void updateTest() {
        UserDao userDao = new UserDaoImpl();
        try {
            User user1 = userDao.findByUsername("lgzkd");
            System.out.println("userpassword is " + user1.getPassword() + "code is " + user1.getUid());
            User user2 = new User();
            user2.setUid(user1.getUid());
            user2.setState(1);
            userDao.update(user2);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void loginTest() {
        UserDao userDao = new UserDaoImpl();
        try {
            User user = userDao.login("lgzkd", "rootroot1");
            assertNull(user);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
