package com.BYX.web;
/**
 * Author   Bai YanXu
 * Date    2022-10-02 - 17:04
 */

import com.BYX.pojo.Goods;
import com.BYX.service.GoodsService;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/selectByIdServlet")
public class SelectByIdServlet extends HttpServlet {
    private GoodsService goodsService=new GoodsService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        Goods goods = goodsService.selectById(Integer.parseInt(id));
        request.setAttribute("goods",goods);
        //转发
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
