package com.moekosu.dubbo.api.bean;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * 购物车实体类（用户与商品中间多对多关系表）
 */
public class ShoppingCar extends Goods implements Serializable{

    private static final long serialVersionUID = -6797353054794750373L;

    // 用户归属
    private int userId;

    // 数量
    private int goodsCount;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGoodsCount() {
        return goodsCount;
    }

    public void setGoodsCount(int goodsCount) {
        this.goodsCount = goodsCount;
    }
}
