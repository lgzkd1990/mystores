package com.zl.web;

import com.zl.domain.*;
import com.zl.service.impl.OrderServiceImpl;
import com.zl.utils.BaseServlet;
import com.zl.utils.UUIDUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class OrderServlet extends BaseServlet {
    public  String addOrder(HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if(user == null){
            request.setAttribute("msg","请登录之后再操作");
            return "/jsp/info.jsp";
        }
        Orders orders = new Orders();
        orders.setOid(UUIDUtils.getUUID());
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-mm-dd");
        String date = dateFormat.format(new Date());
        orders.setOrdertime(date);
        orders.setUser(user);
        Cart cart = (Cart) session.getAttribute("cart");
        orders.setTotal(cart.getTotal());
        List<OrdersItem> ordersItems = new ArrayList<>();
        Map<String, CartItem> map = cart.getMap();
        for(String key:map.keySet()){
            OrdersItem ordersItem = new OrdersItem();
            ordersItem.setItemid(UUIDUtils.getUUID());
            ordersItem.setCount(map.get(key).getCount());
            ordersItem.setSubtotal(map.get(key).getSubtotal());
            ordersItem.setProduct(map.get(key).getProduct());
            ordersItem.setOrders(orders);
            ordersItems.add(ordersItem);
        }
        OrderServiceImpl orderService = new OrderServiceImpl();
        try {
            orderService.save(orders);
            request.setAttribute("orders",orders);//?????
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return "/jsp/order_info.jsp";
    }
}
