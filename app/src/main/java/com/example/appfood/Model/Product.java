package com.example.appfood.Model;

public class Product {
    private int idProduct;
    private int idRestaurant;
    private String nameProduct;
    private String description;
    private int priceProduct;
    private int priceOld;
    private String nameRestaurant;
    private int SoLuong;
    private String describe;

    public Product(String nameProduct, int SoLuong, int priceProduct){
        this.nameProduct = nameProduct;
        this.SoLuong = SoLuong;
        this.priceProduct = priceProduct;
    }
    public Product(String nameProduct, String description, int priceProduct, int idRestaurant){
        this.nameProduct = nameProduct;
        this.description = description;
        this.priceProduct = priceProduct;
        this.idRestaurant = idRestaurant;
    }

    public Product(int idProduct, int priceOld, int priceProduct, String nameProduct, String nameRestaurant, String description, String describe){
        this.idProduct = idProduct;
        this.priceOld = priceOld;
        this.priceProduct = priceProduct;
        this.nameProduct = nameProduct;
        this.nameRestaurant = nameRestaurant;
        this.description = description;
        this.describe = describe;
    }

    public Product(int idProduct, int idRestaurant, String nameProduct, String description, int priceProduct) {
        this.idProduct = idProduct;
        this.idRestaurant = idRestaurant;
        this.nameProduct = nameProduct;
        this.description = description;
        this.priceProduct = priceProduct;
    }

    public Product(int idRestaurant, String nameProduct, String description, int priceProduct) {
        this.idRestaurant = idRestaurant;
        this.nameProduct = nameProduct;
        this.description = description;
        this.priceProduct = priceProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(int idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(int priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getPriceOld() {
        return priceOld;
    }

    public void setPriceOld(int priceOld) {
        this.priceOld = priceOld;
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public void setNameRestaurant(String nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int soLuong) {
        SoLuong = soLuong;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }
}
