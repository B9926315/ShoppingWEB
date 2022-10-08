package com.BYX.service;

import com.BYX.mapper.GoodsMapper;
import com.BYX.pojo.Goods;
import com.BYX.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;
import java.util.Map;

public class GoodsService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    //查询所有
    public List<Goods> selectAll(){
        SqlSession sqlSession = factory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        List<Goods> goods = mapper.selectAll();
        sqlSession.close();
        return goods;
    }
    //添加商品
    public  void add(Goods goods){
        SqlSession sqlSession = factory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        mapper.add(goods);
        sqlSession.commit();
        sqlSession.close();
    }
    //根据ID查询商品
    public Goods selectById(int id){
        SqlSession sqlSession = factory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        Goods goods = mapper.selectById(id);
        sqlSession.close();
        return goods;
    }
    //商家修改
    public void update(Goods goods){
        SqlSession sqlSession = factory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        mapper.update(goods);
        sqlSession.commit();
        sqlSession.close();
    }
    //商家删除
    public void deleteById(int id){
        SqlSession sqlSession = factory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        mapper.deleteById(id);
        sqlSession.commit();
        sqlSession.close();
    }
    //顾客登录成功展示商品函数
    public List<Goods> selectStatus1(){
        SqlSession sqlSession = factory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        List<Goods> goods = mapper.selectStatus1();
        return goods;
    }
    //顾客买手机，数据库手机数量减一
    public void buyPhone(int id){
        SqlSession sqlSession = factory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        mapper.buyPhone(id);
        sqlSession.commit();
        sqlSession.close();
    }
    //动态SQL查询
    public List<Goods> selectByConditions(Map map){
        SqlSession sqlSession = factory.openSession();
        GoodsMapper mapper = sqlSession.getMapper(GoodsMapper.class);
        List<Goods> goods = mapper.selectByConditions(map);
        sqlSession.close();
        return goods;
    }
}
