package br.com.music.api.music_api.controller;

import br.com.music.api.music_api.model.Musica;
import br.com.music.api.music_api.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/musica")
public class MusicaController {

    @GetMapping
    public List<Musica> listarMusica() {
        return musicaRepository.findAll();
    }


    @Autowired
    MusicaRepository musicaRepository;
}
