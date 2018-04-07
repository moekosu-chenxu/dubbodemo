package com.moekosu.dubbo.provider.service.impl;

import com.moekosu.dubbo.api.bean.Goods;
import com.moekosu.dubbo.api.bean.ShoppingCar;
import com.moekosu.dubbo.api.common.OwnerPool;
import com.moekosu.dubbo.provider.dao.ShoppingCarMapper;
import com.moekosu.dubbo.provider.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @author chenxu
 * @date 2018/04
 */
public class CarServiceImpl implements CarService {

    private static final Logger logger = LoggerFactory.getLogger(CarServiceImpl.class);

    @Autowired
    private ShoppingCarMapper carMapper;

    /**
     * 添加商品进购物车
     * @param userId 用户id
     * @param goodId 商品id
     * @param count 商品数量
     */
    public void add2Car(final String userId, final String goodId, final String count)
    {
        OwnerPool pool = new OwnerPool(10, 100, 60*60*24);
        try {
            pool.execute(new OwnerPool.Task() {
                public void doTask() {
                    try {
                        // 数据库中做增加操作
                        carMapper.add2Car(userId, goodId, count);
                    }
                    catch (Exception e){
                        logger.error("provider error: add2Car() method fail", e);
                    }
                }
            });
        }
        catch (Exception e){
            logger.error("provider error: add2Car() multiple thread run fail", e);
        }
        finally {
            pool.shutdown();
        }
    }

    /**
     * 根据用户id获取购物车列表
     * @param userId
     * @return
     */
    public List<ShoppingCar> getCarDetail(String userId)
    {
        List<ShoppingCar> car = new ArrayList<ShoppingCar>();
        try{
            car = carMapper.getCarDetails(userId);
        }
        catch (Exception e){
            logger.error("provider error: getCarDetail() method fail", e);
        }
        finally {
            return car;
        }
    }

    /**
     * 删除购物车商品
     * @param userId
     * @param goodId 商品id，如果为空则清空购物车
     */
    public void remove4Car(String userId, String goodId)
    {
        try {
            carMapper.remove4Car(userId, goodId);
        }
        catch (Exception e){
            logger.error("provider error: remove4Car() method fail", e);
        }
    }

    /**
     * 获取全部商品列表
     * @return
     */
    public List<Goods> getGoodsList()
    {
        List<Goods> list = new ArrayList<Goods>();
        try {
            list = carMapper.getGoodsList();
        }
        catch (Exception e){
            logger.error("provider error: getGoodsList() method fail", e);
        }
        finally {
            return list;
        }
    }
}
