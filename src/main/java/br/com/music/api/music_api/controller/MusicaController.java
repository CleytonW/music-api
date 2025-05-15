package br.com.music.api.music_api.controller;

import br.com.music.api.music_api.model.Musica;
import br.com.music.api.music_api.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/musica")
public class MusicaController {

    @GetMapping
    public List<Musica> listarMusica() {
        return musicaRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Musica> cadastrarMusica(@RequestBody Musica musica, UriComponentsBuilder builder) {
        var musicaSalva = musicaRepository.save(musica);

        URI uri = builder.path("/musica/{id}").buildAndExpand(musica.getId()).toUri();

        return ResponseEntity.created(uri).body(musicaSalva);
    }

    @DeleteMapping("/{id}")
    public void deletarMusica(@PathVariable Long id) {
        musicaRepository.deleteById(id);
    }

    @Autowired
    MusicaRepository musicaRepository;
}
