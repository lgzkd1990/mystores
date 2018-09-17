package com.zl.dao.impl;

import com.zl.dao.OrderDao;
import com.zl.domain.Orders;
import com.zl.domain.OrdersItem;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.SQLException;

public class OrderDaoImpl implements OrderDao {
    @Override
    public void save(Orders orders, Connection con) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql="insert into orders values(?,?,?,?,?,?,?,?)";
        qr.update(con,sql, orders.getOid(),orders.getOrdertime(),orders.getTotal(),orders.getState(),orders.getAddress(),orders.getName(),orders.getTelephone(),orders.getUser().getUid());

    }


    @Override
    public void saveOrdersItem(OrdersItem ordersItem, Connection con) throws SQLException {
        QueryRunner qr = new QueryRunner();
        String sql="insert into orderitem values(?,?,?,?,?)";
        qr.update(con, sql,ordersItem.getItemid(),ordersItem.getCount(),ordersItem.getSubtotal(),ordersItem.getProduct().getPid(),ordersItem.getOrders().getOid());

    }
}
