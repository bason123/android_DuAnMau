package com.example.appfood.Model;

public class Customer {
    private String phoneCustomer;
    private String passWord;
    private String nameCustomer;
    private String addressCustomer;
    private int age;
    private String gender;

    public Customer(String phoneCustomer, String passWord, String nameCustomer, String addressCustomer, int age, String gender) {
        this.phoneCustomer = phoneCustomer;
        this.passWord = passWord;
        this.nameCustomer = nameCustomer;
        this.addressCustomer = addressCustomer;
        this.age = age;
        this.gender = gender;
    }

    public Customer(String passWord, String nameCustomer, String addressCustomer, int age, String gender) {
        this.passWord = passWord;
        this.nameCustomer = nameCustomer;
        this.addressCustomer = addressCustomer;
        this.age = age;
        this.gender = gender;
    }

    public String getPhoneCustomer() {
        return phoneCustomer;
    }

    public void setPhoneCustomer(String phoneCustomer) {
        this.phoneCustomer = phoneCustomer;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getAddressCustomer() {
        return addressCustomer;
    }

    public void setAddressCustomer(String addressCustomer) {
        this.addressCustomer = addressCustomer;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}



