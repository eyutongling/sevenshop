package com.seven.entity;

public class Goods {
    private Integer id;

    private String name;

    private Float prices;

    private Integer typeid;

    private String productor;

    private String img1;

    private String img2;

    private String img3;

    private String description;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Float getPrices() {
        return prices;
    }

    public void setPrices(Float prices) {
        this.prices = prices;
    }

    public Integer getTypeid() {
        return typeid;
    }

    public void setTypeid(Integer typeid) {
        this.typeid = typeid;
    }

    public String getProductor() {
        return productor;
    }

    public void setProductor(String productor) {
        this.productor = productor == null ? null : productor.trim();
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1 == null ? null : img1.trim();
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2 == null ? null : img2.trim();
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3 == null ? null : img3.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }
    @Override
    public String toString(){
    	return "Manage [id=" + id + ", name=" + name + ", prices="
				+ prices + ", typeid=" + typeid  +"]";
    }
}