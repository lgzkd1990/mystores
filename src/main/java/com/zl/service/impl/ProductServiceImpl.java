package com.zl.service.impl;

import com.zl.dao.ProductDao;
import com.zl.dao.impl.ProductDaoImpl;
import com.zl.domain.PageBean;
import com.zl.domain.Product;
import com.zl.service.ProductService;

import java.sql.SQLException;
import java.util.List;

public class ProductServiceImpl implements ProductService {

	@Override
	public PageBean findProduct(String cid, int pageNumber, int pageSize) throws Exception
	{
		// 创建dao
		ProductDao productDao=new ProductDaoImpl();
		// 获取总条数
		int totalCount=productDao.findCount(cid);
		// 获取总页数
		int totalPage=0;  
		if(totalCount%pageSize==0)
		{
			totalPage=totalCount/pageSize;
		}else
		{
			totalPage=totalCount/pageSize+1;
		}
		// 获取每页显示的数据
		List<Product> list=productDao.findList(cid,(pageNumber-1)*pageSize,pageSize);
		
		
		// 创建pagebean 完成封装
		PageBean pb=new PageBean();
		pb.setPageNumber(pageNumber);
		pb.setPageSize(pageSize);
		pb.setTotalCount(totalCount);
		pb.setTotalPage(totalPage);
		pb.setList(list);
		
		return pb;
	
	}

	@Override
	public Product findBypid(String pid) throws SQLException
	{
		ProductDao productDao=new ProductDaoImpl();
		
		return productDao.findBypid(pid);
	}

	@Override
	public List<Product> findHot() throws SQLException {
		ProductDao productDao=new ProductDaoImpl();
		return productDao.findHot();
	}
	@Override
	public List<Product> findNew() throws SQLException {
		ProductDao productDao=new ProductDaoImpl();
		return productDao.findNew();
	}
}
