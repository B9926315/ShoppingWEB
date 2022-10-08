package com.BYX.filter;
/**
 * Author   Bai YanXu
 * Date    2022-10-06 - 21:06
 */
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter("/*")
public class LoginFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest req=(HttpServletRequest)request;
        //判断访问资源是否和登录相关，如果是，则放行
        String[] urls={"index.jsp","/images/","/css/","/login0Servlet","register.jsp","/registerServlet"};
        String URL = req.getRequestURI();
        for (String url : urls) {
            if (URL.contains(url)){
                //找到了，放行
                chain.doFilter(request,response);
                return;
            }
        }
        //1.判断session中是否有user
        HttpSession session = req.getSession();
        Object user = session.getAttribute("user");
        if (user!=null){
            //session中已经存储过对象，表明已经登录
            //放行
            chain.doFilter(request,response);
        }else {
            req.setAttribute("Error","您尚未登录");
            req.getRequestDispatcher("/index.jsp").forward(req,response);
        }

    }
    public void init(FilterConfig config) throws ServletException {
    }

    public void destroy() {
    }


}
