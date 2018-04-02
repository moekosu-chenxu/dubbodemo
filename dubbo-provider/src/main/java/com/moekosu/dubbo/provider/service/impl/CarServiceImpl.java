package com.moekosu.dubbo.provider.service.impl;

import com.moekosu.dubbo.api.bean.ShoppingCar;
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

    public void add2Car(String userId, String goodId, String count)
    {
        try {
            carMapper.add2Car(userId, goodId, count);
        }
        catch (Exception e){
            logger.error("", e);
        }
    }

    public ShoppingCar getCarDetail(String userId)
    {
        try{
            return carMapper.getCarDetails(userId);
        }
        catch (Exception e){
            logger.error("", e);
        }
        return new ShoppingCar();
    }

    public void remove4Car(String userId, String goodId)
    {
        try {
            carMapper.remove4Car(userId, goodId);
        }
        catch (Exception e){
            logger.error("", e);
        }
    }
}
