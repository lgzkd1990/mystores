package com.zl.service.impl;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.zl.dao.OrderDao;
import com.zl.dao.impl.OrderDaoImpl;
import com.zl.domain.Orders;
import com.zl.domain.OrdersItem;
import com.zl.service.OrderService;
import com.zl.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrderServiceImpl implements OrderService {
    @Override
    public void save(Orders orders) throws SQLException {
        Connection conn = null;
        try {
            OrderDao orderDao = new OrderDaoImpl();
            conn = JDBCUtils.getConnection();
            conn.setAutoCommit(false);
            orderDao.save(orders,conn);
            List<OrdersItem> ordersItems = new ArrayList<>();
            for(OrdersItem ordersItem:ordersItems){
                orderDao.saveOrdersItem(ordersItem,conn);
            }
            conn.commit();
        } catch (SQLException e) {
            e.printStackTrace();
            conn.rollback();//回滚事务
        }
    }
}
