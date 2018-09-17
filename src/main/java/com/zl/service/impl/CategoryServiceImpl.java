package com.zl.service.impl;

import com.zl.dao.CategoryDao;
import com.zl.dao.impl.CategoryDaoImpl;
import com.zl.domain.CateGory;
import com.zl.service.CategoryService;
import com.zl.utils.JedisUtils;
import net.sf.json.JSONArray;
import redis.clients.jedis.Jedis;

import java.sql.SQLException;
import java.util.List;


public class CategoryServiceImpl implements CategoryService {

    @Override // 从mysql获取的
    public String findAll() throws SQLException {
        CategoryDao categoryDao = new CategoryDaoImpl();
        List<CateGory> list = categoryDao.findAll();
        // 把java的list 转成json数据
        // 转的是list和数组  --JSONArray
        // 转的是map和对象 --JSONObject
        JSONArray json = JSONArray.fromObject(list);
        return json.toString();
    }

    @Override // 从redis中获取
    public String fromByRedis() throws SQLException {
        // 都去redis中获取数据
        Jedis jedis = JedisUtils.getJedis();
        String value = jedis.get("dht");
        // 判断
        if (value == null) {
            // 从mysql中获取一份
            value = findAll();
            // 放在redis中
            jedis.set("dht", value);

            System.out.println("从mysql拿的");
            return value;
        }

        //能查到 直接返回
        System.out.println("从redis拿的");
        return value;
    }

}
