package com.BYX.service;/*
   Author   Bai YanXu
   Date    2022-10-03 - 11:45
*/
import com.BYX.mapper.userMapper;
import com.BYX.pojo.user;
import com.BYX.util.SqlSessionFactoryUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class userService {
    SqlSessionFactory factory = SqlSessionFactoryUtils.getSqlSessionFactory();
    //商家登录
    public user login(String username,String password){
        SqlSession sqlSession = factory.openSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        user user = mapper.login(username, password);
        sqlSession.close();
        return user;
    }
    //根据用户名查询是否有重复
    public user selectByUsername(String username){
        SqlSession sqlSession = factory.openSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        user user = mapper.selectByUsername(username);
        sqlSession.close();
        return user;
    }
    //添加用户
    public void add(user user){
        SqlSession sqlSession = factory.openSession();
        userMapper mapper = sqlSession.getMapper(userMapper.class);
        mapper.add(user);
        sqlSession.commit();
        sqlSession.close();
    }
}
