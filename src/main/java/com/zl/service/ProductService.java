package com.zl.service;

import com.zl.domain.PageBean;
import com.zl.domain.Product;

import java.sql.SQLException;
import java.util.List;



public interface ProductService {

	PageBean findProduct(String cid, int pageNumber, int pageSize) throws Exception;

	Product findBypid(String pid) throws SQLException;

	List<Product> findHot() throws SQLException;
	List<Product> findNew() throws SQLException;

}
