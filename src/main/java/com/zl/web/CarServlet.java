package com.zl.web;

import com.zl.domain.Cart;
import com.zl.domain.CartItem;
import com.zl.domain.Product;
import com.zl.service.impl.ProductServiceImpl;
import com.zl.utils.BaseServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

public class CarServlet extends BaseServlet {
    private Cart getCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
            request.setAttribute("cart", cart);
        }
        return cart;
    }

    public String addCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pid = request.getParameter("pid");
        Product product = null;
        try {
            product = new ProductServiceImpl().findBypid(pid);
            int count = Integer.parseInt(request.getParameter("count"));
            CartItem cartItem = new CartItem();
            cartItem.setProduct(product);
            cartItem.setCount(count);
            Cart cart = getCart(request);
            cart.add(cartItem);
            request.setAttribute("cart", cart);
        } catch (SQLException e) {
            e.printStackTrace();
            request.setAttribute("msg", "添加商品失败");
            return "/jsp/info.jsp";
        }
        return "/jsp/cart.jsp";
    }


    public String remove(HttpServletRequest request,HttpServletResponse response) throws IOException {
        String pid = request.getParameter("pid");
        Cart cart =getCart(request);
        response.sendRedirect(request.getContextPath()+"/jsp/cart.jsp");
        cart.remove(pid);
        return  null;
    }



    public String removeCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Cart cart = getCart(request);
        cart.clear();
        response.sendRedirect(request.getContextPath() + "/jsp/cart.jsp");
        return null;
    }
}
