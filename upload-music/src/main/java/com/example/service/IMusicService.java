package com.example.service;

import com.example.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();
    Music findById(int id);
    void updateMusic(int id, Music music);
    void removeMusic(int id);
    void addMusic(Music music);
}
