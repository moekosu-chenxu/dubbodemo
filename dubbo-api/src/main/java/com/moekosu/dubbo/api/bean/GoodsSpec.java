package com.moekosu.dubbo.api.bean;

import java.io.Serializable;

public class GoodsSpec implements Serializable {

    private static final long serialVersionUID = 3074346789094929424L;
    // 商品id
    private String gId;

    // 商品颜色(红 蓝 黑)
    private String color;

    // 商品尺寸(L XL XXL)
    private String size;

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
