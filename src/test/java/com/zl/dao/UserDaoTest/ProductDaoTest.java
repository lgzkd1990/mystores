package com.zl.dao.UserDaoTest;

import com.zl.dao.ProductDao;
import com.zl.dao.impl.ProductDaoImpl;
import com.zl.domain.Product;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class ProductDaoTest {

    @Test
    public void findCountTest() {
        ProductDao productDao = new ProductDaoImpl();
        try {
            int count = productDao.findCount("1");
            assertEquals(30, count);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findListTest() {
        ProductDao productDao = new ProductDaoImpl();
        try {
            List<Product> products = productDao.findList("2", 11, 10);
            assertNotNull(products);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findBypidTest() {
        ProductDao productDao = new ProductDaoImpl();
        try {
            Product products = productDao.findBypid("20");
            assertNotNull(products);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findHotTest() {
        ProductDao productDao = new ProductDaoImpl();
        try {
            List<Product> products = productDao.findHot();
            assertNotNull(products);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
