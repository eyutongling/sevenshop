package com.seven.entity;

public class Goodscart {
    private Integer id;

    private Integer userid;

    private Integer goodsid;

    private Integer number;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getGoodsid() {
        return goodsid;
    }

    public void setGoodsid(Integer goodsid) {
        this.goodsid = goodsid;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
    @Override
    public String toString(){
    	return "Goodscart [id=" + id + ", userId=" + userid + ", goodsId="
				+ goodsid + ", number=" + number  +"]";
    }
}