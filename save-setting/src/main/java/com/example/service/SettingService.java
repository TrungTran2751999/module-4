package com.example.service;

import com.example.model.Setting;

public class SettingService {
    public static Setting initSetting = new Setting("Tieng ziet", 25, false, "Trung");
    public static boolean init;
    public Setting loadInit(){
        return initSetting;
    }
    public void saveSetting(Setting setting){
        initSetting.setLanguage(setting.getLanguage());
        initSetting.setPageSize(setting.getPageSize());
        initSetting.setSpamFilter(setting.isSpamFilter());
        initSetting.setSignature(setting.getSignature());
    }
}
