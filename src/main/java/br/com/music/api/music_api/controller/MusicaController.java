package br.com.music.api.music_api.controller;

import br.com.music.api.music_api.model.Musica;
import br.com.music.api.music_api.repository.MusicaRepository;
import br.com.music.api.music_api.service.MusicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/musica")
public class MusicaController {

    @GetMapping
    public List<Musica> listarMusica() {
        return musicaRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Musica> buscarMusicaPeloID (@PathVariable Long id) {

        Optional<Musica> musicaOpt = musicaRepository.findById(id);

        if (musicaOpt.isPresent()) {
            return ResponseEntity.ok(musicaOpt.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Musica> cadastrarMusica(@RequestBody Musica musica, UriComponentsBuilder builder) {
        var musicaSalva = musicaRepository.save(musica);

        URI uri = builder.path("/musica/{id}").buildAndExpand(musica.getId()).toUri();

        return ResponseEntity.created(uri).body(musicaSalva);
    }

    @PutMapping("{id}/atualizar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarDuracaoMusica(@PathVariable Long id, @RequestBody String duracao) {
        musicaService.atualizarDuracaoMusica(id, duracao);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarMusica(@PathVariable Long id) {
        musicaRepository.deleteById(id);
    }

    @Autowired
    MusicaService musicaService;

    @Autowired
    MusicaRepository musicaRepository;
}
