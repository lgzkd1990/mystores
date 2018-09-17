package com.zl.service;

import java.sql.SQLException;

public interface CategoryService {

	String findAll() throws SQLException;

	String fromByRedis() throws SQLException;

}
