package com.BYX.web; /**
 * Author   Bai YanXu
 * Date    2022-10-05 - 16:28
 */

import com.BYX.pojo.DataDisplay;
import com.BYX.pojo.Goods;
import com.BYX.service.GoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;

//这个servlet和selectByConditionsServlet代码一样，这个servlet是转发给顾客界面的
@WebServlet("/selectByCustomerServlet")
public class SelectByCustomerServlet extends HttpServlet {
    private GoodsService goodsService=new GoodsService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String status = request.getParameter("status");
        String brandName = request.getParameter("brandName0");
        String brandPriceMin = request.getParameter("brandPriceMin");
        String brandPriceMax = request.getParameter("brandPriceMax");
        String brandNumberMin = request.getParameter("brandNumberMin");
        String brandNumberMax = request.getParameter("brandNumberMax");
        //中文乱码，进行转码
        String name=new String(brandName.getBytes(StandardCharsets.ISO_8859_1),StandardCharsets.UTF_8);
        String brandName1="%"+name+"%";
        //新建map
        Map goods1=new HashMap();
        goods1.put("status",status);
        goods1.put("name",brandName1);
        goods1.put("priceMin",brandPriceMin);
        goods1.put("priceMax",brandPriceMax);
        goods1.put("numberMin",brandNumberMin);
        goods1.put("numberMax",brandNumberMax);
        //传入map
        List<Goods> goods = goodsService.selectByConditions(goods1);
        //将返回的goods存入域中
        request.setAttribute("goods",goods);
        //新建对象
        DataDisplay dataDisplay=new DataDisplay();
        //封装对象
        dataDisplay.setName(name);
        if (brandPriceMin!=null && brandPriceMin!=""){
            dataDisplay.setPriceMin(Integer.parseInt(brandPriceMin));
        }else {
            dataDisplay.setPriceMin(null);
        }
        if (brandPriceMax!=null && brandPriceMax!=""){
            dataDisplay.setPriceMax(Integer.parseInt(brandPriceMax));
        }else {
            dataDisplay.setPriceMax(null);
        }
        if (brandNumberMin!=null && brandNumberMin!=""){
            dataDisplay.setNumberMin(Integer.parseInt(brandNumberMin));
        }else {
            dataDisplay.setNumberMin(null);
        }
        if (brandNumberMax!=null && brandNumberMax!=""){
            dataDisplay.setNumberMax(Integer.parseInt(brandNumberMax));
        }else {
            dataDisplay.setNumberMax(null);
        }
        request.setAttribute("goods1",dataDisplay);
        request.getRequestDispatcher("/CustomerIndex.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
