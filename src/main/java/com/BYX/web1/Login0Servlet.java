package com.BYX.web1;/*
   Author   Bai YanXu
   Date    2022-10-03 - 13:16
*/

import com.BYX.pojo.user;
import com.BYX.service.userService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet("/login0Servlet")
public class Login0Servlet extends HttpServlet {
    private userService userService=new userService();
    private String passwordNEW;
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String userKind = request.getParameter("user-category");
        String remember = request.getParameter("remember");
        //计算密码的MD5值
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(password.getBytes());
            StringBuilder bud=new StringBuilder();
            for (byte b : digest) {
                bud.append(String.format("%02x",b));
            }
            passwordNEW = bud.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        user user = userService.login(username, passwordNEW);
        if (user!=null){
            if ("1".equals(remember)){
                Cookie c_username=new Cookie("username",username);
                Cookie c_password=new Cookie("password",password);
                //设置存活时间
                c_username.setMaxAge(60*60*24*365);
                c_password.setMaxAge(60*60*24*365);
                //发送cookie
                response.addCookie(c_username);
                response.addCookie(c_password);
            }
            HttpSession session = request.getSession();
            session.setAttribute("user",username);
            if (Integer.parseInt(userKind)==user.getKind() && user.getKind()==0){//商家主界面
                response.sendRedirect("/ShoppingWEB/selectAllServlet");
            }else if (Integer.parseInt(userKind)==user.getKind() && user.getKind()==1){//顾客主界面
                response.sendRedirect("/ShoppingWEB/customerIndexServlet");
            }else {//用户类型不匹配
                request.setAttribute("KindError","用户类型不匹配");
                request.getRequestDispatcher("index.jsp").forward(request,response);
            }
        }else{//登录失败，返回登录界面
            request.setAttribute("Error","用户名或密码错误");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
