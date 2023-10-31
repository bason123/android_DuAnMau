package com.example.appfood.Model;

public class farm {
    private int img;
    private int priceOld;
    private int priceNew;
    private String namePoduct;
    private String kg;

    public farm(int img, int priceOld, int priceNew, String namePoduct, String kg) {
        this.img = img;
        this.priceOld = priceOld;
        this.priceNew = priceNew;
        this.namePoduct = namePoduct;
        this.kg = kg;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(int priceOld) {
        this.priceOld = priceOld;
    }

    public int getPriceNew() {
        return priceNew;
    }

    public void setPriceNew(int priceNew) {
        this.priceNew = priceNew;
    }

    public String getNamePoduct() {
        return namePoduct;
    }

    public void setNamePoduct(String namePoduct) {
        this.namePoduct = namePoduct;
    }

    public String getKg() {
        return kg;
    }

    public void setKg(String kg) {
        this.kg = kg;
    }
}
