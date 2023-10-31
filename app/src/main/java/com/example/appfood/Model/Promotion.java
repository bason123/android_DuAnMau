package com.example.appfood.Model;

public class Promotion {
    private String promation;
    private int ImgPromotion;
    private String nameStore;
    private String mitune;
    private String namePromation;
    private String ratePromation;
    private String mathanggiam;

    public Promotion(String promation, int imgPromotion,String nameStore, String mitune, String namePromation, String ratePromation, String mathanggiam) {
        this.promation = promation;
        this.ImgPromotion = imgPromotion;
        this.nameStore = nameStore;
        this.mitune = mitune;
        this.namePromation = namePromation;
        this.ratePromation = ratePromation;
        this.mathanggiam = mathanggiam;
    }

    public String getPromation() {
        return promation;
    }

    public void setPromation(String promation) {
        this.promation = promation;
    }

    public int getImgPromotion() {
        return ImgPromotion;
    }

    public void setImgPromotion(int imgPromotion) {
        ImgPromotion = imgPromotion;
    }

    public String getNameStore(){
        return nameStore;
    }

    public void setNameStore(String nameStore){
        this.nameStore = nameStore;
    }

    public String getMitune() {
        return mitune;
    }

    public void setMitune(String mitune) {
        this.mitune = mitune;
    }

    public String getNamePromation() {
        return namePromation;
    }

    public void setNamePromation(String namePromation) {
        this.namePromation = namePromation;
    }

    public String getRatePromation() {
        return ratePromation;
    }

    public void setRatePromation(String ratePromation) {
        this.ratePromation = ratePromation;
    }

    public String getMathanggiam() {
        return mathanggiam;
    }

    public void setMathanggiam(String mathanggiam) {
        this.mathanggiam = mathanggiam;
    }
}

