package com.example.model;

public class Address {
    private String province;
    private String district;
    private String guild;
    private String address;
    private String phone;
    private String email;

    public Address(String province, String district, String guild, String address, String phone, String email) {
        this.province = province;
        this.district = district;
        this.guild = guild;
        this.address = address;
        this.phone = phone;
        this.email = email;
    }
    public Address(){}
    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getGuild() {
        return guild;
    }

    public void setGuild(String guild) {
        this.guild = guild;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
