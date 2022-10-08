package com.BYX.mapper;/*
   Author   Bai YanXu
   Date    2022-10-03 - 11:33
*/
import com.BYX.pojo.user;
import org.apache.ibatis.annotations.*;

public interface userMapper {
    //用户登录
    @Select("select * from byx.user where username=#{username} and password=#{password}")
    user login(@Param("username") String userName, @Param("password") String password);
    //根据用户名查询
    @Select("select * from user where username=#{username}")
    user selectByUsername(String username);
    //添加用户
    @Insert("insert into user values (null,#{username},#{password},#{phone},#{email},#{kind})")
    void add(user user);
}
