package com.example.controller;

import com.example.model.Music;
import com.example.model.MusicForm;
import com.example.service.HibernateMusicService;
import com.example.service.MusicService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;

@Controller
public class MusicController {
    private MusicService musicService = new HibernateMusicService();
    @Value("${music-upload}")
    private String fileUpload;

    @GetMapping("")
    private String showAllList(Model model){
        List<Music> music = musicService.findAllMusic();
        model.addAttribute("musics",music);
        return "index";
    }
    @GetMapping("/create")
    private String directMusic(Model model){
        model.addAttribute("music",new MusicForm());
        return "create";
    }
    @PostMapping("/save")
    private String saveMusic(@ModelAttribute MusicForm musicForm) throws IOException {
        MultipartFile multipartFile = musicForm.getMultipartFile();
        String fileName = "music "+ (Math.random()*1000+1000) +".mp3";
        FileCopyUtils.copy(musicForm.getMultipartFile().getBytes(),new File(fileUpload+fileName));
        Music music = new Music();
        music.setName(musicForm.getName());
        music.setCategory(musicForm.getCategory());
        music.setArtist(musicForm.getArtist());
        music.setPath(fileName);
        musicService.createMusic(music);
        return "redirect:/";
    }
    @GetMapping("/{id}/delete")
    private String deleteMusic(@PathVariable long id){
        musicService.deleteMusic(id);
        return "redirect:/";
    }
    @GetMapping("/{id}/edit")
    private String updateMusic(@PathVariable long id, Model model){
        Music music = musicService.findMusicById(id);
        MusicForm musicForm = new MusicForm(id, music.getName(), music.getCategory(), music.getArtist(), music.getPath(), null);
        model.addAttribute("music", musicForm);
        return "edit";
    }
    @PostMapping("/{id}/update")
    private String editMusic(@PathVariable long id, @ModelAttribute MusicForm musicForm) throws IOException {
        MultipartFile multipartFile = musicForm.getMultipartFile();
        String fileName = musicForm.getPath();
        FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload+fileName));
        Music music = new Music();
        music.setId(id);
        music.setName(musicForm.getName());
        music.setCategory(musicForm.getCategory());
        music.setArtist(musicForm.getArtist());
        music.setPath(musicForm.getPath());
        musicService.update(music,id);
        return "redirect:/";
    }
}
