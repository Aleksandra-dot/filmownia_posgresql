package com.example.filmownia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OsobaService {

    private final OsobaRepository osobaRepository;
    @Autowired

    public OsobaService(OsobaRepository osobaRepository) {
        this.osobaRepository = osobaRepository;
    }

    public List<Osoba> getOsoby() {
        return osobaRepository.findAll();
    }
    public Optional<Osoba> getOsobaById(Long id){ return osobaRepository.findById(id);}

}
