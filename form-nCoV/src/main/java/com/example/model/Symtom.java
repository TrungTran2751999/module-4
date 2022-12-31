package com.example.model;

public class Symtom {
    private String sick;
    private String cough;
    private String stuffy;
    private String soreThroat;
    private String vomit;
    private String diarrhea;
    private String hemorrhage;
    private String rash;

    public Symtom(String sick, String cough, String stuffy, String soreThroat, String vomit, String diarrhea, String hemorrhage, String rash) {
        this.sick = sick;
        this.cough = cough;
        this.stuffy = stuffy;
        this.soreThroat = soreThroat;
        this.vomit = vomit;
        this.diarrhea = diarrhea;
        this.hemorrhage = hemorrhage;
        this.rash = rash;
    }
    public Symtom(){}

    public String getSick() {
        return sick;
    }

    public void setSick(String sick) {
        this.sick = sick;
    }

    public String getCough() {
        return cough;
    }

    public void setCough(String cough) {
        this.cough = cough;
    }

    public String getStuffy() {
        return stuffy;
    }

    public void setStuffy(String stuffy) {
        this.stuffy = stuffy;
    }

    public String getSoreThroat() {
        return soreThroat;
    }

    public void setSoreThroat(String soreThroat) {
        this.soreThroat = soreThroat;
    }

    public String getVomit() {
        return vomit;
    }

    public void setVomit(String vomit) {
        this.vomit = vomit;
    }

    public String getDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(String diarrhea) {
        this.diarrhea = diarrhea;
    }

    public String getHemorrhage() {
        return hemorrhage;
    }

    public void setHemorrhage(String hemorrhage) {
        this.hemorrhage = hemorrhage;
    }

    public String getRash() {
        return rash;
    }

    public void setRash(String rash) {
        this.rash = rash;
    }
}
