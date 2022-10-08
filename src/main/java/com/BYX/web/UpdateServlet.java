package com.BYX.web;
/*
 * Author   Bai YanXu
 * Date    2022-10-02 - 20:16
 */
import com.BYX.pojo.Goods;
import com.BYX.service.GoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/updateServlet")
public class UpdateServlet extends HttpServlet {
    public SimpleDateFormat DATEFORMAT=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    private GoodsService goodsService=new GoodsService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date d=new Date();
        String DATE = DATEFORMAT.format(d);
        request.setCharacterEncoding("UTF-8");
        //接收参数
        String id = request.getParameter("id");
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String rank = request.getParameter("rank");
        String number = request.getParameter("number");
        String goodsSize = request.getParameter("goodsSize");
        String status = request.getParameter("status");
        String createTime = request.getParameter("createTime");
        String images = request.getParameter("images");
        //封装数据
        Goods goods=new Goods();
        goods.setId(Integer.parseInt(id));
        goods.setName(name);
        goods.setPrice(Integer.valueOf(price));
        goods.setRank(Integer.valueOf(rank));
        goods.setNumber(Integer.valueOf(number));
        goods.setGoodsSize(goodsSize);
        goods.setStatus(Integer.valueOf(status));
        //goods.setCreateTime(createTime);
        goods.setUpdateTime(DATE);
        goods.setImages(images);
        //传入数据
        goodsService.update(goods);
        //转入查询所有
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
