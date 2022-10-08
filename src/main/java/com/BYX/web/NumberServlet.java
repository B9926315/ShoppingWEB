package com.BYX.web; /**
 * Author   Bai YanXu
 * Date    2022-10-04 - 22:54
 */

import com.BYX.service.GoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
//根据查询到的id将数据库中手机数量减一
@WebServlet("/numberServlet")
public class NumberServlet extends HttpServlet {
    private GoodsService goodsService=new GoodsService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        goodsService.buyPhone(Integer.parseInt(id));
        request.getRequestDispatcher("/customerIndexServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
