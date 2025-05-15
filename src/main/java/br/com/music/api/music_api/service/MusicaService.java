package br.com.music.api.music_api.service;

import br.com.music.api.music_api.model.Musica;
import br.com.music.api.music_api.repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class MusicaService {

    public Musica atualizarDuracaoMusica(Long id, String duracao) {

        var musicaAtualizada = buscarMusicaPorId(id);
        musicaAtualizada.setDuracao(duracao);

        return musicaRepository.save(musicaAtualizada);


    }

    private Musica buscarMusicaPorId(Long id) {

        var musica = musicaRepository.findById(id);

        return musica.orElseThrow(() -> new EmptyResultDataAccessException(1));
    }



    @Autowired
    MusicaRepository musicaRepository;
}
