package com.example.service;

import com.example.model.User;

import java.util.HashMap;
import java.util.List;

public class UserService {
    public static List<User> listUser;
    public static boolean init;
    public boolean register(User user){
        for(int i=0; i<listUser.size(); i++){
            if(user.getName().equals(listUser.get(i).getName())){
                return false;
            }
        }
        return true;
    }
    public User login(User user){
        for(int i=0; i<listUser.size(); i++){
            if(user.getName().equals(listUser.get(i).getName()) && user.getPassword().equals(listUser.get(i).getPassword())){
                return user;
            }
        }
        return null;
    }
    public List<User> getListUser(){
        return listUser;
    }
}
