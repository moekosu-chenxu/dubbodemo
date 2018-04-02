package com.moekosu.dubbo.api.bean;

import java.io.Serializable;
import java.util.List;

public class Goods implements Serializable {

    private static final long serialVersionUID = 4437309283256131482L;

    // 商品id
    private String gId;

    // 商品名称
    private String goodsName;

    // 类型
    private String goodsType;

    // 规格 TODO
    private List<GoodsSpec> goodsSpecList;

    // 描述
    private String goodsDesc;

    public String getgId() {
        return gId;
    }

    public void setgId(String gId) {
        this.gId = gId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public List<GoodsSpec> getGoodsSpecList() {
        return goodsSpecList;
    }

    public void setGoodsSpecList(List<GoodsSpec> goodsSpecList) {
        this.goodsSpecList = goodsSpecList;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

}
