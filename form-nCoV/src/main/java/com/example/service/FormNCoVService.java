package com.example.service;

import com.example.model.FormNCoV;

import java.util.ArrayList;
import java.util.List;

public class FormNCoVService {
    public static FormNCoV formNCoV;
    public static boolean init;
    public static String[] vehicle = {"Tàu bay", "Tàu thuyn", "Ô tô", "Khác"};
    public static String[] province = {"Thua Thien Hue", "Ha Noi", "Sai Gon"};
    public static String[] district = {"Phu Vang", "Phu Loc", "Phu Hai"};
    public static String[] guild = {"Quan 1", "Quan 2", "Quan 3"};
    public static Boolean[] yesNo = {true, true};
    public static Integer[] date = new Integer[31];
    public static Integer[] month = new Integer[12];
    public static Integer[] year = new Integer[10];
    public static List<String> symton = new ArrayList<>();
    public static List<String> exposure = new ArrayList<>();
    public void createAndUpdateForm(FormNCoV formNCoV){
        FormNCoVService.formNCoV = formNCoV;
    }
    public void insertDate(){
        for(int i=1; i<=31; i++){
            FormNCoVService.date[i-1] = i;
        }
        for(int i=1; i<=12; i++){
            FormNCoVService.month[i-1]=i;
        }
        for(int i=1; i<=10; i++){
            FormNCoVService.year[i-1] = i+2010;
        }
    }
}
