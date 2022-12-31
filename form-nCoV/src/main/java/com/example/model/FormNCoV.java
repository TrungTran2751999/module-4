package com.example.model;

import java.util.Date;
import java.util.List;

public class FormNCoV {
    private String name;
    private int birthYear;
    private int gender;
    private int country;
    private int cmnd;
    private String vehicle;
    private String vehicleNumber;
    private String chairNumber;
    private int dayStart;
    private int monthStart;
    private int yearStart;
    private int dayEnd;
    private int monthEnd;
    private int yearEnd;
    private String destination;
    private Address address;
    private Symtom symtom;
    private Exposure exposure;

    public FormNCoV(String name, int birthYear, int gender, int country, int cmnd, String vehicle, String vehicleNumber, String chairNumber, int dayStart, int monthStart, int yearStart, int dayEnd, int monthEnd, int yearEnd, String destination, Address address, Symtom symtom, Exposure exposure) {
        this.name = name;
        this.birthYear = birthYear;
        this.gender = gender;
        this.country = country;
        this.cmnd = cmnd;
        this.vehicle = vehicle;
        this.vehicleNumber = vehicleNumber;
        this.chairNumber = chairNumber;
        this.dayStart = dayStart;
        this.monthStart = monthStart;
        this.yearStart = yearStart;
        this.dayEnd = dayEnd;
        this.monthEnd = monthEnd;
        this.yearEnd = yearEnd;
        this.destination = destination;
        this.address = address;
        this.symtom = symtom;
        this.exposure = exposure;
    }
    public FormNCoV(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getCountry() {
        return country;
    }

    public void setCountry(int country) {
        this.country = country;
    }

    public int getCmnd() {
        return cmnd;
    }

    public void setCmnd(int cmnd) {
        this.cmnd = cmnd;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getChairNumber() {
        return chairNumber;
    }

    public void setChairNumber(String chairNumber) {
        this.chairNumber = chairNumber;
    }

    public int getDayStart() {
        return dayStart;
    }

    public void setDayStart(int dayStart) {
        this.dayStart = dayStart;
    }

    public int getMonthStart() {
        return monthStart;
    }

    public void setMonthStart(int monthStart) {
        this.monthStart = monthStart;
    }

    public int getYearStart() {
        return yearStart;
    }

    public void setYearStart(int yearStart) {
        this.yearStart = yearStart;
    }

    public int getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(int dayEnd) {
        this.dayEnd = dayEnd;
    }

    public int getMonthEnd() {
        return monthEnd;
    }

    public void setMonthEnd(int monthEnd) {
        this.monthEnd = monthEnd;
    }

    public int getYearEnd() {
        return yearEnd;
    }

    public void setYearEnd(int yearEnd) {
        this.yearEnd = yearEnd;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Symtom getSymtom() {
        return symtom;
    }

    public void setSymtom(Symtom symtom) {
        this.symtom = symtom;
    }

    public Exposure getExposure() {
        return exposure;
    }

    public void setExposure(Exposure exposure) {
        this.exposure = exposure;
    }
}
