package com.moekosu.dubbo.provider.dao;

import com.moekosu.dubbo.api.bean.Goods;
import com.moekosu.dubbo.api.bean.ShoppingCar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ShoppingCarMapper {

    // TODO 表1 user (id name password authority)
    // TODO 表2 shoppingCar (id user_id priceSum) X 删除不要了
    // TODO 表3 goods 商品表 (id name desc pic_path price)
    // TODO 表4 shoppingCar 多对多中间表购物车 (user_id goods_id buyCount)

    // 操作Car_Goods表
    void add2Car(@Param("userId") String userId, @Param("goodsId") String goodsId, @Param("buyCount") String buyCount) throws Exception;

    // 获取购物车列表
    ShoppingCar getCarDetails(@Param("userId") String userId) throws Exception;

    // 删除购物车内的商品(不传商品id则删除全部购物车)
    void remove4Car(@Param("userId") String userId, @Param("goodsId") String goodsId) throws Exception;

    // 获取所有商品列表
    List<Goods> getGoodsList() throws Exception;

}
