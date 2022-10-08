package com.BYX.mapper;

import com.BYX.pojo.Goods;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface GoodsMapper {
    //商家查询所有商品并展示
    @Select("select * from byx.shopping order by `rank` desc,price desc ")
    List<Goods> selectAll();
    //商家搜索商品并展示
    List<Goods> selectByConditions(Map map);

    //新增商品
    @Insert("insert into byx.shopping values (null,#{name},#{price},#{rank},#{number},#{goodsSize},#{status},#{createTime},#{updateTime},#{images})")
    void add(Goods goods);
    //编辑商品根据ID查
    @Select("select * from byx.shopping where id=#{id}")
    Goods selectById(int id);
    //修改信息
    @Update("update byx.shopping set name=#{name},price=#{price},`rank`=#{rank},number=#{number},goodsSize=#{goodsSize},status=#{status},updateTime=#{updateTime} where id=#{id}")
    void update(Goods goods);
    //删除商品
    @Delete("delete from byx.shopping where id=#{id}")
    void deleteById(int id);

    //顾客登录成功展示所有status为1且剩余数量大于0的商品
    @Select("select * from byx.shopping where status>=1 and number>0 order by `rank` desc ,price desc ")
    List<Goods> selectStatus1();
    //用户买一台手机,后台数据库该手机数量减一
    @Update("update byx.shopping set number=number-1 where id=#{id} and number>0")
    void buyPhone(int id);
}
