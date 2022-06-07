package com.example.filmownia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UzytkownikService {


    private final UzytkownikRepository uzytkownikRepository;
    @Autowired
    public UzytkownikService(UzytkownikRepository uzytkownikRepository) {
        this.uzytkownikRepository = uzytkownikRepository;
    }

    public List<Uzytkownik> getUzytkownikow() {
        return uzytkownikRepository.findAll();
    }
    public Optional<Uzytkownik> getUserById(Long id){ return uzytkownikRepository.findById(id);}
}

