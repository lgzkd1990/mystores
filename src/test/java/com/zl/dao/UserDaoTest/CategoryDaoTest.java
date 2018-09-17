package com.zl.dao.UserDaoTest;

import com.zl.dao.CategoryDao;
import com.zl.dao.impl.CategoryDaoImpl;
import com.zl.domain.CateGory;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;

import static org.junit.Assert.*;

public class CategoryDaoTest {
    @Test
    public void findAllTest(){
        CategoryDao categoryDao = new CategoryDaoImpl();
        try {
            List<CateGory> cateGories = categoryDao.findAll();
            assertEquals(9,cateGories.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
