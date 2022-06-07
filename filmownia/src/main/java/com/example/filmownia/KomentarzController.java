package com.example.filmownia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path="api/v1/komentarz")
public class KomentarzController {

    private final KomentarzService komentarzService;

    @Autowired
    public KomentarzController(KomentarzService komentarzService) {
        this.komentarzService = komentarzService;
    }

    @GetMapping
    public List<Komentarz> getKomentarze(){
        return komentarzService.getKomentarze();
    }

}
