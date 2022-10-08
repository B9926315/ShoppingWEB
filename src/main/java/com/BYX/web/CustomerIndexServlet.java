package com.BYX.web;
/**
 * Author   Bai YanXu
 * Date    2022-10-04 - 17:20
 */

import com.BYX.pojo.Goods;
import com.BYX.service.GoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet("/customerIndexServlet")
public class CustomerIndexServlet extends HttpServlet {
    private GoodsService goodsService=new GoodsService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Goods> goods = goodsService.selectStatus1();
        request.setAttribute("goods",goods);
        request.getRequestDispatcher("/CustomerIndex.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
