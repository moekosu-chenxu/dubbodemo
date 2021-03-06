package com.moekosu.dubbo.api.bean;

import java.io.Serializable;

/**
 * 抽奖用户
 */
public class LotteryUser implements Serializable{

    private static final long serialVersionUID = 1681437369581958641L;

    // 抽奖id 用于抽奖
    private int id;

    // 用户名
    private String userName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
