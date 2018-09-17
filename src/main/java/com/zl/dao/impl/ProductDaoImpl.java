package com.zl.dao.impl;

import com.zl.dao.ProductDao;
import com.zl.domain.Product;
import com.zl.utils.JDBCUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

public class ProductDaoImpl implements ProductDao {
    /**
     * 查询类别下的产品数目
     * @param cid
     * @return
     * @throws SQLException
     */
    @Override
    public int findCount(String cid) throws SQLException
    {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql="select count(*) from product where cid=?";
        // ScalarHandler 针对的都是聚合函数   max min avg count sum
        Long l =(Long)qr.query(sql, new ScalarHandler(),cid);
        return l.intValue();
    }

    /**
     * 根据类别分页查询产品
     * @param cid
     * @param i
     * @param pageSize
     * @return
     * @throws SQLException
     */
    @Override
    public List<Product> findList(String cid, int i, int pageSize) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql="select * from product where cid=? limit ?,?";
        List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class),cid,i,pageSize);
        return list;
    }

    /**
     * 根据产品id查询产品
     * @param pid
     * @return
     * @throws SQLException
     */
    @Override
    public Product findBypid(String pid) throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql="select * from product where pid=?";
        Product product = qr.query(sql, new BeanHandler<Product>(Product.class),pid);
        return product;
    }

    /**产品
     * 查找热门
     * @return
     * @throws SQLException
     */
    @Override
    public List<Product> findHot() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql="select * from product where is_hot=0 and pflag=0 limit 0,9";
        List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class));
        return list;
    }
    /**产品
     * 查找最新
     * @return
     * @throws SQLException
     */
    @Override
    public List<Product> findNew() throws SQLException {
        QueryRunner qr = new QueryRunner(JDBCUtils.getDataSource());
        String sql="select * from product order by pdate desc limit 0,9" ;
        List<Product> list = qr.query(sql, new BeanListHandler<Product>(Product.class));
        return list;
    }
}
