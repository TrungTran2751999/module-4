package com.example.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class Music {
    private int id;
    private String name;
    private String category;
    private String music;
    private MultipartFile multipartFile;

    public Music(int id, String name, String category, String music) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.music = music;
    }

    public Music(int id, String name, String category, MultipartFile multipartFile) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.multipartFile = multipartFile;
    }
    public Music(){}
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getMusic() {
        return music;
    }

    public void setMusic(String music) {
        this.music = music;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
