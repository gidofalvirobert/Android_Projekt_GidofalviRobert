package com.example.projekt;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Client {
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("tel")
    @Expose
    private String tel;
    @SerializedName("country")
    @Expose
    private String country;
    @SerializedName("locality")
    @Expose
    private String locality;
    @SerializedName("adress")
    @Expose
    private String adress;

    public Client() {
    }

    public Client(String name,String password,String tel,String country,String locality,String adress) {
        this.name = name;
        this.password = password;
        this.tel = tel;
        this.country = country;
        this.locality = locality;
        this.adress = adress;

    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getTel() {
        return tel;
    }

    public String getCountry() {
        return country;
    }

    public String getLocality() {
        return locality;
    }

    public String getAdress() {
        return adress;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", tel='" + tel + '\'' +
                ", country='" + country + '\'' +
                ", locality='" + locality + '\'' +
                ", adress='" + adress + '\'' +
                '}';
    }
}
