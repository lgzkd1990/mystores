package com.zl.dao;

import com.zl.domain.Product;

import java.sql.SQLException;
import java.util.List;

public interface ProductDao {
    int findCount(String cid) throws SQLException;

    List<Product> findList(String cid, int i, int pageSize) throws SQLException;

    Product findBypid(String pid) throws SQLException;

    List<Product> findHot() throws SQLException;

    List<Product> findNew() throws SQLException;

    ;
}


