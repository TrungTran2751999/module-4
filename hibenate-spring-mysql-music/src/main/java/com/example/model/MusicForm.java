package com.example.model;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm extends Music {
    private long id;
    private String name;
    private String category;
    private String artist;
    private String path;
    private MultipartFile multipartFile;

    public MusicForm(long id, String name, String category, String artist, String path, MultipartFile multipartFile) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.artist = artist;
        this.path = path;
        this.multipartFile = multipartFile;
    }
    public MusicForm(){}
    @Override
    public long getId() {
        return id;
    }

    @Override
    public void setId(long id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String getArtist() {
        return artist;
    }

    @Override
    public void setArtist(String artist) {
        this.artist = artist;
    }

    @Override
    public String getPath() {
        return path;
    }

    @Override
    public void setPath(String path) {
        this.path = path;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
