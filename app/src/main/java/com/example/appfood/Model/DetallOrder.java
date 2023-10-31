package com.example.appfood.Model;

public class DetallOrder {
    private int idDetallOrder;
    private int idProduct;
    private int idOrder;
    private int quantity;
    private int price;
    private String addressBook;
    private int totalPrice;
    private String nameProduct;

    public DetallOrder(int idDetallOrder, int idProduct, int idOrder, int quantity, int price,String addressBook, int totalPrice) {
        this.idDetallOrder = idDetallOrder;
        this.idProduct = idProduct;
        this.idOrder = idOrder;
        this.quantity = quantity;
        this.price = price;
        this.addressBook = addressBook;
        this.totalPrice = totalPrice;
    }

    public DetallOrder(int idDetallOrder, int idProduct, int idOrder, int quantity, int price, String addressBook) {
        this.idDetallOrder = idDetallOrder;
        this.idProduct = idProduct;
        this.idOrder = idOrder;
        this.quantity = quantity;
        this.price = price;
        this.addressBook = addressBook;
    }
    public DetallOrder(int idProduct, int idOrder, int quantity, int price, String addressBook) {
        this.idProduct = idProduct;
        this.idOrder = idOrder;
        this.quantity = quantity;
        this.price = price;
        this.addressBook = addressBook;
    }


    //idDetallOrder integer primary key autoincrement, quantity int, price integer, addressBook text ,idProduct integer REFERENCES PRODUCT(idProduct), idOrder integer REFERENCES ORDERR(idOrder))");
    public DetallOrder(int idDetallOrder, int quantity, int price, String addressBook, int idProduct, int idOrder, String nameProduct){
        this.idDetallOrder = idDetallOrder;
        this.quantity = quantity;
        this.price = price;
        this.addressBook = addressBook;
        this.idProduct = idProduct;
        this.idOrder = idOrder;
        this.nameProduct = nameProduct;
    }

    public DetallOrder(int idProduct, int idOrder, int quantity, int price, int totalPrice) {
        this.idProduct = idProduct;
        this.idOrder = idOrder;
        this.quantity = quantity;
        this.price = price;
        this.addressBook = addressBook;
        this.totalPrice = totalPrice;
    }

    public int getIdDetallOrder() {
        return idDetallOrder;
    }

    public void setIdDetallOrder(int idDetallOrder) {
        this.idDetallOrder = idDetallOrder;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getAddressBook() {
        return addressBook;
    }

    public void setAddressBook(String addressBook) {
        this.addressBook = addressBook;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }
}
