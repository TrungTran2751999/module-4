package com.example.service;

import com.example.model.Music;
import org.springframework.stereotype.Service;

import java.util.List;

public interface MusicService {
    List<Music> findAllMusic();
    Music findMusicById(long id);
    void createMusic(Music music);
    void update(Music music, long id);
    void deleteMusic(long id);
}
