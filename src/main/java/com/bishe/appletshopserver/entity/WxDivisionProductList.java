package com.bishe.appletshopserver.entity;

import java.util.List;

public class WxDivisionProductList {
    private String id;
    private String code;
    private String name;
    List<MProduct> skus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<MProduct> getSkus() {
        return skus;
    }

    public void setSkus(List<MProduct> skus) {
        this.skus = skus;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "WxDivisionProductList{" +
                "id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", skus=" + skus +
                '}';
    }
}
