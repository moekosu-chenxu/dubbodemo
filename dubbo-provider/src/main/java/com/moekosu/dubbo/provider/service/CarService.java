package com.moekosu.dubbo.provider.service;

import com.moekosu.dubbo.api.bean.ShoppingCar;

import java.util.List;

/**
 * @author chenxu
 * @date 2018/04
 */
public interface CarService {

    /**
     * 添加商品进购物车
     * @param userId 用户id
     * @param goodId 商品id
     * @param count 商品数量
     */
    void add2Car(String userId, String goodId, String count);

    /**
     * 获取购物车列表
     * @param carId 用户id
     * @return
     */
    ShoppingCar getCarDetail(String carId);

    /**
     * 删除购物车内商品
     * @param carId 用户id
     * @param goodId 商品id，如果为空则清空购物车
     */
    void remove4Car(String carId, String goodId);

}
