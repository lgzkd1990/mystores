package com.zl.web;

import com.zl.domain.PageBean;
import com.zl.domain.Product;
import com.zl.service.ProductService;
import com.zl.service.impl.ProductServiceImpl;
import com.zl.utils.BaseServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet(name="ProductServlet",urlPatterns ={"/product"})
public class ProductServlet extends BaseServlet {

    public String findProduct(HttpServletRequest request, HttpServletResponse response) {
        try {

            String cid = request.getParameter("cid");
            int pageNumber = Integer.parseInt(request.getParameter("pageNumber"));
            int pageSize = 12;
            ProductService productService = new ProductServiceImpl();
            PageBean pb = productService.findProduct(cid, pageNumber, pageSize);
            request.setAttribute("cid", cid);
            request.setAttribute("pb", pb);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "查询失败...");
            return "/jsp/info.jsp";
        }
        return "/jsp/product_list.jsp";
    }

    public String findBypid(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String pid = request.getParameter("pid");
            ProductService productService = new ProductServiceImpl();
            Product product = productService.findBypid(pid);
            request.setAttribute("product", product);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "查询单个商品详情失败..");
            return "/jsp/info.jsp";
        }
        return "/jsp/product_info.jsp";
    }

    // 查热门和最新商品
    public String findList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            ProductService productService = new ProductServiceImpl();
            List<Product> hotList = productService.findHot();
            // 查最新 (作用)
            List<Product> newList=productService.findNew();
            // 封装热门和最新到/jsp/index.jsp页面展示
            request.setAttribute("hotList", hotList);
            request.setAttribute("newList", newList);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/jsp/index.jsp";
    }
}
