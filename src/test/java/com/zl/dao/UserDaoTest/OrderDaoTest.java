package com.zl.dao.UserDaoTest;

import com.zl.dao.OrderDao;
import com.zl.dao.ProductDao;
import com.zl.dao.UserDao;
import com.zl.dao.impl.OrderDaoImpl;
import com.zl.dao.impl.ProductDaoImpl;
import com.zl.dao.impl.UserDaoImpl;
import com.zl.domain.Orders;
import com.zl.domain.OrdersItem;
import com.zl.domain.Product;
import com.zl.domain.User;
import com.zl.utils.JDBCUtils;
import com.zl.utils.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class OrderDaoTest {
    public static Connection conn;

    static {
        try {
            conn = JDBCUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test() {
        OrderDao orderDao = new OrderDaoImpl();
        //ordersItem.getItemid(),ordersItem.getCount(),ordersItem.getSubtotal(),ordersItem.getProduct().getPid(),ordersItem.getOrders().getOid());
        ProductDao productDao = new ProductDaoImpl();
        Orders orders = new Orders();
        orders.setOid(UUIDUtils.getUUID());
        orders.setOrdertime("2018/08/20");
        orders.setState(0);
        orders.setAddress("12312");
        orders.setName("lgzkd");
        orders.setTelephone("18136775821");
        List<OrdersItem> ordersItems = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            ordersItems.add(new OrdersItem());
        }
        orders.setList(ordersItems);
        User user;
        try {
            UserDao userDao = new UserDaoImpl();
            user = new User();
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
            orders.setUser(user);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }


        try {
            conn.setAutoCommit(false);
            orderDao.save(orders, conn);
            List<OrdersItem> list = orders.getList();
            for (int index = 0; index < list.size(); index++) {
                Product product = productDao.findBypid(String.valueOf(index % 50 + 1));
                OrdersItem ordersItem = list.get(index);
                ordersItem.setCount(4);
                ordersItem.setProduct(product);
                ordersItem.setItemid(UUIDUtils.getUUID());
                ordersItem.setSubtotal(ordersItem.getCount() * ordersItem.getProduct().getShop_price());
                ordersItem.setOrders(orders);
                orderDao.saveOrdersItem(ordersItem, conn);
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
