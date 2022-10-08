package com.BYX.web; /**
 * Author   Bai YanXu
 * Date    2022-10-01 - 16:39
 */

import com.BYX.pojo.Goods;
import com.BYX.service.GoodsService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    private GoodsService goodsService=new GoodsService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat DATEFORMAT=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date=new Date();
        String DATENEW = DATEFORMAT.format(date);
        request.setCharacterEncoding("UTF-8");
        //接收参数
        String name = request.getParameter("name");
        String price = request.getParameter("price");
        String rank = request.getParameter("rank");
        String number = request.getParameter("number");
        String goodsSize = request.getParameter("goodsSize");
        String status = request.getParameter("status");
        //封装对象
        Goods goods=new Goods();
        goods.setName(name);
        goods.setRank(Integer.valueOf(rank));
        goods.setPrice(Integer.valueOf(price));
        goods.setNumber(Integer.valueOf(number));
        goods.setGoodsSize(goodsSize);
        goods.setStatus(Integer.valueOf(status));
        goods.setCreateTime(DATENEW);
        goods.setUpdateTime(DATENEW);
        if (name.contains("华为")){
            goods.setImages("https://2c.zol-img.com.cn/product/222/110/cei9o77ow8FA.jpg");
        }else if (name.contains("小米")){
            goods.setImages("https://2d.zol-img.com.cn/product/217/21/cesgl3DO10wE.jpg");
        }else if (name.contains("红米")){
            goods.setImages("https://2b.zol-img.com.cn/product/221/861/ceuUE41ZIfFeo.jpg");
        }else if (name.contains("荣耀")){
            goods.setImages("https://2b.zol-img.com.cn/product/219/415/ce8i6Q6qSA5UU.jpg");
        }else if (name.contains("realme")){
            goods.setImages("https://2e.zol-img.com.cn/product/222/356/ce2kgJ1yBXeW.jpg");
        }else if (name.contains("vivo") || name.contains("VIVO")){
            goods.setImages("https://2e.zol-img.com.cn/product/219/10/cec1t8AY4NJos.jpg");
        }else if (name.contains("oppo") || name.contains("OPPO")){
            goods.setImages("https://2d.zol-img.com.cn/product/219/917/ceFzRCXNxBGq2.jpg");
        }else if (name.contains("苹果") || name.contains("iPhone") || name.contains("iphone")){
            goods.setImages("https://2c.zol-img.com.cn/product/222/906/ceMHrcQRgITXs.jpg");
        }else if (name.contains("IQOO") || name.contains("iqoo")){
            goods.setImages("https://2c.zol-img.com.cn/product/219/686/cekzRAbY3BPtM.jpg");
        }else if (name.contains("三星") || name.contains("samsung")){
            goods.setImages("https://2e.zol-img.com.cn/product/221/634/cePT3BnNhkIxo.jpg");
        }else{
            goods.setImages("https://2c.zol-img.com.cn/product/204/80/ceDySNzUBwrZ.jpg");
        }
        //传入
        goodsService.add(goods);
        //转入查询所有
        request.getRequestDispatcher("/selectAllServlet").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
