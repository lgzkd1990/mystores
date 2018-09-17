package com.zl.dao.impl;

import com.zl.dao.CategoryDao;
import com.zl.domain.CateGory;
import com.zl.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CategoryDaoImpl implements CategoryDao {
    @Override
    public List<CateGory> findAll() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql = "select * from category";
        List<CateGory> list = qr.query(sql, new BeanListHandler<CateGory>(CateGory.class));
        return list;
    }
}
