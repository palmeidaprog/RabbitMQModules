package com.sd.nurseClient.model;

import java.io.Serializable;

public class Address implements Serializable {
    private String street;
    private String number;
    private String neighbor;
    private String city;
    private String state;
    private String CEP;

    public Address() {
    }

    public Address(String street, String number, String neighbor, String city, String state, String CEP) {
        this.street = street;
        this.number = number;
        this.neighbor = neighbor;
        this.city = city;
        this.state = state;
        this.CEP = CEP;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getNeighbor() {
        return neighbor;
    }

    public void setNeighbor(String neighbor) {
        this.neighbor = neighbor;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
}
