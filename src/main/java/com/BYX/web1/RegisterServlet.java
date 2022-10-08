package com.BYX.web1;/*
   Author   Bai YanXu
   Date    2022-10-03 - 19:10
*/

import com.BYX.pojo.user;
import com.BYX.service.userService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {
    private String passwordNEW,phoneNEW,emailNEW;
    private com.BYX.service.userService userService=new userService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username").trim();
        String password = request.getParameter("password").trim();
        String phone = request.getParameter("phone").trim();
        String email = request.getParameter("email").trim();
        //封装一个用于用户名已存在后返还注册页面的对象
        user u=new user();
        u.setUsername(username);
        u.setPassword(password);
        u.setPhone(phone);
        u.setEmail(email);


        //对隐私信息进行MD5加密
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
          //1.密码加密
            byte[] digest = md5.digest(password.getBytes());
            StringBuilder bud1=new StringBuilder();
            for (byte b : digest) {
                bud1.append(String.format("%02x",b));
            }
            passwordNEW = bud1.toString();
          //2.电话号码加密
            byte[] digest2 = md5.digest(phone.getBytes());
            StringBuilder bud2=new StringBuilder();
            for (byte b : digest2) {
                bud2.append(String.format("%02x",b));
            }
            phoneNEW=bud2.toString();
          //3.邮箱加密
            byte[] digest3 = md5.digest(email.getBytes());
            StringBuilder bud3=new StringBuilder();
            for (byte b : digest3) {
                bud3.append(String.format("%02x", b));
            }
            emailNEW=bud3.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        //创建用户对象
        user user=new user();
        //封装实体类
        user.setUsername(username);
        user.setPassword(passwordNEW);
        user.setPhone(phoneNEW);
        user.setEmail(emailNEW);
        user.setKind(1);
        //传入
        user user1 = userService.selectByUsername(username);
        if (user1==null){
            //用户名没有重复,可以注册
            userService.add(user);
            response.sendRedirect("index.jsp");
        }else {
            request.setAttribute("Error","用户名已存在");
            request.setAttribute("u",u);
            request.getRequestDispatcher("register.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
