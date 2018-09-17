package com.zl.dao;

import com.zl.domain.Orders;
import com.zl.domain.OrdersItem;

import java.sql.Connection;
import java.sql.SQLException;

public interface OrderDao {

    void save(Orders orders, Connection con) throws SQLException;

    void saveOrdersItem(OrdersItem ordersItem, Connection con) throws SQLException;
}
