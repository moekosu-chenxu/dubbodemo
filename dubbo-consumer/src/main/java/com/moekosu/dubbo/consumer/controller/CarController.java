package com.moekosu.dubbo.consumer.controller;

import com.moekosu.dubbo.api.bean.Goods;
import com.moekosu.dubbo.api.bean.ShoppingCar;
import com.moekosu.dubbo.api.common.OwnerPool;
import com.moekosu.dubbo.provider.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @author chenxu
 * @date 2018/04
 */
@RequestMapping("/car")
@RestController
public class CarController extends PageController {

    private static final Logger logger = LoggerFactory.getLogger(CarController.class);

    @Autowired
    private CarService carService;

    @RequestMapping("/goodsList")
    @ResponseBody
    public String getGoodsList()
    {
        List<Goods> list;
        try{
            list = carService.getGoodsList();
        }
        catch (Exception e) {
            logger.error("获取全部商品列表失败", e);
            return returnFailMap("获取全部商品列表失败");
        }
        return returnSuccessMap(list);
    }

    @RequestMapping("/carList")
    @ResponseBody
    public String getCarList(@RequestBody Map<String, Object> reqMap)
    {
        String userId = (String) reqMap.get("userId");
        ShoppingCar car;
        try {
            car = carService.getCarDetail(userId);
        }
        catch (Exception e){
            logger.error("获取"+userId+"购物车内商品列表失败", e);
            return returnFailMap("获取"+userId+"购物车内商品列表失败");
        }
        return returnSuccessMap(car);
    }

    @RequestMapping("/buy")
    @ResponseBody
    public String buy(@RequestBody Map<String, Object> reqMap)
    {
        final String goodsId = (String) reqMap.get("gId");
        final String userId = (String) reqMap.get("userId");

        // 多线程
        OwnerPool pool = new OwnerPool(10, 100, 60*60*24);
        try{
            pool.execute(new OwnerPool.Task() {
                public void doTask() {
                    // 调用新增进购物车
                    carService.add2Car(userId, goodsId, "1");
                }
            });
        }
        catch (Exception e){
            logger.error("购买"+goodsId+"失败", e);
            return returnFailMap("购买"+goodsId+"失败");
        }
        finally {
            pool.shutdown();
        }
        return returnSuccessMap("");
    }

    @RequestMapping("/remove")
    @ResponseBody
    public String remove(@RequestBody Map<String, Object> reqMap)
    {
        String userId = (String) reqMap.get("userId");
        String goodsId = (String) reqMap.get("gId");
        try {
            carService.remove4Car(userId, goodsId);
        }
        catch (Exception e){
            logger.error("删除购物车内商品"+goodsId+"失败", e);
            return returnFailMap("删除购物车内商品"+goodsId+"失败");
        }
        return returnSuccessMap("");
    }

}
