package br.com.music.api.music_api.repository;

import br.com.music.api.music_api.model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MusicaRepository extends JpaRepository<Musica, Long> {

}
