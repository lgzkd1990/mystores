package com.zl.service;

import com.zl.domain.Orders;

import java.sql.SQLException;

public interface OrderService {
    public void save(Orders orders) throws SQLException;
}
