package com.example.service;

import com.example.model.Music;

import java.util.List;

public class MusicService implements IMusicService {
    public static List<Music> listMusic;
    public static boolean init;

    @Override
    public List<Music> findAll() {
        return listMusic;
    }

    @Override
    public Music findById(int id) {
        for(int i=0; i<listMusic.size(); i++){
            if(listMusic.get(i).getId() == id){
                return listMusic.get(i);
            }
        }
        return null;
    }

    @Override
    public void updateMusic(int id, Music music) {
        for(int i=0; i<listMusic.size(); i++){
            if(listMusic.get(i).getId() == id){
                listMusic.set(i, music);
            }
        }
    }

    @Override
    public void removeMusic(int id) {
        for(int i=0; i<listMusic.size(); i++){
            if(listMusic.get(i).getId() == id){
                listMusic.remove(i);
            }
        }
    }

    @Override
    public void addMusic(Music music) {
        listMusic.add(music);
    }
}
