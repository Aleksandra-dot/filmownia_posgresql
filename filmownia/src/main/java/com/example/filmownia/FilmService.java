package com.example.filmownia;

import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class FilmService {

    private final FilmRepository filmRepository;

    public FilmService(FilmRepository filmRepository) {
        this.filmRepository = filmRepository;
    }

    public List<Film> getFilms(){
        return filmRepository.findAll();
    }
    public void addKomentarz(Komentarz k){

    }
}
