package com.moekosu.dubbo.api.bean;

import java.io.Serializable;
import java.util.List;

public class Goods implements Serializable {

    private static final long serialVersionUID = 4437309283256131482L;

    // 商品id
    private String goodsId;

    // 商品图片展示
    private String goodsPic;

    // 商品名称
    private String goodsName;

    // 规格 TODO
    private List<GoodsSpec> goodsSpecList;

    // 描述
    private String goodsDesc;

    // 价格
    private String price;

    public String getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(String goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsPic() {
        return goodsPic;
    }

    public void setGoodsPic(String goodsPic) {
        this.goodsPic = goodsPic;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
