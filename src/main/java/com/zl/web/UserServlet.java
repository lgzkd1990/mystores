package com.zl.web;

import com.zl.domain.User;
import com.zl.service.UserService;
import com.zl.service.impl.UserServiceImpl;
import com.zl.utils.BaseServlet;
import com.zl.utils.MailUtils;
import com.zl.utils.UUIDUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.Map;

@WebServlet(name="UserServlet", urlPatterns={"/user"})
public class UserServlet extends BaseServlet {

    public String registerUI(HttpServletRequest request, HttpServletResponse response) {
        return "/jsp/register.jsp";
    }

    public String loginUI(HttpServletRequest request, HttpServletResponse response) {
        return "/jsp/login.jsp";
    }

    /**
     * 用户注册
     * @param request
     * @param response
     * @return
     */
    public String register(HttpServletRequest request, HttpServletResponse response) {
        try {
            Map<String, String[]> map = request.getParameterMap();
            User user = new User();
            BeanUtils.populate(user, map);
            user.setUid(UUIDUtils.getUUID());
            user.setState(0);
            user.setCode(UUIDUtils.getUUID() + UUIDUtils.getUUID());
            UserService userService = new UserServiceImpl();
            userService.save(user);
            String email = user.getEmail();
            String emailMsg = "这是一封激活邮件,请<a href=http://localhost:8080/user?method=active&code=" + user.getCode() + ">点击激活" + user.getCode() + "</a>";
            MailUtils.sendMail(email, emailMsg);
            request.setAttribute("msg", "亲,注册成功啦,赶快去激活吧..");
        } catch (Exception e) {
            e.printStackTrace(); //会记录到日志
            // 跳到一个页面 告诉失败
            request.setAttribute("msg", "注册失败,请稍后重试..");
            return "/jsp/info.jsp";
        }
        return "/jsp/info.jsp";
    }

    //用户激活
    public String active(HttpServletRequest request, HttpServletResponse response) {
        try {
            String code = request.getParameter("code");
            UserService userService = new UserServiceImpl();
            User user = userService.findByCode(code);
            if (user == null) {
                request.setAttribute("msg", "亲,激活失效已经过期了,需要你重新注册...");
                return "/jsp/info.jsp";
            }
            user.setState(1);
            userService.update(user);
            request.setAttribute("msg", "亲,激活成功,请去登录吧...");
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("msg", "激活失败,请稍后重试..");
            return "/jsp/info.jsp";
        }
        return "/jsp/info.jsp";
    }

    // 用户登录
    public String login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            // 获取用户名或者密码
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            // 根据用户名和密码取数据库中查询该用户
            UserService userService = new UserServiceImpl();
            User user = userService.login(username, password);
            // 判断用户
            if (user == null) {
                // 为空---去login.jsp页面提示不存在
                request.setAttribute("msg", "用户名或者密码错误");
                return "/jsp/login.jsp";
            }
            // 不为空 ----加一个判断用户是否激活
            if (user.getState() != 1) {
                // 没激活 --继续做提示
                request.setAttribute("msg", "亲,你还没有激活,请先去邮箱激活再来登录..");
                return "/jsp/info.jsp";
            }
            // 已激活 --放在session中 到首页显示该用户信息
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            // 重定向  需要加项目名
            // request.getContextPath() 获取当前项目的项目名称
            response.sendRedirect(request.getContextPath() + "/jsp/index.jsp");
        } catch (Exception e) {
            e.printStackTrace(); //会记录到日志
            // 跳到一个页面 告诉失败
            request.setAttribute("msg", "登录失败...");
            return "/jsp/info.jsp";
        }
        return null;
    }

    // 用户退出
    public String quit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取session
        HttpSession session = request.getSession();
        // 删除session的user的key
        session.removeAttribute("user");
        // 重新走首页
        response.sendRedirect(request.getContextPath() + "/jsp/index.jsp");
        return null;
    }
}
