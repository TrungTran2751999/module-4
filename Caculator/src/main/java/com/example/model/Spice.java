package com.example.model;

import java.util.List;

public class Spice {
    private int id;
    private String name;
    private String[] spice;

    public Spice(int id, String name, String[] spice) {
        this.id = id;
        this.name = name;
        this.spice = spice;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getSpice() {
        return spice;
    }

    public void setSpice(String[] spice) {
        this.spice = spice;
    }
}
