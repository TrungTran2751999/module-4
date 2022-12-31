package com.example.model;

public class Exposure {
    private String contactAnimal;
    private String contactHuman;

    public Exposure(String contactAnimal, String contactHuman) {
        this.contactAnimal = contactAnimal;
        this.contactHuman = contactHuman;
    }
    public Exposure(){}
    public String getContactAnimal() {
        return contactAnimal;
    }

    public void setContactAnimal(String contactAnimal) {
        this.contactAnimal = contactAnimal;
    }

    public String getContactHuman() {
        return contactHuman;
    }

    public void setContactHuman(String contactHuman) {
        this.contactHuman = contactHuman;
    }
}
