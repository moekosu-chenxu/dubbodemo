package com.moekosu.dubbo.provider.dao;

import com.moekosu.dubbo.api.bean.ShoppingCar;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShoppingCarMapper {

    // TODO 表1 user (id name password authority)
    // TODO 表2 shoppingCar (id user_id priceSum)
    // TODO 表3 goods 商品表 (id name price)
    // TODO 表4 car_goods 多对多中间表 (car_id goods_id buyCount)

    // 创建购物车 操作ShoppingCar表
    void createCar(String userId) throws Exception;

    // 操作Car_Goods表
    void add2Car(@Param("carId") String carId, @Param("goodsId") String goodsId, @Param("buyCount") String buyCount) throws Exception;

    // 获取购物车列表
    ShoppingCar getCarDetails(String userId);

    // 删除购物车内的商品(不传商品id则删除全部购物车)
    void remove4Car(@Param("carId") String carId, @Param("goodsId") String goodsId) throws Exception;

}
