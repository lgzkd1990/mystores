package com.zl.dao;

import com.zl.domain.CateGory;

import java.sql.SQLException;
import java.util.List;

public interface CategoryDao {

	List<CateGory> findAll() throws SQLException;

}
