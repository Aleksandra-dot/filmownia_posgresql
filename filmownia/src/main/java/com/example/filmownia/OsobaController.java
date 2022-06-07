package com.example.filmownia;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="api/v1/osoba")
public class OsobaController {

    private final OsobaService osobaService;
    @Autowired

    public OsobaController(OsobaService osobaService) {
        this.osobaService = osobaService;
    }

    @GetMapping
    public List<Osoba> getOsoby() {
        return osobaService.getOsoby();
    }
    public Optional<Osoba> getOsobaById(Long id){ return osobaService.getOsobaById(id);}

}
