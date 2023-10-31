package com.example.appfood.Model;

public class Order {
    private int idOrder;
    private String phoneCustomer;
    private String dateOrder;
    private String status;
    private String addressCustomer;
    private int idRestaurant;

    public Order(int idOrder, String dateOrder, String status, String addressCustomer, String phoneCustomer, int idRestaurant) {
        this.idOrder = idOrder;
        this.phoneCustomer = phoneCustomer;
        this.dateOrder = dateOrder;
        this.status = status;
        this.addressCustomer = addressCustomer;
        this.idRestaurant = idRestaurant;
    }

    public Order(String dateOrder, String status, String addressCustomer, String phoneCustomer, int idRestaurant) {
        this.phoneCustomer = phoneCustomer;
        this.dateOrder = dateOrder;
        this.status = status;
        this.addressCustomer = addressCustomer;
        this.idRestaurant = idRestaurant;
    }



    public Order(String dateOrder, String status){
        this.dateOrder = dateOrder;
        this.status = status;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }

    public String getDateOrder() {
        return dateOrder;
    }

    public void setDateOrder(String dateOrder) {
        this.dateOrder = dateOrder;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public int getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(int idRestaurant) {
        this.idRestaurant = idRestaurant;
    }
}
