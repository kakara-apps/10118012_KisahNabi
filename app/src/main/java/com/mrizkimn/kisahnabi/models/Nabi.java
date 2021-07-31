package com.mrizkimn.kisahnabi.models;

public class Nabi {

private String name;
private String thn_kelahiran;
private String usia;
private String decription;
private String tempat;
private String img_url;

    public Nabi() {
    }

    public Nabi(String name, String thn_kelahiran, String usia, String decription, String tempat, String img_url) {
        this.name = name;
        this.thn_kelahiran = thn_kelahiran;
        this.usia = usia;
        this.decription = decription;
        this.tempat = tempat;
        this.img_url = img_url;
    }

    public String getName() {
        return name;
    }

    public String getThn_kelahiran() {
        return thn_kelahiran;
    }

    public String getUsia() {
        return usia;
    }

    public String getDecription() {
        return decription;
    }

    public String getTempat() {
        return tempat;
    }

    public String getImg_url() {
        return img_url;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setThn_kelahiran(String thn_kelahiran) {
        this.thn_kelahiran = thn_kelahiran;
    }

    public void setUsia(String usia) {
        this.usia = usia;
    }

    public void setDecription(String decription) {
        this.decription = decription;
    }

    public void setTempat(String tempat) {
        this.tempat = tempat;
    }

    public void setImg_url(String img_url) {
        this.img_url = img_url;
    }
}
