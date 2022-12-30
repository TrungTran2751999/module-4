package com.example.controller;

import com.example.model.Music;
import com.example.service.IMusicService;
import com.example.service.MusicService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MusicController {
    private IMusicService musicService = new MusicService();
    @Value("${music-upload}")
    private String musicUpload;
    @GetMapping("")
    private String showAllMusic(Model model){
        if(!MusicService.init){
            MusicService.listMusic = new ArrayList<>();
            MusicService.init = true;
        }
        List<Music> listMusic = musicService.findAll();
        model.addAttribute("list",listMusic);
        return "index";
    }
    @PostMapping("/save")
    private String createMusic(@ModelAttribute("music") Music music, Model model) throws IOException {
        MultipartFile multipartFile = music.getMultipartFile();
        String fileMusic = multipartFile.getOriginalFilename();
        FileCopyUtils .copy(music.getMultipartFile().getBytes(), new File(musicUpload+fileMusic));
        int id = (int) (Math.random()*1000+1000);
        Music newMusic = new Music(id, music.getName(), music.getCategory(), fileMusic);
        musicService.addMusic(newMusic);
        return "redirect:/";
    }
    @GetMapping("/create")
    private String directCreateMusic(Model model){
        model.addAttribute("music",new Music());
        return "create";
    }
}

