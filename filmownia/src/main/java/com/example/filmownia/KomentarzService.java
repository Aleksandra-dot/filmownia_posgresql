package com.example.filmownia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KomentarzService {
    private KomentarzRepository komentarzRepository;
    @Autowired
    public  KomentarzService(KomentarzRepository komentarzRepository) {
        this.komentarzRepository = komentarzRepository;
    }

    public List<Komentarz> getKomentarze() {
        return komentarzRepository.findAll();
    }


}
