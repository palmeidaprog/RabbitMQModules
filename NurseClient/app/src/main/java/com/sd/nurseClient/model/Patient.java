package com.sd.nurseClient.model;

import java.io.Serializable;

public class Patient implements Serializable {
    private long id;
    private String firstName;
    private String lastName;
    private String birth;
    private Address address;

    public Patient() {
    }

    public Patient(long id, String firstName, String lastName, String birth,Address address) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birth = birth;
        this.address = address;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
