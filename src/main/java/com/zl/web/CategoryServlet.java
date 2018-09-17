package com.zl.web;

import com.zl.service.CategoryService;
import com.zl.service.impl.CategoryServiceImpl;
import com.zl.utils.BaseServlet;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CategoryServlet", urlPatterns = {"/category"})
public class CategoryServlet extends BaseServlet {
    public String findCategory(HttpServletRequest request, HttpServletResponse response) {
        response.setCharacterEncoding("UTF-8");
        try {
            CategoryService categoryService = new CategoryServiceImpl();
            String json = categoryService.findAll();
            System.out.println(json);
            response.getWriter().print(json);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "查询数据失败..");
            return "/jsp/info.jsp";
        }
        return null;
    }
}
