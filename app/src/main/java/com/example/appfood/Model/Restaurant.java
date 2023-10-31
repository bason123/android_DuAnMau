package com.example.appfood.Model;

public class Restaurant {
    private int idRestaurant;
    private String nameRestaurant;
    private String addressRestaurant;
    private String phoneRestaurant;

    public Restaurant(int idRestaurant, String nameRestaurant, String addressRestaurant, String phoneRestaurant) {
        this.idRestaurant = idRestaurant;
        this.nameRestaurant = nameRestaurant;
        this.addressRestaurant = addressRestaurant;
        this.phoneRestaurant = phoneRestaurant;
    }

    public Restaurant(String nameRestaurant, String addressRestaurant, String phoneRestaurant) {
        this.nameRestaurant = nameRestaurant;
        this.addressRestaurant = addressRestaurant;
        this.phoneRestaurant = phoneRestaurant;
    }

    public int getIdRestaurant() {
        return idRestaurant;
    }

    public void setIdRestaurant(int idRestaurant) {
        this.idRestaurant = idRestaurant;
    }

    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public void setNameRestaurant(String nameRestaurant) {
        this.nameRestaurant = nameRestaurant;
    }

    public String getAddressRestaurant() {
        return addressRestaurant;
    }

    public void setAddressRestaurant(String addressRestaurant) {
        this.addressRestaurant = addressRestaurant;
    }

    public String getPhoneRestaurant() {
        return phoneRestaurant;
    }

    public void setPhoneRestaurant(String phoneRestaurant) {
        this.phoneRestaurant = phoneRestaurant;
    }
}
