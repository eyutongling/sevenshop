package com.seven.entity;

public class Buy {
    private Integer id;

    private Integer userid;

    private Integer goodsid;

    private Float fare;


	private String buytime;
    
    private String address;

    public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

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

    public Float getFare() {
        return fare;
    }

    public void setFare(Float fare) {
        this.fare = fare;
    }

    public String getBuytime() {
        return buytime;
    }

    public void setBuytime(String buytime) {
        this.buytime = buytime == null ? null : buytime.trim();
    }
    
    @Override
	public String toString() {
		return "Buy [id=" + id + ", userid=" + userid + ", goodsid=" + goodsid + ", fare=" + fare + ", buytime="
				+ buytime + ", address=" + address + "]";
	}

}